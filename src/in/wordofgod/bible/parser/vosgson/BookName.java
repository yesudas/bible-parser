
package in.wordofgod.bible.parser.vosgson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookName {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortname")
    @Expose
    private String shortname;

	@SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("chapters")
    @Expose
    private int chapters;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BookName() {
    }

	/**
	 * @param name
	 * @param display
	 */
	public BookName(String name, String displayname, String shortname) {
		super();
		this.name = name;
		this.displayname = displayname;
		this.shortname = shortname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
	}

	/**
	 * @return the shortname
	 */
	public String getShortname() {
		return shortname;
	}

	/**
	 * @param shortname the shortname to set
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
}
