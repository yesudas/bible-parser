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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import in.wordofgod.bible.parser.vosgson.Book;
import in.wordofgod.bible.parser.vosgson.BookName;
import in.wordofgod.bible.parser.vosgson.Chapter;
import in.wordofgod.bible.parser.vosgson.Verse;

/**
 * @author YesudasS
 *
 */
public class BibleLoaderUtils {

	public static Bible getBible(String bibleFilePath, String bookNamesFilePath, String shortBookNamesFilePath,
			String bibleInfoFilePath) {
		File fileDir = new File(bibleFilePath);
		Properties bookNames = loadBookNames(bookNamesFilePath);
		Properties shortBookNames = loadBookNames(shortBookNamesFilePath);
		Properties bibleInfo = loadBookNames(bibleInfoFilePath);
		Bible bible = getBible(fileDir, bookNames, shortBookNames, bibleInfo);
		return bible;
	}

	private static Bible getBible(File fileDir, Properties bookNames, Properties shortBookNames, Properties bibleInfo) {
		if (shortBookNames == null) {
			shortBookNames = new Properties();
		}
		Bible bible = new Bible();
		loadBibleInfo(bible, bibleInfo);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String line = null;
			Map<String, Book> bookMap = new HashMap<>();
			Map<String, Chapter> chapterMap = new HashMap<>();
			while ((line = br.readLine()) != null) {
				String[] columns = line.split("\\t");
				int bookNo = 1;
				try {
					bookNo = Integer.parseInt(columns[0]);
				} catch (NumberFormatException e) {
					bookNo = 1;
				}
				String bookName = columns[1];
				String chapterNo = columns[2];
				String verseNo = columns[3];
				String text = "Not Available";
				if (columns.length > 4) {
					text = columns[4];
				}
				Book book = null;
				Chapter chapter = null;
				if (bookMap.containsKey(bookName)) {
					book = bookMap.get(bookName);
				} else {
					String bookNameToDisplay = bookNames.getProperty(bookName);
					String shortBookNameToDisplay = shortBookNames.getProperty(bookName);
					if (bookNameToDisplay == null || bookNameToDisplay.isEmpty()) {
						System.out.println("Could Not Get the Matching Book Name for the book :: " + bookName);
					}
					if (shortBookNameToDisplay == null || shortBookNameToDisplay.isEmpty()) {
						System.out.println("Could Not Get the Matching Short Book Name for the book :: " + bookName);
					}
					bible.getBookNames().add(new BookName(bookName, bookNameToDisplay, shortBookNameToDisplay));
					book = new Book(bookNo, bookName, bookNameToDisplay, new ArrayList<Chapter>());
					bookMap.put(bookName, book);
					bible.getBooks().add(book);
				}
				if (chapterMap.containsKey(bookName + chapterNo)) {
					chapter = chapterMap.get(bookName + chapterNo);
				} else {
					chapter = new Chapter(chapterNo, new ArrayList<Verse>());
					chapterMap.put(bookName + chapterNo, chapter);
					book.getChapters().add(chapter);
				}
				chapter.getVerses().add(new Verse(verseNo, text));
			}

			for (BookName bookName : bible.getBookNames()) {
				bookName.setChapters(bookMap.get(bookName.getName()).getChapters().size());
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bible;
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
		return bible;
	}

	private static Properties loadBookNames(String bookNamesFilePath) {
		Properties bookNames = null;

		BufferedReader propertyReader;
		try {
			propertyReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(bookNamesFilePath)), "UTF8"));
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
