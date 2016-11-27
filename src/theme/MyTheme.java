package theme;

public class MyTheme {
	private static Theme theme = null;
	
	public static Theme Instance() {
		if(theme == null)
			theme = new DefaultTheme();
		return theme;
	}
}
