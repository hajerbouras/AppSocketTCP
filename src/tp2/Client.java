package tp2;

import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		String host="127.0.0.1";
		int port =3000;
		Socket sc= new Socket (host,port); 
		ClientSend send = new ClientSend(sc);
		send.start();

		ClientReceiv rec = new ClientReceiv(sc);
		rec.start();
			}

}
