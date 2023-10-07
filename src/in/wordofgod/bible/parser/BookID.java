package in.wordofgod.bible.parser;

/**
 * ID for uniquely referring to a bible book.
 */
public enum BookID {

	METADATA("x-Meta", false, -4, "Metadata", "Mta", 0),

	INTRODUCTION("x-Intr", false, -1, "Introduction", "Int", 0),
	INTRODUCTION_OT("x-IntrOT", false, -2, "Introduction OT", "IOT", 0),

	BOOK_Gen("Gen", false, 1, "Genesis","Gen",10),
	BOOK_Exod("Exod", false, 2, "Exodus","Exo",20),
	BOOK_Lev("Lev", false, 3, "Leviticus","Lev",30),
	BOOK_Num("Num", false, 4, "Numbers","Num",40),
	BOOK_Deut("Deut", false, 5, "Deuteronomy","Deu",50),
	BOOK_Josh("Josh", false, 6, "Joshua","Jos",60),
	BOOK_Judg("Judg", false, 7, "Judges","Jdg",70),
	BOOK_Ruth("Ruth", false, 8, "Ruth","Rth",80),
	BOOK_1Sam("1Sam", false, 9, "1 Samuel","1Sa",90),
	BOOK_2Sam("2Sam", false, 10, "2 Samuel","2Sa",100),
	BOOK_1Kgs("1Kgs", false, 11, "1 Kings","1Ki",110),
	BOOK_2Kgs("2Kgs", false, 12, "2 Kings","2Ki",120),
	BOOK_1Chr("1Chr", false, 13, "1 Chronicles","1Ch",130),
	BOOK_2Chr("2Chr", false, 14, "2 Chronicles","2Ch",140),
	BOOK_Ezra("Ezra", false, 15, "Ezra","Ezr",150),
	BOOK_Neh("Neh", false, 16, "Nehemiah","Neh",160),
	BOOK_Esth("Esth", false, 17, "Esther","Est",190),
	BOOK_Job("Job", false, 18, "Job","Job",220),
	BOOK_Ps("Ps", false, 19, "Psalm","Psa",230),
	BOOK_Prov("Prov", false, 20, "Proverbs","Pro",240),
	BOOK_Eccl("Eccl", false, 21, "Ecclesiastes","Ecc",250),
	BOOK_Song("Song", false, 22, "Song of Solomon","Son",260),
	BOOK_Isa("Isa", false, 23, "Isaiah","Isa",290),
	BOOK_Jer("Jer", false, 24, "Jeremiah","Jer",300),
	BOOK_Lam("Lam", false, 25, "Lamentations","Lam",310),
	BOOK_Ezek("Ezek", false, 26, "Ezekiel","Eze",330),
	BOOK_Dan("Dan", false, 27, "Daniel","Dan",340),
	BOOK_Hos("Hos", false, 28, "Hosea","Hos",350),
	BOOK_Joel("Joel", false, 29, "Joel","Joe",360),
	BOOK_Amos("Amos", false, 30, "Amos","Amo",370),
	BOOK_Obad("Obad", false, 31, "Obadiah","Oba",380),
	BOOK_Jonah("Jonah", false, 32, "Jonah","Jon",390),
	BOOK_Mic("Mic", false, 33, "Micah","Mic",400),
	BOOK_Nah("Nah", false, 34, "Nahum","Nah",410),
	BOOK_Hab("Hab", false, 35, "Habakkuk","Hab",420),
	BOOK_Zeph("Zeph", false, 36, "Zephaniah","Zep",430),
	BOOK_Hag("Hag", false, 37, "Haggai","Hag",440),
	BOOK_Zech("Zech", false, 38, "Zechariah","Zec",450),
	BOOK_Mal("Mal", false, 39, "Malachi","Mal",460),

	INTRODUCTION_NT("x-IntrNT", true, -3, "Introduction NT", "INT", 0),

	BOOK_Matt("Matt", true, 40, "Matthew","Mat",470),
	BOOK_Mark("Mark", true, 41, "Mark","Mar",480),
	BOOK_Luke("Luke", true, 42, "Luke","Luk",490),
	BOOK_John("John", true, 43, "John","Joh",500),
	BOOK_Acts("Acts", true, 44, "Acts","Act",510),
	BOOK_Rom("Rom", true, 45, "Romans","Rom",520),
	BOOK_1Cor("1Cor", true, 46, "1 Corinthians","1Co",530),
	BOOK_2Cor("2Cor", true, 47, "2 Corinthians","2Co",540),
	BOOK_Gal("Gal", true, 48, "Galatians","Gal",550),
	BOOK_Eph("Eph", true, 49, "Ephesians","Eph",560),
	BOOK_Phil("Phil", true, 50, "Philippians","Php",570),
	BOOK_Col("Col", true, 51, "Colossians","Col",580),
	BOOK_1Thess("1Thess", true, 52, "1 Thessalonians","1Th",590),
	BOOK_2Thess("2Thess", true, 53, "2 Thessalonians","2Th",600),
	BOOK_1Tim("1Tim", true, 54, "1 Timothy","1Ti",610),
	BOOK_2Tim("2Tim", true, 55, "2 Timothy","2Ti",620),
	BOOK_Titus("Titus", true, 56, "Titus","Tit",630),
	BOOK_Phlm("Phlm", true, 57, "Philemon","Phm",640),
	BOOK_Heb("Heb", true, 58, "Hebrews","Heb",650),
	BOOK_Jas("Jas", true, 59, "James","Jas",660),
	BOOK_1Pet("1Pet", true, 60, "1 Peter","1Pe",670),
	BOOK_2Pet("2Pet", true, 61, "2 Peter","2Pe",680),
	BOOK_1John("1John", true, 62, "1 John","1Jn",690),
	BOOK_2John("2John", true, 63, "2 John","2Jn",700),
	BOOK_3John("3John", true, 64, "3 John","3Jn",710),
	BOOK_Jude("Jude", true, 65, "Jude","Jud",720),
	BOOK_Rev("Rev", true, 66, "Revelation","Rev",730),

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

	private BookID(String osisID, boolean nt, int zefID, String englishName, String threeLetterCode, int myBibleZoneId) {
		this.osisID = osisID;
		this.nt = nt;
		this.zefID = zefID;
		this.englishName = englishName;
		this.threeLetterCode = Utils.validateString("threeLetterCode", threeLetterCode, "[A-Za-z0-9]{3}");
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

	public static BookID fromZefId(int zefId) {
		for (BookID id : values()) {
			if (id.zefID == zefId)
				return id;
		}
		throw new IllegalArgumentException("Unsupported ZefID: " + zefId);
	}

	public static BookID fromOsisId(String osisId) {
		for (BookID id : values()) {
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
