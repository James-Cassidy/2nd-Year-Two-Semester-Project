package demoPkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import demoPkg.Player;

public class Main {

	public static void main(String[] args) {
		int choice;
		Scanner scanner = new Scanner(System.in);
		
		do {
		
			System.out.println("        Keep Cool\n");
		
			System.out.println("--------Main Menu--------\n");
			System.out.println("1. Start game");
			System.out.println("2. Instructions");
			System.out.println("3. Exit\n");

			System.out.print("Enter your choice : ");
			choice = scanner.nextInt();
		
			switch(choice) {
				case 1 : createPlayers(); break;
				case 2 : System.out.print("Instructions"); break;
				case 3 : System.exit(0);
				default : System.out.print("No");
			}			
		} while (choice >= 1 && choice <= 3); // While choice is 1-3 inclusive

		scanner.close();
	}
	
	
	public static void createPlayers() {
		int choice;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of players (2-8) : ");
		choice = scanner.nextInt();
		List<Player> players = new ArrayList<Player>();
		
		for (int count = 0; count < choice; count++) {
			System.out.print("Player " + (count + 1));
			System.out.print(" enter name : ");
			players.add(new Player(scanner.nextLine()));
		}
		scanner.close();
		
	}
}
