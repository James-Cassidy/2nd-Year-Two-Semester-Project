package game;

import java.util.Scanner;
import game.Board.squareType;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

//File Used to Run Game
public class Start extends MainMenu {
	
	private Start(Scanner input) {
		super(input);
	}

	private static List<Player> players = new ArrayList<Player>();
	private static Board board = new Board(players.size()); // Creates a Board (Contains an array of spaces and positions)
	private static Scanner input = new Scanner(System.in);
	
	public Start() {
		super(input);
	}
	
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		MainMenu menu = new MainMenu(input);
		String[] options = {"Roll Dice", "View Owned Land", "View Player Stats", "View Board","View Instructions", "Quit Game"};
		
		Menu playerOptions = new Menu("What will you do?", options); // List of options the player will be able to make on their turn
		while(menu.getPlayers() == null)
			menu.mainMenu();
		players = menu.getPlayers();
		
		board = new Board(players.size()); // Creates a Board (Contains an array of spaces and positions)
		Dice dice = new Dice(); // Creates a Dice object (Generates a random number between 1-6 several times based on integer input)
		int currentPlayer = 0; // Used to determine the current players turn
		int choice = 1; // Used to determine a players choice
		while(players.size() > 1) { // Will loop indefinitely unless a player chooses to quit or the game ends
			Player player = players.get(currentPlayer); // Gets the current player and stores
			System.out.println("\n\nIt is " + player.getName() + "'s turn."); // Displays the name of the current players turn
			// Displays the space the player starts their turn on
			System.out.println("You are currently on " + board.getSpace(player.getNumLocation()).getName());

			playerOptions.displayMenu(); // Displays the player's options and reads in their choice
			choice = playerOptions.getChoice(input);
			
			if (choice == 1) { // If choice = 1, the player chose to roll the dice
				dice.rollDice(2); // Rolls two dice to determine movement amount
				System.out.println("You have rolled: " + dice.getValue()); // Displays the total value
				
				updateLocation(player, dice.getValue());
				
			} else if (choice == 2) { // If choice = 2, player chose to view their own land
				List<Property> list = player.getPurchaseList();
				System.out.println();
				if (list.isEmpty()) { // If player doesn't own any land
					System.out.println("You have no land.");
				} else {
					for(int i = 0; i < list.size(); i++) { // Displays all land owned by the player
						System.out.println(list.get(i).name);
					}
				}	
				continue; // Returns to the start of the loop so the player may take their turn
				
			} else if (choice == 3) { // If choice = 3, player chose to view another player's stats
				String[] playerNames = new String[players.size()]; // Used for the sub-menu for checking other player stats
				for (int count = 0; count < players.size(); count++) {
					playerNames[count] = players.get(count).getName();
				}
				Menu choosePlayer = new Menu("\nWhich player?", playerNames); // Lists all players and reads in the user's choice
				choosePlayer.displayMenu();
				
				int playerChoice = choosePlayer.getChoice(input) - 1;
				
				System.out.println(playerNames[playerChoice] +"'s current balance is: " + players.get(playerChoice).getBalance());
				List<Property> list = players.get(playerChoice).getPurchaseList();

				if (list.isEmpty()) {
					System.out.println(playerNames[playerChoice] + " doesn't own any land.");
				} else {
					System.out.println(players.get(playerChoice).getName() +"'s list of land is:");
					System.out.println();
					for(int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i).name);
					}
				
				}
				continue;
			} else if (choice == 4) {
				for(int i = 0; i <= 12; i++) {
					int pos = player.getNumLocation()+i;
					if(pos >= 32) {
						pos -= 32;
					}
					if(board.getSquareType(pos) == squareType.PROPERTY)
						System.out.print(board.getSpace(pos).getName() + "(" + ((Property) board.getSpace(pos)).getValue() + ")" + "\t");
					else
						System.out.print(board.getSpace(pos).getName() + "\t");
				}
				System.out.println();
				for(int i = 0; i < board.getSpace(player.getNumLocation()).getName().length()/2; i++)
					System.out.print(" ");
				System.out.println("/\\");
				System.out.println("You are here.");
				continue;
			} else if (choice == 5) {
				MainMenu.instructions();
				continue;
			} else if (choice == 6) {
				List<Property> list = player.getPurchaseList();
				for(int i = 0; i < list.size(); i++) {
					list.get(i).setOwner(null); // Reset the ownership of all of the player's land
				}
				players.remove(currentPlayer); // Remove the player from the game
				currentPlayer--;	
			}
			
			if(player.getBalance() <= 0) { // If the player ends their turn with no balance remove them				
				List<Property> list = player.getPurchaseList();
				for(int i = 0; i < list.size(); i++) {
					list.get(i).removeOwner(); // Reset the ownership of all of the player's land
				}
				System.out.println(player.getName() + " is bankrupt!");
				players.remove(currentPlayer); // Remove the player from the game
				currentPlayer--;
			}
			// Once the players turn is over, provides the option to quit and progresses to the next player's turn
			currentPlayer++;
			if(currentPlayer > players.size()-1)
				currentPlayer = 0;
			
		}
		System.out.println(players.get(0).getName() + " wins with " + players.get(0).getBalance() + " points!");
		System.out.println("To " + players.get(0).getName() +  " and friends thanks for playing Keep Cool!");
		input.close();	
	
	}

	protected static void payPlayer(Player player, Player owner, int value) {
		// Decrease the paying player's balance by the value of the space
		player.setBalance(player.getBalance() - value);
		// Increase the owner's balance by the value of the space
		owner.setBalance(owner.getBalance() + value);
		// Prints the players new balance
		System.out.println(player.getName() + "'s new balance: " + player.getBalance() + " points.");
		System.out.println(owner.getName() + "'s new balance: " + owner.getBalance() + " points.");
		
	}
	
	public static void updateLocation(Player player, int spaces) {
		
		int choice = 1;
		
		LocationOnBoard currentSpace = board.getSpace(player.getNumLocation()); // Gets the space the player is on
		
		if (player.getNumLocation() + spaces >= 32) { // Gives the player 150 points for landing on or passing go
			System.out.println("Go! Collect 150 points.");
			player.setBalance(player.getBalance() + 150);
		}
		
		player.setNumLocation(player.getNumLocation() + spaces);
		
		// Displays the name of the space the player has landed on
		System.out.println("You are now on " + board.getSpace(player.getNumLocation()).getName());
		
		currentSpace = board.getSpace(player.getNumLocation()); // Updates currentSpace with the space the player has landed on

		// Gets the square type the player is on and executes the appropriate code block
		squareType boardSquare = board.getSquareType(player.getNumLocation());
		if (boardSquare == squareType.PROPERTY) { // If the player lands on a land
			Property space = (Property)currentSpace; // Gets the space as a land object
					
			if(space.getOwner() == null) { // Checks if the space has no owner
				if(player.getBalance() >= space.getCost()) {
					// If the player has enough points. Gives the option to purchase the space
					System.out.println("Your current balance is: " + player.getBalance() + " points.");
					System.out.println("Do you want to purchase for " + space.getCost() + " points? (Type '0' to purchase):"); 
					try { // Only allows the user to input an integer between 2-8
						choice = input.nextInt();
					} catch (InputMismatchException e) {
						choice = 1; // Sets choice to 1 if a non-numeric value is entered and will be interpreted as a 'no' to purchase
					}
					input.nextLine();
					
					if(choice == 0) {
						space.setOwner(player); // Sets the owner of the space to the purchasing player
						player.addPurchase(space);
						// Subtracts points from the player based on the land cost and displays the new balance
						player.setBalance(player.getBalance() - space.getCost());
						System.out.println("\nCongratulations "  + player.getName() + "," + " you now own " + board.getSpace(player.getNumLocation()).getName() + "!" );
						System.out.println("Your new balance is: " + player.getBalance());
					}
				} else {
					// If the player does not have enough points. No purchase option is given
					System.out.println("Your current balance is: " + player.getBalance());
					System.out.println("You do not have enough to purchase this space. You need " + space.getCost() + " points.");
				}
			}else if(space.getOwner() != player){
				// If the space is owned by a different player the owner is paid by the player that landed on the space
				System.out.println("Owned by: " + space.getOwner().getName());
				int value = space.getValue();
				payPlayer(player, space.getOwner(), value);
			}else { // If the space is owned by the current player, give them the option to purchase a sanctuary
				System.out.println("Owned by: " + space.getOwner().getName());
				if(player.getBalance() >= space.getSanctuaryCost() && space.getNumSanctuary() < 3) {
					// If the player has enough points. Gives the option to purchase a sanctuary
					System.out.println("Your current balance is: " + player.getBalance() + " points.");
					System.out.println("Do you want to purchase a sanctuary for this space for " + space.getSanctuaryCost() + " points? (Type '0' to purchase):"); 
					try { // Only allows the user to input an integer between 2-8
						choice = input.nextInt();
					} catch (InputMismatchException e) {
						choice = 1; // Sets choice to 1 if a non-numeric value is entered and will be interpreted as a 'no' to purchase
					}
					input.nextLine();
					
					if(choice == 0) {
						space.addSanctuary();
						System.out.println(space.getName() +" now has " + space.getNumSanctuary() +" sanctuaries and is worth " + space.getValue() + " points!"); 
						player.setBalance(player.getBalance() - space.getSanctuaryCost());
						System.out.println("Your new balance is: " + player.getBalance() + " points.");
					}
				}else {
					System.out.println("You cannot purchase a sanctuary on this space.");
				}

			}
		} else if (boardSquare == squareType.AIRPORT) { // Player lands on an airport square				
			System.out.println("Your current balance is: " + player.getBalance());
			if(player.getBalance() >= 300) { // Checks if player has enough to use the airport
				System.out.println("Would you like to use the airport?  (Type '0' for yes):");
				
				try { // Any input that isn't 0 is interpreted as 'no'
					choice = input.nextInt();
				} catch (InputMismatchException e) {
					choice = 1; // Sets choice to 1 if a non-numeric value is entered and will be interpreted as a 'no' to purchase
				}
				input.nextLine();
				
				if(choice == 0) { // If player decides to use the airport
					player.setNumLocation(player.getNumLocation() + 8); // Places the player onto the next corner
					player.setBalance(player.getBalance() - 300); // Costs 300 points for plane travel
			
					System.out.println("You are now on " + board.getSpace(player.getNumLocation()).getName());
					System.out.println("Your current balance is: " + player.getBalance());
				}
			} else {
				System.out.println("You do not have enough to use the airport.");
			}
			
		} else if (boardSquare == squareType.CARD) { // Player lands on an opportunity card square					
			new Card(player);
		} else if (boardSquare == squareType.DISASTER) { // Player lands on a natural disaster square
			
			Dice rng = new Dice();
			int target = rng.getRandomInt(1, 100);
			
			if (target >= 75) { // Targets player landing on the tile 75% of the time
				new Disaster(player);
			} else if (target >= 95) { // Targets a random player 20% of the time (can roll player who landed on space)
				new Disaster(players.get(rng.getRandomInt(0,  players.size() - 1)));
			} else {
				new Disaster(players); // No target defined, affects everyone
			}
			
		} else if (boardSquare == squareType.WHALEINSIDE) { // Player lands on a whale square
			new Whale(player);
		}
		else { // Player lands on start square, only square that isn't any other type
			
		}
	}
}