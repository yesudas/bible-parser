/**
 * 
 */
package in.wordofgod.bible.parser;

import java.util.ArrayList;
import java.util.List;

import in.wordofgod.bible.parser.vosgson.Book;
import in.wordofgod.bible.parser.vosgson.BookName;

/**
 * @author YesudasS
 *
 */
public class Bible {

	private String abbr;
	private String commonName;
	private String shortName;
	private String longName;
	private String longEnglishName;
	private String languageCode;
	private String publishedYear;
	private String publishedBy;
	private String translatedBy;
	private String copyRight;
	private int totalBooks;
	private int totalChapters;
	private int totalVerses;
	private int totalWords;
	private int totalUniqueWords;
	
	private List<Book> books = new ArrayList<>();
	private List<BookName> bookNames = new ArrayList<BookName>();

	/**
	 * @return the abbr
	 */
	public String getAbbr() {
		return abbr;
	}

	/**
	 * @param abbr the abbr to set
	 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * @param commonName the commonName to set
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the longName
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}

	/**
	 * @return the longEnglishName
	 */
	public String getLongEnglishName() {
		return longEnglishName;
	}

	/**
	 * @param longEnglishName the longEnglishName to set
	 */
	public void setLongEnglishName(String longEnglishName) {
		this.longEnglishName = longEnglishName;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return the publishedYear
	 */
	public String getPublishedYear() {
		return publishedYear;
	}

	/**
	 * @param publishedYear the publishedYear to set
	 */
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}

	/**
	 * @return the publishedBy
	 */
	public String getPublishedBy() {
		return publishedBy;
	}

	/**
	 * @param publishedBy the publishedBy to set
	 */
	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	/**
	 * @return the translatedBy
	 */
	public String getTranslatedBy() {
		return translatedBy;
	}

	/**
	 * @param translatedBy the translatedBy to set
	 */
	public void setTranslatedBy(String translatedBy) {
		this.translatedBy = translatedBy;
	}

	/**
	 * @return the copyRight
	 */
	public String getCopyRight() {
		return copyRight;
	}

	/**
	 * @param copyRight the copyRight to set
	 */
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	/**
	 * @return the totalBooks
	 */
	public int getTotalBooks() {
		return totalBooks;
	}

	/**
	 * @param totalBooks the totalBooks to set
	 */
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}

	/**
	 * @return the totalChapters
	 */
	public int getTotalChapters() {
		return totalChapters;
	}

	/**
	 * @param totalChapters the totalChapters to set
	 */
	public void setTotalChapters(int totalChapters) {
		this.totalChapters = totalChapters;
	}

	/**
	 * @return the totalVerses
	 */
	public int getTotalVerses() {
		return totalVerses;
	}

	/**
	 * @param totalVerses the totalVerses to set
	 */
	public void setTotalVerses(int totalVerses) {
		this.totalVerses = totalVerses;
	}

	/**
	 * @return the totalWords
	 */
	public int getTotalWords() {
		return totalWords;
	}

	/**
	 * @param totalWords the totalWords to set
	 */
	public void setTotalWords(int totalWords) {
		this.totalWords = totalWords;
	}

	/**
	 * @return the totalUniqueWords
	 */
	public int getTotalUniqueWords() {
		return totalUniqueWords;
	}

	/**
	 * @param totalUniqueWords the totalUniqueWords to set
	 */
	public void setTotalUniqueWords(int totalUniqueWords) {
		this.totalUniqueWords = totalUniqueWords;
	}

	public Book getBook(String bookAbbr, BookID bookID) {
		for (Book book : books) {
			if (book.getAbbr().equals(bookAbbr) && book.getId() == bookID)
				return book;
			if (book.getAbbr().equals(bookAbbr) || book.getId() == bookID)
				throw new IllegalStateException("Partial match of xref book");
		}
		return null;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the bookNames
	 */
	public List<BookName> getBookNames() {
		return bookNames;
	}

	/**
	 * @param bookNames the bookNames to set
	 */
	public void setBookNames(List<BookName> bookNames) {
		this.bookNames = bookNames;
	}

}
