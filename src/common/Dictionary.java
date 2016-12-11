package common;

public enum Dictionary {
	Baidu,
	YouDao,
	Bing;
	
	public String getName() {
		switch(this) {
		case Baidu:
			return "百度词典";
		case YouDao:
			return "有道词典";
		case Bing:
			return "必应词典";
		}
		return "";
	}
	
	public String getEnglishName() {
		switch(this) {
		case Baidu:
			return "baidu";
		case YouDao:
			return "youdao";
		case Bing:
			return "bing";
		}
		return "";
	}
	
	public static Dictionary getDictionary(String name) {
		if(name.equals("baidu"))
			return Baidu;
		else if(name.equals("youdao"))
			return YouDao;
		else if(name.equals("bing")) {
			return Bing;
		}
		else {
			return null;
		}
	}
}
