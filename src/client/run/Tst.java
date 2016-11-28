package client.run;

import common.ThreeMeanings;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Tst {
	public static void main(String[] args) throws ClassNotFoundException {

		
		try {
			Socket socket = new Socket("114.212.130.243", 3000);
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
//			toServer.writeChar('a');
//			toServer.write("hello".getBytes("UTF-8"));
			toServer.writeUTF("hello");
			ThreeMeanings mean = (ThreeMeanings)input.readObject();
			
/*			Vector<String> Baidu = mean.getBaidu();
			int flag = 0;
			System.out.println("hello");
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
			}*/
//			out.writeDouble(23333);
			
/*			while(true) {
				
			}*/
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
