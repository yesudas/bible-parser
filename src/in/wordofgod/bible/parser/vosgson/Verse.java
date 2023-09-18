
package in.wordofgod.bible.parser.vosgson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verse extends FormattedText {

	@SerializedName("no")
	@Expose
	private String number;

	@SerializedName("text")
	@Expose
	private String text;
	
	@SerializedName("unParsedText")
	@Expose
	private String unParsedText;
	

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Verse() {
	}

	public Verse(String number) {
		super();
		this.number = number;
	}

	/**
	 * @param no
	 * @param text
	 */
	public Verse(String number, String text) {
		super();
		this.number = number;
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the unParsedText
	 */
	public String getUnParsedText() {
		return unParsedText;
	}

	/**
	 * @param unParsedText the unParsedText to set
	 */
	public void setUnParsedText(String unParsedText) {
		this.unParsedText = unParsedText;
	}
}
