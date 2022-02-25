package main;

import java.util.Scanner;

import admin.AdminMenu;
import admin.UserAdministration;
import domain.User;
import domain.UserType;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserAdministration ua = new UserAdministration();
		
		User testAdmin = new User("Admin1", "Adminic1", "admin1", "Admin123", UserType.ADMIN);
		ua.addUser(testAdmin);
		
		String userName = null;
		String password = null;
		User currUser = null;
		
		int brojac = 4;
		while(brojac > 0) {						// 4 neuspela pokusaja
			System.out.print("Username : ");
			userName = scanner.nextLine();
			System.out.print("Password : ");
			password = scanner.nextLine();
			
			currUser = ua.getUser(userName);
			if (currUser == null) {
				System.out.println("Neispravan unos. Pokusajte ponovo (broj pokusaja: " + --brojac + " )");
			} else {
				if (currUser.getPassword().equals(password)) {
					break;
				} else {
					System.out.println("Neispravan unos. Pokusajte ponovo (broj pokusaja: " + --brojac + " )");
				}	
			}
		}
		
		if (currUser != null) {
			System.out.println("Dobrodosao korisnice : " + currUser.getUsername());
			if (currUser.getUserType() == UserType.ADMIN) {
				AdminMenu adminMenu = new AdminMenu(scanner, ua, currUser);
			}
		}

		
		
		
		
		
		System.out.println("============== KRAJ ==================");
		scanner.close();
		
	}

}
