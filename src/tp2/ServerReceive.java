package tp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceive extends Thread {
	
	private Socket sc;
	
	public ServerReceive(Socket sc) {
		this.sc=sc;	}
	
	public void run () {
		while(true) {
			try {
				
				BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String m = in.readLine();
				System.out.println(sc.getInetAddress());
				System.out.println("message Received from client "+sc.getPort() +" "+m);
				
			} catch(Exception ex){
				ex.printStackTrace();
	
	}
			}
		}
	
}
