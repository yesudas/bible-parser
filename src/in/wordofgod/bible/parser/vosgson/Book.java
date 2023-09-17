
package in.wordofgod.bible.parser.vosgson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import in.wordofgod.bible.parser.Bible;
import in.wordofgod.bible.parser.BookID;
import in.wordofgod.bible.parser.Utils;

public class Book {

	private BookID id;
	
	@SerializedName("bookNo")
	@Expose
	private int bookNo;
	
	@SerializedName("bookId")
	@Expose
	private String bookId;

	@SerializedName("abbr")
	@Expose
	private String abbr;
	
	@SerializedName("shortName")
	@Expose
	private String shortName;

	@SerializedName("longName")
	@Expose
	private String longName;

	@SerializedName("englishName")
	@Expose
	private String englishName;

	@SerializedName("threeLetterCode")
	@Expose
	private String threeLetterCode;

	@SerializedName("chapters")
	@Expose
	private List<Chapter> chapters = new ArrayList<Chapter>();
	
	public Book(String abbr, BookID id, String shortName, String longName, String englishName) {
		this.abbr = Utils.validateString("abbr", abbr, Utils.BOOK_ABBR_REGEX);
		this.id = Utils.validateNonNull("id", id);
		this.shortName = Utils.validateString("shortName", shortName, Utils.NORMALIZED_WHITESPACE_REGEX);
		this.longName = Utils.validateString("longName", longName, Utils.NORMALIZED_WHITESPACE_REGEX);
		this.englishName = englishName;
		this.chapters = new ArrayList<Chapter>();
	}

	public void validate(Bible bible, List<String> danglingReferences, Map<String, Set<String>> dictionaryEntries, Map<String, Set<FormattedText.ValidationCategory>> validationCategories) {
		if (chapters.size() == 0)
			FormattedText.ValidationCategory.BOOK_WITHOUT_CHAPTERS.throwOrRecord(getAbbr(), validationCategories, getAbbr());
		Chapter lastChapter = chapters.get(chapters.size() - 1);
		if (lastChapter.getVerses().size() == 0 && lastChapter.getProlog() == null)
			FormattedText.ValidationCategory.LAST_CHAPTER_WITHOUT_CONTENT.throwOrRecord(getAbbr(), validationCategories, getAbbr());
		int cnumber = 0;
		for (Chapter chapter : chapters) {
			cnumber++;
			chapter.validate(bible, getId(), getAbbr(), cnumber, danglingReferences, dictionaryEntries, validationCategories);
		}
	}

	public String getAbbr() {
		return abbr;
	}

	public BookID getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public String getLongName() {
		return longName;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Book() {
		this.id = null;
	}

	public Book(int bookNo, String longName, String shortName, List<Chapter> chapters) {
		super();
		this.bookNo = bookNo;
		this.longName = longName;
		this.shortName = shortName;
		this.chapters = chapters;
		this.id = null;
	}

	public Book(String osisID, String longName, String shortName, String englishName, ArrayList<Chapter> chapters) {
		this.bookId = osisID;
		this.longName = longName;
		this.shortName = shortName;
		this.englishName = englishName;
		this.chapters = chapters;
	}
	
	public Book(String osisID, String longName, String shortName, String englishName, String threeLetterCode, ArrayList<Chapter> chapters) {
		this.bookId = osisID;
		this.longName = longName;
		this.shortName = shortName;
		this.englishName = englishName;
		this.threeLetterCode = threeLetterCode;
		this.chapters = chapters;
	}

	/**
	 * @return the bookNo
	 */
	public int getBookNo() {
		return bookNo;
	}

	/**
	 * @param bookNo the bookNo to set
	 */
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BookID id) {
		this.id = id;
	}

	/**
	 * @param abbr the abbr to set
	 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	 * @param shortName the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @param longName the longName to set
	 */
	public void setLongName(String longName) {
		this.longName = longName;
	}

	/**
	 * @param chapters the chapters to set
	 */
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	/**
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * @return the threeLetterCode
	 */
	public String getThreeLetterCode() {
		return threeLetterCode;
	}

	/**
	 * @param threeLetterCode the threeLetterCode to set
	 */
	public void setThreeLetterCode(String threeLetterCode) {
		this.threeLetterCode = threeLetterCode;
	}

}
