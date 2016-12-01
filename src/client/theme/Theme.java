package client.theme;

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
	public String getReverseIcon();
	public String getUserIcon();
	public String getPicIcon();
	public String getNoteIcon();
}

public interface Theme extends LoginTheme, WordTheme, FunctionTheme, MomentsTheme {
	public Color getBackgroundColor();
	public Color getErrorColor();
	public Font getFont();
	public Font getErrorFont();
	public String getBackgroundPicture();
	public String getPaneIcon();
}
