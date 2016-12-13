package client.mainUI.pictureUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;

import common.Dictionary;
import client.common.Info;
import client.common.Meanings;
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
	
	public void createCard() {
		removeAllFile(new File(Config.getCardBuffer()));
		String word = Info.getWord();
		Vector<String> meaning = Info.getMeanings().getMeanings(Info.getDefaultDictionary());
		
		String path = bufferFolder + "/" + meaning.hashCode() + ".jpg";
		
		copyFile(picturePath, path);
		if(meaning != null)
			addWords(path, word, meaning);
	}
	
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


/*File file = new File("data/card/a.jpg");
	   Font font = new Font("Serif", Font.BOLD, 10);
	   //创建一个画布
	   BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

//获取画布的画笔 

//开始绘图 
//g2.setBackground(Color.WHITE);
// g2.clearRect(0, 0, width, height);
g2.setPaint(new Color(0, 0, 255)); 
g2.fillRect(0, 0, 100, 10);
g2.setPaint(new Color(253, 2, 0));
g2.fillRect(0, 10, 100, 10);
g2.setPaint(Color.red);
FontRenderContext context = g2.getFontRenderContext();
Rectangle2D bounds = font.getStringBounds(s, context);
double x = (width - bounds.getWidth()) / 2; 
double y = (height - bounds.getHeight()) / 2; 
double ascent = -bounds.getY();
double baseY = y + ascent;
 //绘制字符串
g2.drawString(s, (int)x, (int)baseY);*/
