package game;

/**
 * A class to generate an opportunity card
 * @author Darryl Donnelly
 */
public class Card {
	
	final private String[] goodCard = 
		{
			"Congratulations! Your nature preservation efforts have been recognized and you've been awarded.",
			"Congratulations! You launched a successful nature fundraiser.",
			"Congratulations! You rescued some animals from a forest fire.",
			"Congratulations! You got to pet a dog.",
			"Congratulations! You use the correct pronunciation of 'tomato'.",
			"Congratulations! You got an electric car.",
			"Congratulations! You planted many new trees for the planet.",
			"Congratulations! You started planting your own vegetables instead of buying food imported from other countries."
		};
	final private String[] badCard = 
		{
			"Uh oh! You were caught cutting down a protected tree.",
			"Uh oh! An endangered species of lion has fallen ill while under your care due to negligence.",
			"Uh oh! A creeper managed to get into your farm and blew up your potatos and carrots.",
			"Uh oh! The code for the game was accidentally deleted.",
			"Uh oh! The person writing these ran out of ideas but pretend something bad happened.",
			"Uh oh! You use the incorrect pronunciation of 'tomato'.",
			"Uh oh! You dropped the penguin off of Cool Cool Mountain.", // Don't even deny, we know you did it
			"Uh oh! Weeds have started growing in your garden."
		};
	
	/**
	 * Constructor for the Card object. Sets the card text, card type and amount. Amount is always 0 if the card type isn't money
	 */
	public Card(Player player) {
		
		Dice rng = new Dice();
				
		boolean positive = (rng.getRandomInt(1, 2) == 1); // If getRandomInt = 1, positive is true, else positive is false
		int card = rng.getRandomInt(1, 100);
		int cardNo;
		int amount;
		String cardText;
		
		if (positive == false) { // For bad card effects
			
			if (card <= 50) { // 50% chance to add/remove cash
				cardNo = 1;
			} else if (card <= 80) { // 30% chance to move spaces
				cardNo = 2;
			} else { // 20% chance to advance to Go or jail
				cardNo = 3;
			}
			
			cardText = badCard[rng.getRandomInt(0, badCard.length - 1)]; // Gets random card text
			if (cardNo == 1) { // Player pays a fine
				amount = rng.getRandomInt(5, 30) * 10; // Gets a random amount between 50 and 300 in steps of 10
				cardText += "\nPay " + amount + " points!";
				player.setBalance(player.getBalance() - amount);
				System.out.println(cardText + "\nYour new balance is: " + player.getBalance());
			} else if (cardNo == 2) { // Player moves 1-6 spaces backwards
				amount = rng.getRandomInt(1, 6); // Gets a random amount between 1 and 6
				cardText += "\nMove " + amount + " spaces backwards!";
				System.out.println(cardText);				
				Start.updateLocation(player, (amount * -1)); // Multiplying by -1 results in player moving backwards
				
			} else { // Player is sent to the whale
				amount = 0;
				cardText += "\nYou have been sent to the whale!";
				System.out.println(cardText);
				player.setNumLocation(16); // Whale space
				player.setWhale();
			}
		} else { // For good card effects
			
			if (card <= 65) { // 65% chance to add/remove cash
				cardNo = 1;
			} else if (card <= 95) { // 30% chance to move spaces
				cardNo = 2;
			} else { // 5% chance to advance to Go or jail
				cardNo = 3;
			}
			
			cardText = goodCard[rng.getRandomInt(0, goodCard.length - 1)]; // Gets random card text
			if (cardNo == 1) { // Player gains points
				amount = rng.getRandomInt(5, 30) * 10; // Gets a random amount between 50 and 300 in steps of 10
				cardText += "\nGain " + amount + " points!";
				player.setBalance(player.getBalance() + amount);
				System.out.println(cardText + "\nYour new balance is: " + player.getBalance());
			} else if (cardNo == 2) { // Player moves 1-6 spaces forwards
				amount = rng.getRandomInt(1, 6); // Gets a random amount between 1 and 6
				cardText += "\nMove " + amount + " spaces forwards!";
				System.out.println(cardText);
				Start.updateLocation(player, amount);
			} else { // Player lands on Go, gains 150 points for doing so
				amount = 0;
				cardText += "\nMove directly to Go!";
				System.out.println(cardText);
				player.setNumLocation(0); // Go space
				
				System.out.println("Go! Collect 150 points.");
				player.setBalance(player.getBalance() + 150);
			}
		}		
	}
}
