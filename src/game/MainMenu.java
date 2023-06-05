package game;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import game.Player;

public class MainMenu {
	private List<Player> players;
	private Scanner input;
	public MainMenu(Scanner input) {
		this.input = input;
	}
	
	public void mainMenu() {
		int choice;
		
		do {
			System.out.println("        Keep Cool\n");
		
			System.out.println("--------Main Menu--------\n");
			System.out.println("1. Start game");
			System.out.println("2. Instructions");
			System.out.println("3. Exit\n");

			System.out.print("Enter your choice : ");
			
			try { // Only allows the user to input an integer
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				choice = 4; // Sets choice to 4 if an invalid option is entered, which will cause to loop to re-iterate
			}
			input.nextLine(); // Clears input buffer so a single invalid input isn't accidentally repeatedly read
					
			switch(choice) {
				case 1 : createPlayers(); break;
				case 2 : instructions(); break;
				case 3 : System.exit(0);
				default : System.out.print("You must enter a number between 1-3.");
			}
			
			System.out.println("\n");
		} while (choice < 1 || choice > 3); // Loops until the user enters a valid choice
	}
	
	
	public void createPlayers() {
		int choice;
		
		do {
			System.out.print("Enter number of players (2-8) : ");
			try { // Only allows the user to input an integer between 2-8
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				choice = 1; // Sets choice to 1 if an invalid option is entered, which will cause to loop to re-iterate
			}
			if (choice < 2 || choice > 8) {
				System.out.println("You must enter a number between 2-8\n");
			}
			input.nextLine();
		} while (choice < 2 || choice > 8);
		
		players = new ArrayList<Player>();
		
		for (int count = 0; count < choice; count++) {
			System.out.print("Player " + (count + 1));
			System.out.print(" Enter name : ");
			players.add(new Player(input.nextLine()));
		}
		
	}
	
	public static void instructions() {
		System.out.println("\nKeep Cool is a game about the protection of the environment. Within this game the player must\r\n"
				+ "navigate through a board of various biomes, purchasing wildlife sanctuaries and collecting Eco Points to\r\n"
				+ "fuel their eco-friendly escapades. The goal is to gather Eco Points while taking them from other players.\r\n"
				+ "The game ends when the only one player has Eco Points remaining. ");
		
		String options[] = {"Character Selection","Beginning the Game","Go Square","Natural Disaster Square","Opportunity Square",
				"Airport Square","Whale Square","Purchasing Wildlife Sanctuaries","Running Out of Funds","End Game","EXIT INSTRUCTIONS"};
		
		Menu instructions = new Menu("\nINSTRUCTIONS\nWhat would you like to find out more about?", options);
		
		
		while(true) {
			instructions.displayMenu();
			Scanner insOption = new Scanner(System.in);
			if(insContent(instructions.getChoice(insOption)) == true) {
				break;
			};
			
			System.out.print("\nWould you like to continue reading more instructions? (0 to proceed): ");
			Scanner insContinue = new Scanner(System.in);
			int nextInput = 1;
			try { // Only allows the user to input an integer between 2-8
				nextInput = insContinue.nextInt();
			} catch (InputMismatchException e) {
				nextInput = 1; // Sets choice to 1 if an invalid option is entered, which will cause to loop to re-iterate
			}
			if(nextInput != 0) {
				break;
			}
		}
	}
	
	private static boolean insContent(int choice) {
		switch (choice) {
		case 1: System.out.println("The user will first be asked how many players will be taking part in the game. The user\r\n"
				+ "can select any number of players between two and eight. After the number of players have been chosen,\r\n"
				+ "the game will ask for the name of player one. Player one will then type in their name and press the enter\r\n"
				+ "key. This will save the first players name and prompt the second player to enter their name. This will\r\n"
				+ "continue until all players have entered their names. Once this has occurred the game will begin."); break;
		case 2: System.out.println("At the beginning of the game all players will be located on the start square. All players will be granted a\r\n"
				+ "total of 1500 Eco Points to begin the game. Player one will then begin their move by rolling two dice.\r\n"
				+ "Player one will then move the same number of spaces displayed on the combined dice. In this game the\r\n"
				+ "dice are rolled and the character moves automatically. Once this has occurred the effect of the space\r\n"
				+ "that the player has landed on will be applied. (For information on the effects of each space see Types of\r\n"
				+ "Spaces) If the players balance has been affected the player will be shown their new balance. The player\r\n"
				+ "also has the option to end the game at any time by selecting quit in the menu. Once player ones's turn has ended. Player\r\n"
				+ "two`s turn can begin. This will continue until all players have had their turn, at which point player one\r\n"
				+ "will be able to make their second turn and the cycle continues."); break;
		case 3: System.out.println("The start square is slightly different to all the other squares on the board as the player can either\r\n"
				+ "land on the square or pass over the square to be granted 150 eco points"); break;
		case 4: System.out.println("The Disaster Square is an unfortunate square to land on. If landed on, a range of terrible Natural Disasters\r\n"
				+ "will occur. Either the player that landed on the square and/or others in the game have a chance to lose their\r\n"
				+ "Sancturies and/or Land. If Sanctuaries are lost, these will have to be re-purchased. If Land is lost, these will be open to\r\n"
				+ "be re-purchased by any player. This gives players an opportunity to 'steal' Land from other players. Players also have a chance\r\n"
				+ "be swallowed by the Whale."); break;
		case 5: System.out.println("The start square is slightly different to all the other squares on the board as the player can either\r\n"
				+ "land on the square or pass over the go square to be granted 150 eco points."); break;
		case 6: System.out.println("If a player lands on any of the game's airport squares the player will then be 'flown' to next corner of the\r\n"
				+ "board. This does however come with a downside. The player will be fined for their use of fuel to get them to that biome. This will cost\r\n"
				+ "them 300 eco points"); break;
		case 7: System.out.println("The player can be trapped within the Whale via dice roll, picking a specfic oppurtunity card or through the airport square\r\n"
				+ "Once the player is swallowed inside the whale, they will need to pay 150 eco points to be able to leave. If the player has insufficient eco points\r\n"
				+ "or does not wish to pay it, they will miss their current turn. Once the player has paid, 150 eco points will be subtracted from their balance\r\n"
				+ "and they will be moved to the next square"); break;
		case 8: System.out.println("If a player lands on a square they already own,  they will have the opportunity to purchase a wildlife\r\n"
				+ "sanctuary on that square. This allows the player, at the cost of some of their eco points, to increase\r\n"
				+ "the fine their opponent will have to pay if they land on that square. Up to Three Wildlife Sanctuaries can\r\n"
				+ "be purchased for any single square. The fine will increase by 10% for each santuary placed."); break;
		case 9: System.out.println("In the event that a player runs out of eco points. That player will then be eliminated from the game.\r\n"
				+ "Their turn will be skipped for the remainder of the game's lifecycle and all the properties will be returned to a neutral\r\n"
				+ "position to be bought again by other players."); break;
		case 10: System.out.println("Whenever a player runs out of eco points they are removed from the game and placed in last place. The\r\n"
				+ "game will continue until another player has run out of eco points and then they are also removed from\r\n"
				+ "the game and placed in second last place. This cycle will continue until only one player is left. At this\r\n"
				+ "point the game will end and the last remaining player will be declared the winner. From here the\r\n"
				+ "leaderboard will show the order of the players and all the players will have the opportunity to\r\n"
				+ "congratulate the winning player on their achievement. The amount of eco points remaining with the\r\n"
				+ "winning player will be displayed as their high score."); break;
		case 11: return true;
		}
		return false;
	}
	
	public List<Player> getPlayers(){
		return players;
	}
}
