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

//import common.ThreeMeanings;
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
		String username = req.getRequest().elementAt(0);
		String password = req.getRequest().elementAt(1);
		boolean ifUser = database.IfUser(username, password);
		Vector<String> data = new Vector<String>();
		System.out.println(ifUser);
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
		String username = User;
		System.out.println(username);
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
//		System.out.println("jjjmm");
		String dstWord = req.getRequest().elementAt(0);
		Vector<String> data = new Vector<String>();
		Search s = new Search();
//		database.addSearch(dstWord);
//		System.out.println(dstWord);
		Vector<String> jinshan = s.getJinshanMean(dstWord);
		Vector<String> youdao = s.getYoudaoMean(dstWord);
		Vector<String> bing = s.getBingMean(dstWord);
//		ThreeMeanings means = new ThreeMeanings(s.getJinshanMean(dstWord),s.getYoudaoMean(dstWord),s.getBingMean(dstWord));
//		for(int i = 0; i < )
//		System.out.println(jinshan.elementAt(0));
		Vector<String> dictsort = database.getThumb(dstWord);
/*		for(int i = 0; i < dictsort.size();i++)
			System.out.println(dictsort.elementAt(i));*/
		for(int i = 0; i < dictsort.size(); i++){
			String dict = dictsort.elementAt(i);
			data.add(dict);
			if(dict.equals("baidu")){
				for(int j = 0; j < jinshan.size(); j++)
					data.add(jinshan.elementAt(j));
			}
			else if(dict.equals("youdao")){
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
		database.addSearch(dstWord);
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
		System.out.println(word);
		System.out.println(dict);
		Vector<String> data = new Vector<String>();
		if(database.thumbup(word, dict))
			data.add("success");
		else
			data.add("failed");
		res.setResponse(data);
		res.setType(dataType.thumbUp);
		return res;
	}
	
	private ResponseData thumbDown(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String word = req.getRequest().elementAt(0);
		String dict = req.getRequest().elementAt(1);
		Vector<String> data = new Vector<String>();
		if(database.thumbdown(word, dict))
			data.add("success");
		else
			data.add("failed");
		res.setResponse(data);
		res.setType(dataType.thumbDown);
		return res;
	}

	private ResponseData sendmail(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String sender = User;
		String word = req.getRequest().elementAt(0);
		String message = req.getRequest().elementAt(1);
		Vector<String> Recev = new Vector<String>();
		Vector<String> data = new Vector<String>();
		for(int i = 2; i < req.getRequest().size(); i++){
			String receiver = req.getRequest().elementAt(i);
			if(database.sendMessage(sender, receiver,word, message)){
				String m = receiver + " send successfully";
				data.add(m);
			}
			else{
				String m = receiver + " user not exists";
				data.add(m);
			}
		}
//		String receiver = req.getRequest().elementAt(1);
		
//		String message = req.getRequest().elementAt(2);
		
		
		/*if(database.sendMessage(sender, receiver, message))
			data.add("send successfully");
		else
			data.add("user not exist");*/
		
		res.setResponse(data);
		res.setType(dataType.sendMail);
		return res;
	}
	
	private ResponseData receivemail(RequestData req) throws SQLException {
		ResponseData res = new ResponseData();
		System.out.println(User);
		String username = User;
		Vector<String> data = new Vector<String>();
		/*Vector<String> message = database.getMessage(username);
		for(int i = 0; i < message.size(); i++){
			String p = message.elementAt(i);
			String []sp = p.split(" / ");
			data.add(sp[0]);
			String []spsp = sp[1].split("?");
			data.a
		}*/
		data = database.getMessage(username);
		res.setResponse(data);
		res.setType(dataType.receiveMail);
		return res;
	}
	
	private ResponseData hotsearch(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		
		Vector<String> data = new Vector<String>();
		data = database.getHot();
		res.setResponse(data);
		res.setType(dataType.hotSearch);
		
		return res;
	}
	
	private ResponseData everyday(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		
		Vector<String> data = new Vector<String>();
		String p = database.getEveryday();
		data.add(p);
		res.setResponse(data);
		res.setType(dataType.everyDay);
		return res;
	}
	
	private ResponseData addwordbook(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = User;
		String word = req.getRequest().elementAt(0);
		String mean = req.getRequest().elementAt(1);
		Vector<String> data = new Vector<String>();
		database.addwordBook(username, word, mean);
		data.add("success");
		res.setResponse(data);
		res.setType(dataType.addwordbook);
		return res;
	}
	
	private ResponseData getwordbook(RequestData req) throws SQLException{
		ResponseData res = new ResponseData();
		String username = User;
		Vector<String> data = new Vector<String>();
		
		data = database.getwordbook(username);
		System.out.println(data.elementAt(0));
		res.setResponse(data);
		res.setType(dataType.getwordbook);
		
		return res;
	}
	
	@Override
	public void run() {
		database = MyData.createConnection();
//		MyData database = MyData.createConnection();
		try{
//			System.out.println("s");
			ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			while(true) {
//				System.out.println("sss");
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
				else if(req.getRequestType() == dataType.thumbDown){
					System.out.println("thumbDown");
					ResponseData res = thumbDown(req);
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
				else if(req.getRequestType() == dataType.hotSearch){
					System.out.println("hotSearch");
					ResponseData res = hotsearch(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.everyDay){
					System.out.println("everyday");
					ResponseData res = everyday(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.addwordbook){
					System.out.println("addwordbook");
					ResponseData res = addwordbook(req);
					toClient.writeObject(res);
					toClient.flush();
				}
				else if(req.getRequestType() == dataType.getwordbook){
					System.out.println("getwordbook");
					ResponseData res = getwordbook(req);
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
