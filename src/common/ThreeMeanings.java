package common;

import java.util.Vector;

public class ThreeMeanings implements java.io.Serializable{
	private Vector<String> Baidu;
	private Vector<String> Youdao;
	private Vector<String> Bing;
	public ThreeMeanings(Vector<String> Bd,Vector<String> Yd,Vector<String> Bi){
		this.Baidu = Bd;
		this.Youdao = Yd;
		this.Bing = Bi;
	}
	public Vector<String> getBaidu(){
		return Baidu;
	}
	public Vector<String> getYoudao(){
		return Youdao;
	}
	public Vector<String> getBing(){
		return Bing;
	}
}
