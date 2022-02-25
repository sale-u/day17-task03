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
	
	public static boolean checkPassword(String password) {
		if (password == null || password.equals("")) return false;
		
		if (Character.isDigit(password.charAt(0))) return false;  // prvi karakter mora biti slovo
		
		for (int i = 1; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(0))) return true;
		}
		return false;
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
