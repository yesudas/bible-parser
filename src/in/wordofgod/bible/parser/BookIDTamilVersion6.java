package in.wordofgod.bible.parser;

/**
 * ID for uniquely referring to a bible book.
 */
public enum BookIDTamilVersion6 {

	METADATA("x-Meta", false, -4, "Metadata", "Mta", 0),

	INTRODUCTION("x-Intr", false, -1, "Introduction", "Int", 0),
	INTRODUCTION_OT("x-IntrOT", false, -2, "Introduction OT", "IOT", 0),

	BOOK_Gen("Gen", false, 1, "ஆதி","ஆதி",10),
	BOOK_Exod("Exod", false, 2, "யாத்","யாத்",20),
	BOOK_Lev("Lev", false, 3, "லே","லேவி",30),
	BOOK_Num("Num", false, 4, "எண்","எண்",40),
	BOOK_Deut("Deut", false, 5, "உபா","உபா",50),
	BOOK_Josh("Josh", false, 6, "யோசு","யோசு",60),
	BOOK_Judg("Judg", false, 7, "நியா","நியா",70),
	BOOK_Ruth("Ruth", false, 8, "ரூ","ரூத்",80),
	BOOK_1Sam("1Sam", false, 9, "1சா","1 சாமு",90),
	BOOK_2Sam("2Sam", false, 10, "2சா","2 சாமு",100),
	BOOK_1Kgs("1Kgs", false, 11, "1இரா","1 இராஜா",110),
	BOOK_2Kgs("2Kgs", false, 12, "2இரா","2 இராஜா",120),
	BOOK_1Chr("1Chr", false, 13, "1நா","1 நாளா",130),
	BOOK_2Chr("2Chr", false, 14, "2நா","2 நாளா",140),
	BOOK_Ezra("Ezra", false, 15, "எஸ்றா","எஸ்றா",150),
	BOOK_Neh("Neh", false, 16, "நெ","நெகே",160),
	BOOK_Esth("Esth", false, 17, "எஸ்","எஸ்",190),
	BOOK_Job("Job", false, 18, "யோபு","யோபு",220),
	BOOK_Ps("Ps", false, 19, "சங்","சங்",230),
	BOOK_Prov("Prov", false, 20, "நீ","நீதி",240),
	BOOK_Eccl("Eccl", false, 21, "பிர","பிர",250),
	BOOK_Song("Song", false, 22, "உன்","உன்",260),
	BOOK_Isa("Isa", false, 23, "ஏ","ஏசா",290),
	BOOK_Jer("Jer", false, 24, "எரே","எரே",300),
	BOOK_Lam("Lam", false, 25, "பு","புல",310),
	BOOK_Ezek("Ezek", false, 26, "எசே","எசே",330),
	BOOK_Dan("Dan", false, 27, "தா","தானி",340),
	BOOK_Hos("Hos", false, 28, "ஓசி","ஓசி",350),
	BOOK_Joel("Joel", false, 29, "யோவேல்","யோவே",360),
	BOOK_Amos("Amos", false, 30, "ஆமோ","ஆயோ",370),
	BOOK_Obad("Obad", false, 31, "ஒப","ஒப",380),
	BOOK_Jonah("Jonah", false, 32, "யோனா","யோனா",390),
	BOOK_Mic("Mic", false, 33, "மீ","மீகா",400),
	BOOK_Nah("Nah", false, 34, "நா","நாகூம்",410),
	BOOK_Hab("Hab", false, 35, "ஆப","ஆப",420),
	BOOK_Zeph("Zeph", false, 36, "செ","செப்",430),
	BOOK_Hag("Hag", false, 37, "ஆகா","ஆகாய்",440),
	BOOK_Zech("Zech", false, 38, "சக","சக",450),
	BOOK_Mal("Mal", false, 39, "மல்","மல்",460),

	INTRODUCTION_NT("x-IntrNT", true, -3, "Introduction NT", "INT", 0),

	BOOK_Matt("Matt", true, 40, "மத்","மத்",470),
	BOOK_Mark("Mark", true, 41, "மாற்","மாற்",480),
	BOOK_Luke("Luke", true, 42, "லூ","லூக்",490),
	BOOK_John("John", true, 43, "யோவா","யோவா",500),
	BOOK_Acts("Acts", true, 44, "அ","அப்",510),
	BOOK_Rom("Rom", true, 45, "ரோ","ரோமர்",520),
	BOOK_1Cor("1Cor", true, 46, "1கொரிந்","1 கொரி",530),
	BOOK_2Cor("2Cor", true, 47, "2கொரிந்","2 கொரி",540),
	BOOK_Gal("Gal", true, 48, "கலா","கலா",550),
	BOOK_Eph("Eph", true, 49, "எபே","எபே",560),
	BOOK_Phil("Phil", true, 50, "பிலி","பிலி",570),
	BOOK_Col("Col", true, 51, "கொலோ","கொலோ",580),
	BOOK_1Thess("1Thess", true, 52, "1தெசலோ","1 தெச",590),
	BOOK_2Thess("2Thess", true, 53, "2தெசலோ","2 தெச",600),
	BOOK_1Tim("1Tim", true, 54, "1தீமோத்","1 தீமோ",610),
	BOOK_2Tim("2Tim", true, 55, "2தீமோத்","2 தீமோ",620),
	BOOK_Titus("Titus", true, 56, "தீ","தீத்து",630),
	BOOK_Phlm("Phlm", true, 57, "பிலே","பிலே",640),
	BOOK_Heb("Heb", true, 58, "எபி","எபி",650),
	BOOK_Jas("Jas", true, 59, "யாக்","யாக்",660),
	BOOK_1Pet("1Pet", true, 60, "1பேதுரு","1 பேது",670),
	BOOK_2Pet("2Pet", true, 61, "2பேதுரு","2 பேது",680),
	BOOK_1John("1John", true, 62, "1யோவான்","1 யோவா",690),
	BOOK_2John("2John", true, 63, "2யோவான்","2 யோவா",700),
	BOOK_3John("3John", true, 64, "3யோவான்","3 யோவா",710),
	BOOK_Jude("Jude", true, 65, "யூ","யூதா",720),
	BOOK_Rev("Rev", true, 66, "வெ","வெளி",730),

	BOOK_Jdt("Jdt", false, 67, "Judit", "Jdt", 0),
	BOOK_Wis("Wis", false, 68, "Wisdom", "Wis", 0),
	BOOK_Tob("Tob", false, 69, "Tobit", "Tob", 0),
	BOOK_Sir("Sir", false, 70, "Sirach", "Sir", 0),
	BOOK_Bar("Bar", false, 71, "Baruch", "Bar", 0),
	BOOK_1Macc("1Macc", false, 72, "1 Maccabees", "1Ma", 0),
	BOOK_2Macc("2Macc", false, 73, "2 Maccabees", "2Ma", 0),
	BOOK_AddDan("AddDan", false, 74, "Additions to Daniel", "xDa", 0),
	BOOK_AddEsth("AddEsth", false, 75, "Additions to Esther", "xEs", 0),
	BOOK_PrMan("PrMan", false, 76, "Prayer of Manasseh", "Man", 0),
	BOOK_3Macc("3Macc", false, 77, "3 Maccabees", "3Ma", 0),
	BOOK_4Macc("4Macc", false, 78, "4 Maccabees", "4Ma", 0),
	BOOK_EpJer("EpJer", false, 79, "Letter of Jeremiah", "LJe", 0),
	BOOK_1Esd("1Esd", false, 80, "1 Esdras", "1Es", 0),
	BOOK_2Esd("2Esd", false, 81, "2 Esdras", "2Es", 0),
	BOOK_Odes("Odes", false, 82, "Odes", "Ode", 0),
	BOOK_PssSol("PssSol", false, 83, "Psalms of Solomon", "PsS", 0),
	BOOK_EpLao("EpLao", false, 84, "Epistle to the Laodiceans", "Lao", 0),
	BOOK_1En("1En", false, 85, "1 Enoch", "1En", 0),
	BOOK_kGen("x-kGen", false, 86, "kGen", "kGn", 0),
	BOOK_Sus("Sus", false, 87, "Susanna", "Sus", 0),
	BOOK_Bel("Bel", false, 88, "Bel and the Dragon", "Bel", 0),
	BOOK_AddPs("AddPs", false, 89, "Psalm 151", "Ps2", 0),

	BOOK_PrAzar("PrAzar", false, 901, "Prayer of Azariah", "Aza", 0),
	BOOK_EsthGr("EsthGr", false, 902, "Greek Esther", "EsG", 0),
	BOOK_DanGr("DanGr", false, 903, "Greek Daniel", "DaG", 0),
	BOOK_Jub("Jub", false, 904, "Jubilees", "Jub", 0),
	BOOK_4Ezra("4Ezra", false, 905, "Ezra Apocalypse", "4Ez", 0),
	BOOK_5Ezra("5Ezra", false, 906, "5 Ezra", "5Ez", 0),
	BOOK_6Ezra("6Ezra", false, 907, "6 Ezra", "6Ez", 0),
	BOOK_5ApocSyrPss("5ApocSyrPss", false, 908, "5 Apocryphal Syriac Psalms", "Ps3", 0),
	BOOK_2Bar("2Bar", false, 909, "(Syriac) Apocalypse of Baruch", "2Ba", 0),
	BOOK_4Bar("4Bar", false, 910, "4 Baruch", "4Ba", 0),
	BOOK_EpBar("EpBar", false, 911, "Letter of Baruch", "LBa", 0),
	BOOK_1Meq("1Meq", false, 912, "1 Meqabyan", "1Mq", 0),
	BOOK_2Meq("2Meq", false, 913, "2 Meqabyan", "2Mq", 0),
	BOOK_3Meq("3Meq", false, 914, "3 Meqabyan", "3Mq", 0),
	BOOK_Rep("Rep", false, 915, "Reproof", "Rep", 0),

	APPENDIX("x-App", true, -6, "Appendix", "App", 0),
	APPENDIX_OTHER("x-App-Other", true, -7, "Appendix Other", "ApO", 0),
	APPENDIX_CONCORDANCE("x-App-Conc", true, -8, "Appendix Concordance", "ApC", 0),
	APPENDIX_GLOSSARY("x-App-Gloss", true, -9, "Appendix Glossary", "ApG", 0),
	APPENDIX_TOPICAL("x-App-Topical", true, -10, "Appendix Topical Index", "ApT", 0),
	APPENDIX_NAMES("x-App-Names", true, -10, "Appendix Names Index", "ApN", 0),

	DICTIONARY_ENTRY("x-Dict", true, -5, "Dictionary Entry", "Dct", 0);

	private final String osisID, englishName, threeLetterCode;
	private final int zefID;
	private final boolean nt;
	private final int myBibleZoneId;

	private BookIDTamilVersion6(String osisID, boolean nt, int zefID, String englishName, String threeLetterCode, int myBibleZoneId) {
		this.osisID = osisID;
		this.nt = nt;
		this.zefID = zefID;
		this.englishName = englishName;
		this.threeLetterCode = threeLetterCode;
		this.myBibleZoneId = myBibleZoneId;
	}

	public String getOsisID() {
		return osisID;
	}

	public String getEnglishName() {
		return englishName;
	}

	public String getThreeLetterCode() {
		return threeLetterCode;
	}

	public int getZefID() {
		return zefID;
	}

	public boolean isNT() {
		return nt;
	}

	public boolean isDeuterocanonical() {
		return zefID > 66;
	}

	public static BookIDTamilVersion6 fromZefId(int zefId) {
		for (BookIDTamilVersion6 id : values()) {
			if (id.zefID == zefId)
				return id;
		}
		throw new IllegalArgumentException("Unsupported ZefID: " + zefId);
	}

	public static BookIDTamilVersion6 fromOsisId(String osisId) {
		for (BookIDTamilVersion6 id : values()) {
			if (id.osisID.equals(osisId))
				return id;
		}
		throw new IllegalArgumentException("Unsupported OSIS ID: " + osisId);
	}

	/**
	 * @return the myBibleZoneId
	 */
	public int getMyBibleZoneId() {
		return myBibleZoneId;
	}
}
