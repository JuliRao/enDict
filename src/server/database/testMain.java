package server.database;

import java.sql.SQLException;
import java.util.Vector;

import server.Search;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MyData sql = MyData.createConnection();
		MyData sql2 = MyData.createConnection();
		if(sql == sql2)
			System.out.println("heiheihei");
		try {
			sql.exit("apple");
			sql2.IfUser("tomato", "tomato");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Search s = new Search();
		Vector<String> mean = new Vector<String>();
		mean = s.getBingMean("orange");
		for(int i = 0; i < mean.size(); i++)
			System.out.println(mean.elementAt(i));
	}

}
