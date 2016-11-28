package client.run;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tst {
	public static void main(String[] args) {

		
		try {
			Socket socket = new Socket("114.212.130.243", 3000);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeDouble(23333); 
			
/*			while(true) {
				
			}*/
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
