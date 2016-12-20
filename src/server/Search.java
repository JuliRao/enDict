package server;
//#package com.zjm.www.test;
//#package common;
import java.io.IOException;
import java.util.Vector;
import java.util.regex.Matcher;
//import javax.lang.model.element.Element;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Search {
	private Document getDocument(String url){
		try{
			return Jsoup.connect(url).get();
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
/*	public Vector<String> getBaiduMean(String dstWord){
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
	}*/
	
	/**
	 * 联网获取有道的单词释义
	 * @param dstWord
	 * @return
	 */
	public Vector<String> getYoudaoMean(String dstWord){
//		System.out.println("youdao");
		Vector<String> mean = new Vector<>();
		String url = "http://dict.youdao.com/w/eng/"+dstWord+"/#keyfrom=dict2.index";
		Document doc = getDocument(url);
		if(doc.select(".trans-container").size()!=0){
			Element elements1 = doc.select(".trans-container").get(0);
			Elements elements2 = elements1.select("ul");
			Elements word = elements2.select("li");
			for(Element e: word){
				mean.add(e.text());
			}
		}
//		System.out.println("youdaoMean");
		return mean;
	}
	/**
	 * 联网获取Bing的单词释义
	 * @param dstWord
	 * @return
	 */
	public Vector<String> getBingMean(String dstWord){
//		System.out.println("Bing");
		Vector<String> mean = new Vector<>();
		String url = "http://cn.bing.com/dict/search?q="+dstWord;
		Document doc = getDocument(url);
		if(doc.select("meta[name=description]").size()!=0){
			String p = doc.select("meta[name=description]").get(0).attr("content");
//			System.out.println(p);
//		System.out.println(p);
			String []pSplit = p.split("，");
			String []pSpSp = new String[0];
			int j = 0;
//			System.out.println(pSplit.length);
			for(j = 0; j < pSplit.length;j++){
				if(pSplit[j].contains("必应")||pSplit[j].contains("美[")||pSplit[j].contains("英[")||pSplit[j].contains("词典"))
					continue;
				else
					break;
			}
			if(j!=pSplit.length){
//				System.out.println(pSplit[j]);
				pSpSp = pSplit[j].split(" ");
			}
//			System.out.println("aaaa");

			String q = "";
			for(int i = 0; i < pSpSp.length;i++){
//			System.out.println(pSpSp[i]);
				Pattern pattern = Pattern.compile("[.\\x22]+");
				Pattern pa = Pattern.compile("[：\\x22]+");
				Matcher matcher = pattern.matcher(pSpSp[i]);
				Matcher ma = pa.matcher(pSpSp[i]);
				if(matcher.find()){
//				System.out.println("match");
					if(q!="")
						mean.add(q);
					q="";
					mean.add(pSpSp[i]);
				}
				else if(ma.find()){
//				System.out.println("!!!");
					mean.add(q);
					mean.add(pSpSp[i]);
					q="";
				}
				else{
//				System.out.println("not match");
					q+=pSpSp[i];
				}
//				mean.add(pSpSp[i]);
//		for(int i = 0; i < pSpSp.length; i++){
//			if(pSpSp[i] == "[.\x22]+"){
				
//			}
//			if(pSpSp[i+1][0]<='z'&&pSpSp[i+1][0]>='a')
//			mean.add(pSpSp[i]+pSpSp[i+1]);
//			i++;
			}
			if(!q.equals(""))
				mean.add(q);
//		Vector<String> pSplit = p.split(",");
		
//		for(int i = 0; i < p.length();i++){
			
//		}
		}
//		System.out.println(p);
		return mean;
	}
	/**
	 * 联网获取金山的单词释义
	 * @param dstWord
	 * @return
	 */
	public Vector<String> getJinshanMean(String dstWord){
		System.out.println("jinshan");
		Vector<String> mean = new Vector<>();
		String url = "http://www.iciba.com/"+dstWord;
		Document doc = getDocument(url);
//		System.out.println(doc.html());
		Elements elements1 = doc.select(".clearfix");
//		System.out.println(elements1.text());
//		Elements elements2 = doc.select(".prop");
//		System.out.println(elements2.text());
		if(elements1.size()!=0){
//			System.out.println("dstWord:"+dstWord);
			for(Element e : elements1){
				String m = "";
//				System.out.println("qwdhiowqh");
//				System.out.println(e.select(".prop").size());
				if(e.select(".prop").size()!=0){
//					System.out.println("dstWord:"+dstWord);
					Element p = e.select(".prop").get(0);
					if(e.select("p").select("span").size()!=0){
						Elements s = e.select("p").select("span");
						for(Element e1 : s){
							m = m + e1.text();
						}
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
		}
		return mean;
	}
}
