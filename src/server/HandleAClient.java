package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import com.mysql.jdbc.DatabaseMetaData;

import common.ThreeMeanings;
import common.RequestData;
import common.ResponseData;
import common.dataType;
import server.database.MyData;


public class HandleAClient implements Runnable {

	private Socket socket;
	private MyData database;
	private String User;
	public HandleAClient(Socket socket) {
		this.socket = socket;
	}
	
	private ResponseData login(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = res.getResponse().elementAt(0);
		String password = res.getResponse().elementAt(1);
		boolean ifUser = database.IfUser(username, password);
		Vector<String> data = new Vector<String>();
		if(ifUser == true){
			data.add("login successfully");
			User = username;
		}
		else
			data.add("User not exist");
		res.setType(dataType.login);
		res.setResponse(data);
		return res;
	}
	
	private ResponseData logout(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = req.getRequest().elementAt(0);
		Vector<String> data = new Vector<String>();
		if(database.exit(username)==false)
			data.add("user not exist");
		else
			data.add("logout successfully");
		res.setType(dataType.logout);
		res.setResponse(data);
		return res;
	
	}

	private ResponseData signUp(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = req.getRequest().elementAt(0);
		String password = req.getRequest().elementAt(1);
		Vector<String> data = new Vector<String>();
		if(database.addUser(username, password) == false)
			data.add("User has existed");
		else
			data.add("sign up successfully");
		res.setResponse(data);
		res.setType(dataType.signUp);
		return res;
	}

	private ResponseData search(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String dstWord = req.getRequest().elementAt(0);
		Vector<String> data = new Vector<String>();
		Search s = new Search();
		Vector<String> jinshan = s.getJinshanMean(dstWord);
		Vector<String> youdao = s.getYoudaoMean(dstWord);
		Vector<String> bing = s.getBingMean(dstWord);
//		ThreeMeanings means = new ThreeMeanings(s.getJinshanMean(dstWord),s.getYoudaoMean(dstWord),s.getBingMean(dstWord));
//		for(int i = 0; i < )
		Vector<String> dictsort = database.getThumb(dstWord);
		for(int i = 0; i < 3; i++){
			String dict = dictsort.elementAt(i);
			data.add(dict);
			if(dict == "jinshan"){
				for(int j = 0; j < jinshan.size(); j++)
					data.add(jinshan.elementAt(j));
			}
			else if(dict == "youdao"){
				for(int j = 0; j < youdao.size(); j++)
					data.add(youdao.elementAt(j));
			}
			else{
				for(int j = 0; j < bing.size(); j++)
					data.add(bing.elementAt(j));
			}
		}
		/*data.add("Jinshan");
		for(int i = 0; i < jinshan.size(); i++)
			data.add(jinshan.elementAt(i));
		data.add("Youdao");
		for(int i = 0; i < youdao.size(); i++)
			data.add(youdao.elementAt(i));
		data.add("Bing");
		for(int i = 0; i < bing.size(); i++)
			data.add(bing.elementAt(i));*/
		res.setResponse(data);
		res.setType(dataType.search);
		return res;
	}
	
	private ResponseData online(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
//		String username = req.getRequest().elementAt(0);
		Vector<String> data = database.onlineUser();
		res.setResponse(data);
		res.setType(dataType.online);
		return res;
	}
	
	private ResponseData thumbUp(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String word = req.getRequest().elementAt(0);
		String dict = req.getRequest().elementAt(1);
		Vector<String> data = new Vector<String>();
		if(database.thumbup(word, dict))
			data.add("success");
		else
			data.add("failed");
		res.setResponse(data);
		res.setType(dataType.thumbUp);
		return res;
	}

	private ResponseData sendmail(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = req.getRequest().elementAt(0);
		Vector<String> data = new Vector<String>();

		res.setResponse(data);
		res.setType(dataType.sendMail);
		return res;
	}
	
	private ResponseData receivemail(RequestData req) throws SQLException {
		ResponseData res = new ResponseData();
		String username = req.getRequest().elementAt(0);
		Vector<String> data = new Vector<String>();
		res.setResponse(data);
		res.setType(dataType.receiveMail);
		return res;
	}
	
	@Override
	public void run() {
		database = MyData.createConnection();
//		MyData database = MyData.createConnection();
		try{
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
			
			while(true) {
				RequestData req = (RequestData)inputStream.readObject();
				if(req.getRequestType() == dataType.login){
					System.out.println("login");
					ResponseData res = login(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.logout){
					System.out.println("logout");
					ResponseData res = logout(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.signUp){
					System.out.println("signUp");
					ResponseData res = signUp(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.search){
					System.out.println("search");
					ResponseData res = search(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.online){
					System.out.println("online");
					ResponseData res = online(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.thumbUp){
					System.out.println("thumbUp");
					ResponseData res = thumbUp(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.sendMail){
					System.out.println("sendMail");
					ResponseData res = sendmail(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() ==dataType. receiveMail){
					System.out.println("receiveMail");
					ResponseData res = receivemail(req);
					toClient.writeObject(res);
					toClient.flush();
				}
//				String dstWord = inputStream.readUTF();
				/*System.out.println(dstWord);
				Search s = new Search();
				ThreeMeanings mean = new ThreeMeanings(s.getJinshanMean(dstWord), s.getYoudaoMean(dstWord), s.getBingMean(dstWord));		
				toClient.writeObject(mean);*/
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		finally {
			System.out.println("Close the Server socket and the io.");
            try {
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
