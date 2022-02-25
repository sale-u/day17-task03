package admin;

import java.util.List;
import java.util.Scanner;

import domain.User;
import domain.UserType;

public class AdminMenu {
	
	private final Scanner scanner;
	private final UserAdministration ua;
	private final User adminUser;
	
	public AdminMenu(Scanner scanner, UserAdministration ua, User adminUser) {
		super();
		this.scanner = scanner;
		this.ua = ua;
		this.adminUser = adminUser;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public UserAdministration getUa() {
		return ua;
	}

	public User getAdminUser() {
		return adminUser;
	}

	public void adminMenu() {
		System.out.println("======== ADMINSKI MENU ==============");
		
		boolean flag = false;
		while (!flag) {
			System.out.println();
			System.out.println("1. Unos ");
			System.out.println("2. Prikaz svih korisnika");
			System.out.println("3. Prikaz korisnika");
			System.out.println("4. Izmena korisnika");
			System.out.println("5. Brisanje korisnika");
			System.out.println("========================");
			System.out.print("Vas izbor (1 - 5, 0 - izlaz) ");
			int izbor = Integer.parseInt(scanner.nextLine());
			System.out.println();
			switch (izbor) {
				case 1:
					unosNovogKorisnika();
					break;
				case 2:
					prikazSvihKorisnika();
					break;
				case 3:
					prikazKorisnika();
					break;
				case 4:
					izmenaKorisnika();
					break;
				case 5:
					brisanjeKorisnika();
					break;
				case 0:
					flag = true;
			}
			
		}
	}

	private void brisanjeKorisnika() {
		System.out.println("=============  Brisanje korisnika =================");
		System.out.print("Unesi userName : ");
		String userName = scanner.nextLine();
		User user = ua.getUser(userName);
		if (user != null) {
			ua.removeUser(user);
			System.out.println("Uspesno izbrisan user " + user.getUsername());
		} else {
			System.out.println(userName + " ne postoji u bazi");
		}	
	}

	
	private void izmenaKorisnika() {
		System.out.println("=============  Izmena korisnika =================");
		System.out.print("Unesi userName : ");
		String userName = scanner.nextLine();
		User user = ua.getUser(userName);
		if (user == null) {
			System.out.println(userName + " ne postoji u bazi");
			return;
		}
			
		System.out.println("Izmena podataka za " + user.getUsername());
		
		String ime = null;
		System.out.print("Postojece ime : " + user.getIme() + " >>> Unesi novo ime : ");
		ime = scanner.nextLine();
		
		String prezime = null;
		System.out.print("Postojece prezime : " + user.getPrezime() + " >>> Unesi novo prezime : ");
		prezime = scanner.nextLine();
		
		UserType role = null;
		System.out.print("Postojeca rola : " + user.getUserType() + " >>> Unesi novu rolu (ADMIN, EDITOR) : ");
		role = UserType.valueOf(scanner.nextLine().toUpperCase());
		
		User newUser = new User(ime, prezime, user.getUsername(), user.getPassword(), role);
		
		if (ua.updateUser(user, newUser)) {
			System.out.println("Uspesno azururan user " + user.getUsername());
		} else {
			System.out.println("NEuspesno azururan user " + user.getUsername());
		}
	}

	private void prikazKorisnika() {
		System.out.println("=============  Prikaz korisnika =================");
		System.out.print("Unesi userName : ");
		String userName = scanner.nextLine();
		User user = ua.getUser(userName);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("Ne postoji takav user");
		}
	}

	private void prikazSvihKorisnika() {
		List<User> sviUseri = ua.getAllUsers();
		System.out.println("=============  Prikaz svih korisnika =================");
		int count = 0;
		for (User u : sviUseri) {
			System.out.println(++count + " > " + u);
		}
		
	}

	private void unosNovogKorisnika() {
		System.out.println("=============  Unos novog korisnika =================");
		System.out.print("Unesi userName : ");
		String userName = scanner.nextLine();
		User user = ua.getUser(userName);
		if (user!=null && user.getUsername().equals(userName)) {
			System.out.println(userName + " vec postoji u bazi!");
			return;
		}
		String password = null;
		String passwordConf = null;
		boolean flag = false;
		while(!flag) {
			System.out.print("Unesi password : ");
			password = scanner.nextLine();
			if (User.checkPassword(password)) {
				System.out.print("Ponovi password : ");
				passwordConf = scanner.nextLine();
				if (password.equals(passwordConf)) {
					System.out.println("Password = OK");
					flag = true;
				} else {
					System.out.println("Ponovljeni password nije isti");
				}
			} else {
				System.out.println("Neispravan password! Password mora poceti slovom i sadrzati barem jedan broj");
			}	
		}
		
		String ime = null;
		System.out.print("Unesi ime : ");
		ime = scanner.nextLine();
		
		String prezime = null;
		System.out.print("Unesi prezime : ");
		prezime = scanner.nextLine();
		
		UserType role = null;
		System.out.print("Unesi rolu (ADMIN, EDITOR) : ");
		role = UserType.valueOf(scanner.nextLine().toUpperCase());
		
		user = new User(ime, prezime, userName, password, role);
		ua.addUser(user);
		
	}
	
	

}
