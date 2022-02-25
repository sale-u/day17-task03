package admin;

import java.util.Scanner;

import domain.User;

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
		
		while (true) {
			System.out.println("1. Unos ");
			System.out.println("2. Prikaz svih korisnika");
			System.out.println("3. Prikaz korisnika");
			System.out.println("4. Izmena korisnika");
			System.out.println("5. Brisanje korisnika");
			
		}
	}
	
	

}
