package server.database;
import java.sql.*;
import java.util.Vector;
//import java

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
	public static synchronized MyData createConnection(){
		if(database == null)
			database = new MyData();
		return database;
	}
	public static synchronized boolean thumbup(String word,String dict) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select * from wordUp where word = '"
				+word+"';");
		if(resultSet.next() == true){
			int n = 0;
			if(dict == "jinshan")
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
	public static synchronized boolean addUser(String username,String password) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select state "
				+ "from Dictuser where username = '" +username+"';");
		if(resultSet.next() == true)
			return false;
		
		stmt.executeUpdate("insert into Dictuser (username,password,friend)\n"+
							"values ('"+username+"','"+password+"','');");
		return true;
//		return 
	}
	public static synchronized boolean IfUser(String Iusername,String Ipassword) throws SQLException{
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
	public static synchronized boolean addFriend(String username,String friend) throws SQLException{
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
	public static synchronized boolean exit(String username) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select state "
				+ "from Dictuser where username = '" +username +"';");
		if(resultSet.next()==false)
			return false;
		stmt.executeUpdate("update dictuser set state = 0 where username = '"+username+"';");
		return true;
	}
	public static synchronized Vector<String> onlineUser() throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select username,state from dictuser;");
		Vector<String> user = new Vector<String>();
		while(resultSet.next()){
			int ifOnline = resultSet.getInt(2);
			if(ifOnline == 1)
				user.add("Online");
			else
				user.add("notOnline");
			user.add(resultSet.getString(1));
		}
		return user;
	}
	public static synchronized boolean sendMessage(String sender, String receiver, String data) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select username from dictuser where username = '"+receiver+"';");
		if(resultSet.next() == false)
			return false;
		stmt.executeUpdate("insert into message(receiver, sender, data) values ('"
				+receiver+"','"+sender+"','"+data+"');");
		
		return true;
	}
	public static synchronized Vector<String> getMessage(String username) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select sender, data from message where receiver = '"
				+ username + "';");
		Vector<String> message =  new Vector<String>();
		while(resultSet.next()){
			String p = "";
			p = p + resultSet.getString(1) + " / " + resultSet.getString(2);
			message.add(p);
		}
		/*if(resultSet.next()==false){
			message.add("user not found");
		}
		else{
			while(resultSet.next()){
				message.add(resultSet.getString(1));
			}
		}*/
		return message;
	}
	public static synchronized Vector<String> getThumb(String dstWord) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select baidu, youdao, bing from wordup where word = '"
				+dstWord+"';");
		Vector<String> dictsort = new Vector<String>();
		int jinshan = 0;
		int youdao = 0;
		int bing = 0;
//		System.out.println(jinshan);
		if(resultSet.next()){
			jinshan = resultSet.getInt(1);
			youdao = resultSet.getInt(2);
			bing = resultSet.getInt(3);
		}

		if(jinshan >= youdao && jinshan >= bing){
			dictsort.add("jinshan");
			if(youdao > bing){
				dictsort.add("youdao");
				dictsort.add("bing");
			}
			else{
				dictsort.add("bing");
				dictsort.add("youdao");
			}
		}
		else if(youdao >= jinshan && youdao >= bing){
			dictsort.add("youdao");
			if(jinshan > bing){
				dictsort.add("jinshan");
				dictsort.add("bing");
			}
			else{
				dictsort.add("bing");
				dictsort.add("jinshan");
			}
		}
		else{
			dictsort.add("bing");
			if(jinshan > youdao){
				dictsort.add("jinshan");
				dictsort.add("youdao");
			}
			else{
				dictsort.add("youdao");
				dictsort.add("jinshan");
			}
		}
		return dictsort;
	}
	public static synchronized boolean thumbdown(String word, String dict) throws SQLException{
		ResultSet resultSet = stmt.executeQuery("select * from wordup where word = '"
				+word+"';");
		if(resultSet.next()){
			int n = 0;
			if(dict == "baidu")
				n = resultSet.getInt(1);
			else if(dict == "youdao")
				n = resultSet.getInt(2);
			else
				n = resultSet.getInt(3);
			if(n != 0)
				n--;
			String s = n + "";
			if(dict == "baidu")
				stmt.executeUpdate("update wordUp set baidu = "+s+" where word = '"+word+"';");
			else if(dict == "youdao")
				stmt.executeUpdate("update wordUp set youdao = "+s+" where word = '"+word+"';");
			else 
				stmt.executeUpdate("update wordUp set bing = "+s+" where word = '"+word+"';");
		}
		return true;
	}
}
