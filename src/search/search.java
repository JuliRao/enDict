//#package com.zjm.www.test;

import java.io.IOException;
import java.util.Vector;
//import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Search {
	public Document getDocument(String url){
		try{
			return Jsoup.connect(url).get();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<String> getBaiduMean(String dstWord){
		Vector<String> mean = new Vector<>();
		String url = "http://dict.baidu.com/s?wd="+dstWord+"&device=pc&from=home&q="+dstWord;

		Document doc = getDocument(url);
	//	System.out.println(doc.text());
		Elements elements1 = doc.select(".en-content");
		Elements elements2 = elements1.select("p");
//		for(Element e: elemenys2)
		Elements pron = elements2.select("strong");
		Elements cn = elements2.select("span");
		int i = 0;
		for(Element e : pron){
			mean.add(pron.get(i).text());
			mean.add(cn.get(i).text());
			i++;
		}
		
//		System.out.println(elements2.text());
		
		
//		Elements elements2 = elements1.select("p");
//		for(Element e : elements2)
//			System.out.println(e.text());
//		String mean = elements2.get(0).text();
//		return mean;

		return mean;
	}
	
	public Vector<String> getYoudaoMean(String dstWord){
		Vector<String> mean = new Vector<>();
		String url = "http://dict.youdao.com/w/eng/"+dstWord+"/#keyfrom=dict2.index";
		Document doc = getDocument(url);
		Element elements1 = doc.select(".trans-container").get(0);
		Elements elements2 = elements1.select("ul");
		Elements word = elements2.select("li");
		for(Element e: word){
			mean.add(e.text());
		}
		return mean;
	}
	
	public Vector<String> getJinshanMean(String dstWord){
		Vector<String> mean = new Vector<>();
		String url = "http://www.iciba.com/"+dstWord;
		Document doc = getDocument(url);
//		System.out.println(doc.html());
		Elements elements1 = doc.select(".clearfix");
//		System.out.println(elements1.text());
//		Elements elements2 = doc.select(".prop");
//		System.out.println(elements2.text());
		for(Element e : elements1){
			String m = "";
			if(e.select(".prop").isEmpty()==false){
				Element p = e.select(".prop").get(0);
				Elements s = e.select("p").select("span");
				for(Element e1 : s){
					m = m + e1.text();
				}
				mean.add(p.text());
				mean.add(m);
//				System.out.println(e.text());
			}
//			String m = "";
//			Element p = e.select(".prop").get(0);
//			Elements s = e.select("p").select("span");
//			for(Element e1 : s){
//				m = m + e1.text();
//			}
//			mean.add(p.text());
//			mean.add(m);
		}
		return mean;
	}
}
