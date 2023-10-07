/**
 * 
 */
package in.wordofgod.bible.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class BookIdentifier {

	private static Map<String, Object> booksMap = new HashMap<String, Object>();

	static {
		for (BookID bookID : BookID.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
		for (BookIDTamilVersion1 bookID : BookIDTamilVersion1.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
		for (BookIDTamilVersion2 bookID : BookIDTamilVersion2.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
		for (BookIDTamilVersion3 bookID : BookIDTamilVersion3.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
		for (BookIDTamilVersion4 bookID : BookIDTamilVersion4.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
		for (BookIDTamilVersion5 bookID : BookIDTamilVersion5.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
			booksMap.put(bookID.getThreeLetterCode().trim(), bookID);
		}
		for (BookIDTamilVersion6 bookID : BookIDTamilVersion6.values()) {
			booksMap.put(bookID.getEnglishName().trim(), bookID);
		}
	}

	public static BookInfo getBookInfo(String bookName) {
		if (bookName == null) {
			return null;
		}
		bookName = bookName.trim();
		Object bookObj = booksMap.get(bookName);
		if (bookObj == null) {
			System.out.println("Unable to find suitable bookObj for: " + bookName);
			bookName = bookName.replace("I", "1").replace("II", "2").replace(",", "");
			System.out.println("Trying for: " + bookName);
			bookObj = booksMap.get(bookName);
			System.out.println("Result: " + bookObj);
			if (bookObj == null) {
				return null;
			}
		}
		if (bookObj instanceof BookID) {
			BookID obj = (BookID) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion1) {
			BookIDTamilVersion1 obj = (BookIDTamilVersion1) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion2) {
			BookIDTamilVersion2 obj = (BookIDTamilVersion2) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion3) {
			BookIDTamilVersion3 obj = (BookIDTamilVersion3) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion4) {
			BookIDTamilVersion4 obj = (BookIDTamilVersion4) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion5) {
			BookIDTamilVersion5 obj = (BookIDTamilVersion5) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else if (bookObj instanceof BookIDTamilVersion6) {
			BookIDTamilVersion6 obj = (BookIDTamilVersion6) bookObj;
			return new BookInfo(obj.getOsisID(), obj.isNT(), obj.getZefID(), obj.getEnglishName(),
					obj.getThreeLetterCode(), obj.getMyBibleZoneId());
		} else {
			return null;
		}
	}

}
