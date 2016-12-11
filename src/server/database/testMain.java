package server.database;

import java.sql.SQLException;
import java.util.Vector;

import server.Search;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData sql = MyData.createConnection();
//		MyData sql2 = MyData.createConnection();
//		if(sql == sql2)
//			System.out.println("heiheihei");
		try {
			Vector<String> data = sql.getMessage("apple");
			for(int i = 0; i < data.size(); i++){
				System.out.println(data.elementAt(i));
			}
//			sql.sendMessage("patato", "apple", "i like tomato");
//			sql.sendMessage("tomato", "apple", "i like patato");
//			sql.exit("apple");
//			sql2.IfUser("tomato", "tomato");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Search s = new Search();
		Vector<String> mean = new Vector<String>();
		mean = s.getBingMean("orange");
		for(int i = 0; i < mean.size(); i++)
			System.out.println(mean.elementAt(i));*/
	}

}
