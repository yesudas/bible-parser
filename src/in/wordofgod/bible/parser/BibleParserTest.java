package in.wordofgod.bible.parser;

import in.wordofgod.bible.parser.vosgson.Book;
import in.wordofgod.bible.parser.vosgson.Chapter;
import in.wordofgod.bible.parser.vosgson.Verse;

public class BibleParserTest {

	public static String theWordBibleFilePath = "D:\\WOG\\synched-wog-bibles\\bibles-texts\\My-Source\\Tamil\\taOV.ont";
	public static String bibleFilePath = "D:\\WOG\\synched-wog-bibles\\bibles-texts\\My-Source\\Tamil\\taOV.txt";
	public static String bookNamesFilePath = "D:\\WOG\\synched-wog-bibles\\bibles-texts\\My-Source\\Tamil\\taOV-book-names.ini";
	public static String shortBookNamesFilePath = "D:\\WOG\\synched-wog-bibles\\bibles-texts\\My-Source\\Tamil\\taOV-book-short-names.ini";
	public static String bibleInfoFilePath = "D:\\WOG\\synched-wog-bibles\\bibles-texts\\My-Source\\Tamil\\taOV-information.ini";

	public static void main(String[] args) {
		loadWordOfGodBible();
		loadTheWordBible();
	}

	private static void loadWordOfGodBible() {
		System.out.println("Started Loading Bible");
		Bible bible = BibleLoaderUtils.getBible(bibleFilePath, bookNamesFilePath, shortBookNamesFilePath,
				bibleInfoFilePath);
		System.out.println("Completed Loading Bible");
		for (Book book : bible.getBooks()) {
			for (Chapter chapter : book.getChapters()) {
				for (Verse verse : chapter.getVerses()) {
					System.out.println(book.getBookNo() + " " + book.getShortName() + " " + chapter.getChapter() + ":"
							+ verse.getNumber() + " " + verse.getText());
				}
			}
		}
	}

	private static void loadTheWordBible() {
		System.out.println("Started Loading TheWord Bible");
		Bible bible = TheWord.getBible(theWordBibleFilePath, bibleInfoFilePath);
		for (Book book : bible.getBooks()) {
			for (Chapter chapter : book.getChapters()) {
				for (Verse verse : chapter.getVerses()) {
					System.out.println(book.getBookNo() + " " + book.getShortName() + " " + chapter.getChapter() + ":"
							+ verse.getNumber() + " " + verse.getText());
				}
			}
		}
		System.out.println("Completed Loading TheWord Bible");
	}
}