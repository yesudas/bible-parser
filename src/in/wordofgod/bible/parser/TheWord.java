/**
 * 
 */
package in.wordofgod.bible.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.wordofgod.bible.parser.vosgson.Book;
import in.wordofgod.bible.parser.vosgson.Chapter;
import in.wordofgod.bible.parser.vosgson.FormattedText;
import in.wordofgod.bible.parser.vosgson.FormattedText.FormattingInstructionKind;
import in.wordofgod.bible.parser.vosgson.FormattedText.LineBreakKind;
import in.wordofgod.bible.parser.vosgson.FormattedText.Visitor;
import in.wordofgod.bible.parser.vosgson.Verse;

/**
 * 
 */
public class TheWord {

	private static final BookID[] BOOK_ORDER = new BookID[66];

	public static final Set<BookID> COVERED_BOOKS = EnumSet.noneOf(BookID.class);

	static {
		for (int i = 0; i < BOOK_ORDER.length; i++) {
			BOOK_ORDER[i] = BookID.fromZefId(i + 1);
			COVERED_BOOKS.add(BOOK_ORDER[i]);
		}
	}

	private static int warningCount = 0;

	public static Bible getBible(String bibleFilePath, String bibleInfoFilePath) throws IOException {
		File inputFile = new File(bibleFilePath);
		Properties bibleInfo = loadBookInfo(bibleInfoFilePath);
		Bible bible = getBible(inputFile, bibleInfo);
		return bible;
	}

	private static Bible getBible(File inputFile, Properties bibleInfo) throws IOException {

		Bible bible = new Bible();
		loadBibleInfo(bible, bibleInfo);

		boolean hasOT = true, hasNT = true;
		if (inputFile.getName().toLowerCase().endsWith(".ot")) {
			hasNT = false;
			bible.setHasNT(false);
		} else if (inputFile.getName().toLowerCase().endsWith(".nt")) {
			hasOT = false;
			bible.setHasOT(false);
		}

		warningCount = 0;
		int bookCount = 1;
		int totalChaptersCount = 1;
		int totalVersesCount = 1;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"))) {
			for (BookID bid : BOOK_ORDER) {
				if ((bid.isNT() && !hasNT) || (!bid.isNT() && !hasOT))
					continue;
				Book bk = new Book(bid.getOsisID(), bibleInfo.getProperty("book.name." + bookCount),
						bibleInfo.getProperty("book.short.name." + bookCount),
						bibleInfo.getProperty("book.english.name." + bookCount), bid.getThreeLetterCode(),
						new ArrayList<Chapter>());
				bk.setBookNo(bookCount);
				bookCount++;
				// Book bk = new Book(bid.getOsisID(), bid, bid.getEnglishName(),
				// bid.getEnglishName());
				int[] verseCount = StandardVersification.KJV.getVerseCount(bid);
				for (int cnumber = 1; cnumber <= verseCount.length; cnumber++) {
					Chapter ch = new Chapter();
					ch.setChapter("" + cnumber);
					totalChaptersCount++;
					boolean hasVerses = false;
					int maxVerse = verseCount[cnumber - 1];
					for (int vnumber = 1; vnumber <= maxVerse; vnumber++) {
						String line = br.readLine();
						if (line == null) {
							line = "[Not avaiable in this version, check previous verse or next verse]";
						}
						if (line.startsWith("\uFEFF"))
							line = line.substring(1);
						if (line.equals("- - -") || line.trim().length() == 0)
							continue;
						line = line.replaceAll("  +", " ").trim();
						hasVerses = true;
						Verse v = new Verse("" + vnumber);
						v.setUnParsedText(line);
						if (line.contains("<WH") || line.contains("<WG")) {
							Matcher m = Pattern.compile("(<FI>[^<>]*<Fi>|<FO>[^<>]*<Fo>|[^<> ]*)((<W[GH][0-9]+>)+)")
									.matcher(line.replaceFirst("^(<W[GH][0-9]+x>)+", ""));
							StringBuffer sb = new StringBuffer();
							while (m.find()) {
								String word = m.group(1);
								String tags = m.group(2);
								m.appendReplacement(sb, "");
								sb.append("<S%" + tags.substring(2, tags.length() - 1).replaceAll("><W", "%") + ">");
								sb.append(word);
								sb.append("<s%>");
							}
							m.appendTail(sb);
							line = sb.toString();
						}
						int pos = parseLine(v.getAppendVisitor(), line, 0, null);
						if (pos != line.length())
							v.getAppendVisitor().visitText(line.substring(pos));
						v.setText(line);
						v.finished();
						ch.getVerses().add(v);
						totalVersesCount++;
					}
					if (hasVerses) {
						while (bk.getChapters().size() < cnumber - 1) {
							bk.getChapters().add(new Chapter());
						}
						if (bk.getChapters().size() != cnumber - 1)
							throw new RuntimeException();
						bk.getChapters().add(ch);
					}
				}
				if (bk.getChapters().size() > 0)
					bible.getBooks().add(bk);
			}
			bible.setTotalBooks(bookCount);
			bible.setTotalChapters(totalChaptersCount);
			bible.setTotalVerses(totalVersesCount);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		return bible;
	}

	private static int parseLine(Visitor<RuntimeException> visitor, String line, int pos, String endTag) {
		Visitor<RuntimeException> garbageVisitor = new FormattedText().getAppendVisitor();
		while (pos < line.length()) {
			if (line.charAt(pos) != '<') {
				int endPos = line.indexOf('<', pos);
				if (endPos == -1)
					endPos = line.length();
				visitor.visitText(line.substring(pos, endPos).replaceAll("[\r\n\t ]+", " "));
				pos = endPos;
				continue;
			}
			if (endTag != null && line.startsWith(endTag, pos))
				break;
			if (pos + 2 < line.length() && line.charAt(pos + 2) == '>' && "bius".indexOf(line.charAt(pos + 1)) != -1) {
				String newEndTag = "</" + line.charAt(pos + 1) + ">";
				if (parseLine(garbageVisitor, line, pos + 3, newEndTag) != -1) {
					FormattingInstructionKind kind;
					switch (line.charAt(pos + 1)) {
					case 'b':
						kind = FormattingInstructionKind.BOLD;
						break;
					case 'i':
						kind = FormattingInstructionKind.ITALIC;
						break;
					case 'u':
						kind = FormattingInstructionKind.UNDERLINE;
						break;
					case 's':
						kind = FormattingInstructionKind.STRIKE_THROUGH;
						break;
					default:
						throw new RuntimeException("Cannot happen");
					}
					pos = parseLine(visitor.visitFormattingInstruction(kind), line, pos + 3, newEndTag);
					continue;
				}
			} else if (line.startsWith("<sub>", pos) || line.startsWith("<sup>", pos)) {
				String newEndTag = "</" + line.substring(pos + 1, pos + 5);
				if (parseLine(garbageVisitor, line, pos + 5, newEndTag) != -1) {
					FormattingInstructionKind kind = line.charAt(pos + 3) == 'p' ? FormattingInstructionKind.SUPERSCRIPT
							: FormattingInstructionKind.SUBSCRIPT;
					pos = parseLine(visitor.visitFormattingInstruction(kind), line, pos + 5, newEndTag);
					continue;
				}
			} else if (line.startsWith("<FR>", pos)) {
				if (parseLine(garbageVisitor, line, pos + 4, "<Fr>") != -1) {
					pos = parseLine(visitor.visitFormattingInstruction(FormattingInstructionKind.WORDS_OF_JESUS), line,
							pos + 4, "<Fr>");
					continue;
				}
			} else if (line.startsWith("<FO>", pos)) {
				if (parseLine(garbageVisitor, line, pos + 4, "<Fo>") != -1) {
					pos = parseLine(visitor.visitFormattingInstruction(FormattingInstructionKind.LINK), line, pos + 4,
							"<Fo>");
					continue;
				}
			} else if (line.startsWith("<font color=\"gray\">/</font>", pos)) {
				visitor.visitVerseSeparator();
				pos += 27;
				continue;
			} else if (line.startsWith("<CL>", pos)) {
				visitor.visitLineBreak(LineBreakKind.NEWLINE);
				pos += 4;
				continue;
			} else if (line.startsWith("<CM>", pos)) {
				visitor.visitLineBreak(LineBreakKind.PARAGRAPH);
				pos += 4;
				continue;
			} else if (line.startsWith("<CI><PI>", pos)) {
				visitor.visitLineBreak(LineBreakKind.NEWLINE_WITH_INDENT);
				pos += 8;
				continue;
			} else if (line.startsWith("<TS", pos) && pos + 3 < line.length()) {
				char next = line.charAt(pos + 3);
				int depth, len;
				if (next == '>') {
					depth = 1;
					len = 4;
				} else if (pos + 4 < line.length() && line.charAt(pos + 4) == '>' && next >= '1' && next <= '3') {
					depth = next - '0';
					len = 5;
				} else {
					depth = len = 0;
				}
				String end = "<Ts>", altEnd = len == 5 ? "<Ts" + next + ">" : "<Ts>";
				if (line.indexOf(altEnd, pos) != -1
						&& (line.indexOf(end, pos) == -1 || line.indexOf(altEnd, pos) < line.indexOf(end, pos)))
					end = altEnd;
				if (len > 0 && parseLine(garbageVisitor, line, pos + len, end) != -1) {
					pos = parseLine(visitor.visitHeadline(depth), line, pos + len, end);
					continue;
				}
			} else if (line.startsWith("<RF", pos)) {
				int closePos = line.indexOf('>', pos);
				if (parseLine(garbageVisitor, line, closePos + 1, "<Rf>") != -1) {
					pos = parseLine(visitor.visitFootnote(), line, closePos + 1, "<Rf>");
					continue;
				}
			} else if (line.startsWith("<FI>", pos)) {
				if (parseLine(garbageVisitor, line, pos + 4, "<Fi>") != -1) {
					pos = parseLine(visitor.visitFormattingInstruction(FormattingInstructionKind.ITALIC), line, pos + 4,
							"<Fi>");
					continue;
				}
			} else if (line.startsWith("<S%", pos)) {
				int closePos = line.indexOf('>', pos);
				if (parseLine(garbageVisitor, line, closePos + 1, "<s%>") != -1) {
					String[] strongs = line.substring(pos + 3, closePos).split("%");
					char[] strongNumberPrefixes = new char[strongs.length];
					int[] strongNumbers = new int[strongs.length];
					try {
						for (int i = 0; i < strongs.length; i++) {
							strongNumberPrefixes[i] = strongs[i].charAt(0);
							strongNumbers[i] = Integer.parseInt(strongs[i].substring(1));
						}
						pos = parseLine(
								visitor.visitGrammarInformation(strongNumberPrefixes, strongNumbers, null, null), line,
								closePos + 1, "<s%>");
						continue;
					} catch (NumberFormatException ex) {
						// malformed Strongs tag
					}
				}
			} else if (line.startsWith("<XWG", pos) || line.startsWith("<XWH", pos)) {
				int closePos = line.indexOf('>', pos);
				try {
					int number = Integer.parseInt(line.substring(pos + 4, closePos));
					visitor.visitGrammarInformation(new char[] { line.charAt(pos + 3) }, new int[] { number }, null,
							null);
					pos = closePos + 1;
					continue;
				} catch (NumberFormatException ex) {
					System.out.println("WARNING: Invalid Strong number in tag " + line.substring(pos, closePos + 1));
					warningCount++;
				}
			} else if (line.startsWith("<WT", pos)) {
				// TODO parse morph information
			} else if (line.startsWith("<RX", pos)) {
				// TODO parse cross references
			} else if (line.startsWith("<CI>", pos) || line.startsWith("<PF", pos) || line.startsWith("<PI", pos)) {
				// extra formatting not supported by BMC
			} else if (warningCount < 100) {
				System.out.println(
						"WARNING: Skipping unknown tag " + line.substring(pos, Math.min(pos + 20, line.length())));
				warningCount++;
			}

			// the tag is not supported (yet), skip the first character
			visitor.visitText("<");
			pos++;
		}

		if (endTag != null) {
			if (line.startsWith(endTag, pos))
				pos += endTag.length();
			else
				pos = -1;
		}
		return pos;
	}

	private static Bible loadBibleInfo(Bible bible, Properties bibleInfo) {
		bible.setAbbr(bibleInfo.getProperty("bible.info.abbr"));
		bible.setCommonName(bibleInfo.getProperty("bible.info.commonName"));
		bible.setShortName(bibleInfo.getProperty("bible.info.shortName"));
		bible.setLongName(bibleInfo.getProperty("bible.info.longName"));
		bible.setLongEnglishName(bibleInfo.getProperty("bible.info.longEnglishName"));
		bible.setLanguageCode(bibleInfo.getProperty("bible.info.languageCode"));
		bible.setPublishedYear(bibleInfo.getProperty("bible.info.publishedYear"));
		bible.setPublishedBy(bibleInfo.getProperty("bible.info.publishedBy"));
		bible.setTranslatedBy(bibleInfo.getProperty("bible.info.translatedBy"));
		bible.setCopyRight(bibleInfo.getProperty("bible.info.copyRight"));
		bible.setAdditionalInformation(bibleInfo.getProperty("bible.info.additionalInformation"));
		return bible;
	}

	private static Properties loadBookInfo(String bibleInfoFilePath) {
		Properties bookNames = null;

		BufferedReader propertyReader;
		try {
			propertyReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(bibleInfoFilePath)), "UTF8"));
			bookNames = new Properties();
			bookNames.load(propertyReader);
			propertyReader.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bookNames == null) {
				bookNames = new Properties();
			}
		}
		return bookNames;
	}

}