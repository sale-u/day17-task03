package main;

import java.util.Scanner;

import admin.UserAdministration;
import domain.User;

public class Main {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserAdministration ua = new UserAdministration();
		
		
		
		String userName = null;
		String password = null;
		User currUser = null;
		
		int brojac = 0;
		while(brojac < 4) {						// 4 neuspela pokusaja
			System.out.print("Username : ");
			userName = scanner.nextLine();
			System.out.print("Password : ");
			password = scanner.nextLine();
			
			
			
			// UserAdministracija provera da li postoje userName i password?
			// if exist izlazim iz petlje
			
		}
		
		
		
		
		
		
		
//		scanner.close();
		
	}

}
