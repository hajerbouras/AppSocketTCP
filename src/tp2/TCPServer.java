package tp2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer{
	
	public static int counter=0;

	public static List<Compt> lc = new ArrayList<Compt>();
	
		public static void main(String[] args) throws Exception {
			int port =3000;
			
			ServerSocket sc= new ServerSocket(port);
			while(true) {
				
				Socket sock = sc.accept();
				Traitement t = new Traitement (sock);
				t.start();	
				}	
		}

}
