package server.database;

import java.sql.SQLException;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyData sql = new MyData();
		sql.createConnection();
		try {
			sql.exit("patato");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
