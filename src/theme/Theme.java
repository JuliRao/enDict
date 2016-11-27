package theme;

import java.awt.Color;
import java.awt.Font;

interface LoginTheme {

}

interface WordTheme {
	public String getFillHeartIcon();
	public String getStrokeHeartIcon();
	public String getSearchIcon();
}

interface MomentsTheme {

}

interface FunctionTheme {
	public String getUserIcon();
	public String getPicIcon();
	public String getNoteIcon();
}

public interface Theme extends LoginTheme, WordTheme, FunctionTheme, MomentsTheme {
	public Color getBackgroundColor();
	public Font getFont();
	public String getBackgroundPicture();
	public String getPaneIcon();
}
