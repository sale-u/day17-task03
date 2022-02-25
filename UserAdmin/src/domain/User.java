package domain;

public class User {
	
	private final String ime;
	private final String prezime;
	private final String username;
	private final String password;
	private final UserType userType;
	
	
	public User(String ime, String prezime, String username, String password, UserType userType) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}


	public String getIme() {
		return ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public UserType getUserType() {
		return userType;
	}


	@Override
	public String toString() {
		return "User [ime=" + ime + ", prezime=" + prezime + ", username=" + username + "]";
	}
	
	
	

}
