package tp2;

import java.util.ArrayList;
import java.util.List;

public class Compt {
	
	private int id;
	private float solde;
	private String nomCl;
	private int port ;
	private List<String> lh;
	
	public int getPort() {
		return port;
	}

	public List<String> getLh() {
		return lh;
	}

	public void setLc(List<String> lh) {
		this.lh = lh;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public static int c=0;
	
	public Compt() {
		super();
		TCPServer.counter++;
		id=TCPServer.counter;
		solde=0;
		lh=new ArrayList<String>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getNomCl() {
		return nomCl;
	}
	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}

}
