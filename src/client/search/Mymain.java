package client.search;

import java.util.Vector;
public class Mymain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dstWord = "how";
		Search s = new Search();
//		htmlRequest s = new htmlRequest();
		Vector<String> Baidu = s.getBaiduMean(dstWord);
//		System.out.println(mean);
		int flag = 0;
		System.out.println(dstWord);
		System.out.println("Baidu");
		for(String m : Baidu){
			if(flag == 0){
				System.out.print(m + " ");
				flag++;
			}
			else{
				System.out.println(m);
				flag = 0;
			}
		}
		Vector<String> youdao = s.getYoudaoMean(dstWord);
		System.out.println("Youdao");
		for(String m : youdao){
			System.out.println(m);
		}
		
		Vector<String> Jinshan = s.getBingMean(dstWord);
		System.out.println("Bing");
		flag = 0;
		for(String m : Jinshan){

				System.out.println(m);

		}
	}

}
