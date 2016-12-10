package server.database;
import java.sql.*;
import java.util.Vector;

public class MyData {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/DictData";
	private String user = "root";
	private String password = "ab123456";
	private static Connection con = null;
	private static Statement stmt = null;
	private static MyData database = null;
	
	private MyData(){
		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Database connected");
			stmt = con.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MyData createConnection(){
		if(database == null)
			database = new MyData();
		return database;
	}
	public static boolean thumbup(String word,String dict) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select * from wordUp where word = '"
				+word+"';");
		if(resultSet.next() == true){
			int n = 0;
			if(dict == "baidu")
				n = resultSet.getInt(2);
			else if(dict == "youdao")
				n = resultSet.getInt(3);
			else if(dict == "bing")
				n = resultSet.getInt(4);
			n++;
			String s = "";
			s = n + "";
			if(dict == "baidu")
				stmt.executeUpdate("update wordup set baidu = "+s+" where word = '"+word+"';");
			else if(dict == "youdao")
				stmt.executeUpdate("update wordup set youdao = "+s+" where word = '"+word+"';");
			else if(dict == "bing")
				stmt.executeUpdate("update wordup set bing = "+s+" where word = '"+word+"';");
			
		}
		else{
			if(dict == "baidu")
				stmt.executeUpdate("insert into wordup(word,baidu,youdao,bing) values('"+word+"',1,0,0);");
			else if(dict == "youdao")
				stmt.executeUpdate("insert into wordup(word,baidu,youdao,bing) values('"+word+"',0,1,0);");
			else if(dict == "bing")
				stmt.executeUpdate("insert into wordup(word,baidu,youdao,bing) values('"+word+"',0,0,1);");
		}
//		if(resultSet.next() == true){
//			int n = resultSet.getInt(1);
//			n++;
//			String s = "";
//			s = n + "";
//			stmt.executeUpdate("update wordUp set count = "+s+" "+"where word = '"+word+"';");
//		}
//		else{
//			stmt.executeUpdate("insert into  wordUp(word, count)\n"+
//							"values ('"+word+"',1);");
//		}
		return true;
	}
	public static boolean addUser(String username,String password) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select state "
				+ "from Dictuser where username = '" +username+"';");
		if(resultSet.next() == true)
			return false;
		
		stmt.executeUpdate("insert into Dictuser (username,password,friend)\n"+
							"values ('"+username+"','"+password+"','');");
		return true;
//		return 
	}
	public static boolean IfUser(String Iusername,String Ipassword) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select state "
				+ "from Dictuser where username = '" +Iusername +"' and password = '"+Ipassword+"';");
//		System.out.println();
		if(resultSet.next() == false)
			return false;
		else{
			stmt.executeUpdate("update dictuser set state = 1 where username = '"+Iusername+"';");
			return true;
		}
	}
	public static boolean addFriend(String username,String friend) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select * from Dictuser where username = '"
				+username+"';");
//		ResultSet setFriend = stmt.executeQuery("select * from Dictuser where username = '"
//				+friend+"';");
		if(resultSet.next()==false ){
			System.out.println("not exits");
			return false;
		}
//		else if(setFriend.next()==false)
//			return false;
		else{
			String pre = resultSet.getString(3);
			pre = pre + friend + " ";
			stmt.executeUpdate("update dictuser set friend = '"+pre+"' where username = '"+username+"';");
		}
		return true;
	}
	public static boolean exit(String username) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select state "
				+ "from Dictuser where username = '" +username +"';");
		if(resultSet.next()==false)
			return false;
		stmt.executeUpdate("update dictuser set state = 0 where username = '"+username+"';");
		return true;
	}
	public static Vector<String> onlineUser() throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select username from dictuser where state = 1");
		Vector<String> user = new Vector<String>();
		while(resultSet.next()){
			user.add(resultSet.getString(1));
		}
		return user;
	}
}
