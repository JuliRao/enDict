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
			return "Jinshan";
		case YouDao:
			return "Youdao";
		case Bing:
			return "Bing";
		}
		return "";
	}
}
