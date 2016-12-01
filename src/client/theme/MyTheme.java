package client.theme;

public class MyTheme {
	private static Theme theme = null;
	
	public synchronized static Theme Instance() {
		if(theme == null)
			theme = new DefaultTheme();
		return theme;
	}
	
	private MyTheme() {
		
	}
}
