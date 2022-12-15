package tp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSend extends Thread {
	
	private Socket sc;
	
	public ClientSend(Socket sc) {
		this.sc=sc;	}
	
	public void run () {
		System.out.println("enter what in your mind Mr CLIENT");

		while(true) {
			try {
				
				PrintWriter  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
				BufferedReader msj = new BufferedReader(new InputStreamReader(System.in));
				out.println(msj.readLine());
				
		} catch(Exception ex){
			ex.printStackTrace();
	}
}
	
}


}
