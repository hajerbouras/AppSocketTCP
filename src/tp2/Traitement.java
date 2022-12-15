package tp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Traitement extends Thread {
	
	private Socket sc;
	public Traitement(Socket sc) {
		this.sc=sc;	}
	
	public void run() {
		boolean x=false;
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
			
			do {
				String m = in.readLine();
				boolean y=false;
				
				if (m.startsWith("CREATION")) { 
					x=true;
					String m1 = m.substring(9);
					
					for(Compt cp: TCPServer.lc) {
						
						if(cp.getNomCl().equals(m1) || cp.getPort()==sc.getPort()) {
							out.println("account already exist Welcome :) Mr: "+cp.getNomCl());
							y=true;
							}
						}if(y==false) {
							Compt c = new Compt();
							c.setNomCl(m1);
							c.setPort(sc.getPort());
							TCPServer.lc.add(c);
							out.println("Account Created with success :=) ");
							}
						
				}
				
				else { out.println("you must authenticate !!!!" );} 
				
			} while(x==false);
			
		}catch(Exception ex) {ex.printStackTrace();
		}
		
		while(true) {
			
			try {
				
				BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				PrintWriter  out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())),true);
				String m = in.readLine();
				
				if (m.startsWith("DEBIT")) {
					
					String m1 = m.substring(6);
					int index =getIndexFromPort(sc.getPort());
					int m2 = Integer.parseInt(m1);
				
					if(index!=-1) {
						
						if(m2<=TCPServer.lc.get(index).getSolde())  {
							TCPServer.lc.get(index).setSolde(TCPServer.lc.get(index).getSolde()-m2);
							out.println("compt Debité avec success");
							String operation= "Debit de "+m2 +"Dinars";
							TCPServer.lc.get(index).getLh().add(operation);
							}
						
						else {
							
							out.println("Solde insufissant");
							}
						
					}
					
					else {
						out.println("error of index");
						}
					
				}
				
				else if (m.startsWith("CREDIT")) {
					
					String m1 = m.substring(7);
					int index =getIndexFromPort(sc.getPort());
					int m2 = Integer.parseInt(m1);
					
					if(index!=-1) {
						TCPServer.lc.get(index).setSolde(TCPServer.lc.get(index).getSolde()+m2);
						out.println("compt Credité avec success");
						String operation= "Credit de "+m2 +"Dinars";
						TCPServer.lc.get(index).getLh().add(operation);
						
					}
					
					else {
						out.println("Eurror");
						}
					
				}
				
				else if (m.startsWith("SOLDE")) {
					int index =getIndexFromPort(sc.getPort());
					float solde =TCPServer.lc.get(index).getSolde();
					out.println( "solde est: "+solde);
					}
				
				else if (m.startsWith("TRANSFERT")) {
					int index =getIndexFromPort(sc.getPort());
					String [] m3= m.split(" ");
					String nomCompt = m3[1];
					int solde = Integer.parseInt(m3[2]);
					
					if(TCPServer.lc.get(index).getSolde()>=solde) {
						TCPServer.lc.get(index).setSolde(TCPServer.lc.get(index).getSolde()-solde);
						int indexReceiv= getIndexFromNom(nomCompt  );
						
						if(indexReceiv!=-1) {
							TCPServer.lc.get(indexReceiv).setSolde(TCPServer.lc.get(indexReceiv).getSolde()+solde);
							String operation= "transfer de "+solde+ "a Mr/Mme"+nomCompt;
							TCPServer.lc.get(index).getLh().add(operation);
							out.println(operation);	
						}
						
						else {
							TCPServer.lc.get(index).setSolde(TCPServer.lc.get(index).getSolde()+solde);
							out.println("user not found");	
						}	
					}
					
					else { 
						out.print("solde insuffisant");
					}
				}
				
				else if (m.startsWith("HIST")) {
					
					int index =getIndexFromPort(sc.getPort());
					out.println(TCPServer.lc.get(index).getLh());
				}
				
				else {
					out.println("verify CMD" + sc.getPort());
					
				}
			} catch(Exception ex) {
				ex.printStackTrace();
				}
			}
	}
	
	public int getIndexFromPort( int port ) {
		int  counter=0;
		for(Compt cp: TCPServer.lc ) {
			counter++;
			if(cp.getPort()==port) {
				return counter-1;
			}
		}
		return -1;
		
	}
	
	public int getIndexFromNom( String nom ) {
		int  counter=0;
		for(Compt cp: TCPServer.lc ) {
			counter++;
			if(cp.getNomCl().equals(nom)) {
				return counter-1;
			}
		}
		return -1;
	}

}
