package game;
import java.util.Scanner;

/**
 * The Whale Class generates 2 options for the player to use
 * They will miss 3 in a row unless they pay the eco points fee
 * After they have paid they will no longer be trapped IN_WHALE
 * The player will only just be VISITING
 * @author James Cassidy
 *
 */
public class Whale {

	private Whaletype type;
	/*
	 * Enum used to store different states of Whale
	 * IN_WHALE used when player is trapped inside whale
	 * VISITING used when player has landed on the square through normal means
	 */
	public enum Whaletype {
		VISITING, IN_WHALE
	}
	
	public Whaletype getType() {
		return type;
	}
	
	/**
	 * Method to allow the user to leave the Whale
	 * Must pay 150 eco points to leave
	 * 
	 * Player moves to square 17 so they are no longer
	 * trapped in the whale
	 * 
	 * Used within Whale constructor
	 * @param player
	 */
	private void leaveWhale(Player player) {
		int whaleCost = 150;
		
		if (player.getBalance() > whaleCost) {
			player.setBalance(player.getBalance() - whaleCost);
			System.out.println("You paid 150 eco points to escape the Whale.\n"
					+ "Your current balance is: " + player.getBalance());
			player.setNumLocation(17); //Initially set to 17 so they are no longer in the whale
		}
		else{
			System.out.println("You have insignificant eco points in your account");
		}
	}
	/**
	 * This constructor asks the user if they would like to miss their current or pay the whale fine to be just visiting
	 * @param player
	 */
	public Whale(Player player) {
		
		Whaletype whaletype = Whaletype.IN_WHALE;
		Scanner input = new Scanner (System.in);
		player.setNumLocation(16);
		player.setWhale();
		
		if (whaletype == Whaletype.IN_WHALE) {
			
			System.out.println("You are inside the whale!\n1.) Miss current turn.\n2.) Pay 150 Eco Points?\nPlease enter 1 or 2:");
			String whaleInput = input.nextLine();
			
			switch(whaleInput) {
			
			case "1":
				System.out.println("Missed current turn\nYou are still trapped in the Whale");
				break;
				
			case "2":
				leaveWhale(player);
				whaletype = Whaletype.VISITING;
				break;
				
			default:
				System.out.println("Invalid option, miss turn");
			}
		}
		else {
			whaletype = Whaletype.VISITING;
		}
	}

}