package tp2;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	String username;
	List<Compt>  lc;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Compt> getLc() {
		return lc;
	}
	public void setLc(List<Compt> lc) {
		this.lc = lc;
	}
	public User() {
		super();
		lc = new ArrayList<Compt>();
	}


}
