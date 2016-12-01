package client.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class DefaultTheme implements Theme {
	
	@Override
	public String getUserIcon() {
		return "data/image/planet/pluto.png";
	}

	@Override
	public String getPicIcon() {
		return "data/image/planet/saturn.png";
	}

	@Override
	public String getNoteIcon() {
		return "data/image/planet/venues.png";
	}

	@Override
	public Color getBackgroundColor() {
		return Color.white;
	}

	@Override
	public Font getFont() {
		return new Font("微软雅黑", Font.PLAIN, 14);
	}

	@Override
	public String getBackgroundPicture() {
		return "data/image/pheonix.jpg";
	}

	@Override
	public String getPaneIcon() {
		return "data/image/planet/mars.png";
	}

	@Override
	public String getFillHeartIcon() {
		return "data/image/heart/images.png";
	}

	@Override
	public String getStrokeHeartIcon() {
		return "data/image/heart/favorite.png";
	}
	
	public static void main(String[] args) {
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		for (String string : environment.getAvailableFontFamilyNames())
			System.out.println(string);
	}

	@Override
	public String getSearchIcon() {
		return "data/image/planet/elestial.png";
	}

	@Override
	public String getReverseIcon() {
		return "data/image/planet/mars.png";
	}

	@Override
	public Font getErrorFont() {
		return new Font("微软雅黑", Font.BOLD, 14);
	}

	@Override
	public Color getErrorColor() {
		return Color.red;
	}
}
