/*
 * U operativnoj memoriji inicijalizovati jednog admin korisnika (ime, prezime, username, password, role). 
 * Role mo�e imati vrednosti: ADMIN ili EDITOR. Ukoliko se prijavi admin omogu�iti administraciju.
 * 
Glavni meni za korisnika s rolom ADMIN:
1. Administracija korisnika
               1.1. Unos
                 - Sva polja su obavezna,
                 - Korisni�ko ime mora biti jedinstveno,
                 - Password mora po�eti slovom i sadr�ati barem jedan broj,
                 - Nakon unosa passworda korisnik mora jo� jednom da unese password (repeat password validacija)
               1.2. Prikaz svih korisnika
               Kod prikaza korisnika ne raditi s passwordom.
               1.3. Prikaz korisnika
               Kod prikaza korisnika ne raditi s passwordom.
               1.4. Izmena korisnika
               Kod izmene korisnika ne raditi s passwordom.
               1.5. Brisanje korisnika

Za korisnika implementirati login feature. Nakon pokretanja programa korisnik unosi korisni�ko ime i lozinku. 
Maksimalni broj poku�aja prijavljivanja je 4. Nakon svakog neuspe�nog prijavljivanja prikazati 
poruku o gre�ci i preostalom broju poku�aja. Nakon �etiri neuspe�na prijavljivanja prekinuti program. 
Nakon uspe�nog prijavljivanja prikazati glavni meni.
 */

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
		User testEditor = new User("Editor1", "Editoric1", "editor1", "Editor123", UserType.EDITOR);
		ua.addUser(testEditor);
		
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
				adminMenu.adminMenu();
			}
		}

		System.out.println("============== KRAJ ==================");
		scanner.close();
		
	}

}
