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
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;

import common.Dictionary;
import common.ThreeMeanings;
import client.common.Info;
import client.common.Searchable;
import client.config.Config;
import client.theme.MyTheme;

public class CardCreator {
	
	private String defaultPath = Config.getCardBuffer();
	private String picturePath = "data/image/card/summer2.jpg";
	private Dictionary dictionary = Dictionary.YouDao;
	
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
	
	public void createCard() {
		copyFile(picturePath, defaultPath);
		try {
			
/*			Vector<String> strings = new Vector<String>();
			strings.add("pron. 什么；多么；多少");
			strings.add("adj. 什么；多么；何等");
			strings.add("adv. 到什么程度，在哪一方面");
			strings.add("int. 什么；多么");
			addWords("what", strings);*/
			
			String word = Info.getWord();
			Searchable meanings = Info.getMeanings();
			if(meanings != null)
				addWords(word, Info.getMeanings().getMeaning(dictionary));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addWords(String word, Vector<String> meaning) throws IOException {
	   File file = new File(defaultPath);
	   BufferedImage bi = ImageIO.read(file);
	   Graphics2D g2 = (Graphics2D)bi.getGraphics();
	   
	   Font font = MyTheme.Instance().getCardFont();
	   g2.setColor(Color.black);
	   g2.setFont(font);
	   
	   int x = 50;
	   int y = 50;
	  
	   g2.drawString(word, x, y);
	   y += 40;
	   for(String string : meaning) {
		   g2.drawString(string, x, y);
		   y += 40;
	   }

	   try {
		   //将生成的图片保存为jpg格式的文件。ImageIO支持jpg、png、gif等格式  
		   ImageIO.write(bi, "png", file);       
		   } catch (IOException e) {
		   System.out.println("生成图片出错........");
		   e.printStackTrace();
	   }
	}

	
	public static void main(String[] args) {
		new CardCreator().createCard();
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
