package tp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiv extends Thread {
	
	private Socket sc;
	
	public ClientReceiv(Socket sc) {
		this.sc=sc;	}
	
	public void run () {
		while(true) {
			try {
				
				BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String m = in.readLine();
				System.out.println(m);
				
			} catch(Exception ex){
				ex.printStackTrace();
	}
}
	
}
	

}
