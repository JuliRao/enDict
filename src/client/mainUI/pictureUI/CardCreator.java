package client.mainUI.pictureUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.ImageIO;
import client.common.Info;
import client.config.Config;
import client.theme.MyTheme;

public class CardCreator {
	
	private String receiveFolder = Config.getReceiveFolder();
	private String bufferFolder = Config.getCardBuffer();
	private String picturePath = "data/image/card/summer2.jpg";
	
	private void copyFile(String sourse, String dest) {    
        try {
        	File sourceFile = new File(sourse);
        	File destFile = new File(dest);
        	if(destFile.exists())
        		destFile.delete();
			Files.copy(sourceFile.toPath(), destFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 除去某个文件夹中的所有文件
	 */
	private void removeAllFile(File directory) {
		if (directory.isDirectory()) {
			File[] array = directory.listFiles();
			for(File file : array) {
				if(file.isFile()) {
					file.delete();
		        }
			}
		}
	}
	
	/**
	 * 生成一张单词卡
	 */
	public void createCard() {
		removeAllFile(new File(Config.getCardBuffer()));
		String word = Info.getWord();
		Vector<String> meaning = Info.getMeanings().getMeanings(Info.getDefaultDictionary());
		
		String path = bufferFolder + "/" + meaning.hashCode() + ".jpg";
		
		copyFile(picturePath, path);
		if(meaning != null)
			addWords(path, word, meaning);
	}
	
	/**
	 * 生成一张单词卡
	 */
	public String createCard(String word, String meaning, String user) {
		int random = meaning.hashCode();
		String path = receiveFolder + '/' + random + ".jpg";
		
		// no need to generate
		if(new File(path).exists())
			return null;
		// generate a new picture
		else {
			copyFile(picturePath, path);
			String[] strings = meaning.split("///");
			Vector<String> vector = new Vector<String>(Arrays.asList(strings));
			addWords(path, word + " FROM [" + user + "]", vector);
		}
		
		return path;
	}
	
	/**
	 * 在path指向的图片上填入单词及其释义
	 * @param path
	 * @param word
	 * @param meaning
	 */
	private void addWords(String path, String word, Vector<String> meaning) {
	   File file = new File(path);
	   BufferedImage bi = null;
	   try {
			bi = ImageIO.read(file);
	   } catch (IOException e1) {
		   e1.printStackTrace();
	   }
	   Graphics2D g2 = (Graphics2D)bi.getGraphics();
	   
	   Font font = MyTheme.Instance().getCardFont();
	   g2.setColor(Color.black);
	   g2.setFont(font);
	   
	   int x = 20;
	   int y = 40;
	  
	   g2.drawString(word, x, y);
	   y += 40;
	   for(String string : meaning) {
		   g2.drawString(string, x, y);
		   y += 40;
	   }

	   try {
		   //将生成的图片保存为jpg格式的文件。ImageIO支持jpg、png、gif等格式  
		   ImageIO.write(bi, "jpg", file);       
		   } catch (IOException e) {
		   System.out.println("生成图片出错........");
		   e.printStackTrace();
	   }
	}
}
