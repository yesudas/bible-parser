/**
 * 
 */
package in.wordofgod.bible.parser;

/**
 * 
 */
public class BookInfo {

	private final String osisID, name, shortName;
	private final int zefID;
	private final boolean nt;
	private final int myBibleZoneId;

	public BookInfo(String osisID, boolean nt, int zefID, String name, String shortName, int myBibleZoneId) {
		this.osisID = osisID;
		this.nt = nt;
		this.zefID = zefID;
		this.name = name;
		this.shortName = shortName;
		this.myBibleZoneId = myBibleZoneId;
	}

	/**
	 * @return the osisID
	 */
	public String getOsisID() {
		return osisID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @return the zefID
	 */
	public int getZefID() {
		return zefID;
	}

	/**
	 * @return the nt
	 */
	public boolean isNt() {
		return nt;
	}

	/**
	 * @return the myBibleZoneId
	 */
	public int getMyBibleZoneId() {
		return myBibleZoneId;
	}

}
