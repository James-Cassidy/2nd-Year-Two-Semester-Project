package game;

import java.util.ArrayList;
import java.util.List;

public class Disaster {
	
	final private String[] flavourText = 
		{
			"Disaster! A powerful earthquake has struck!",
			"Disaster! A tsunami has flooded the area!",
			"Disaster! Lightning has struck a huge tree down!",
			"Disaster! A blaze is consuming the area!",
			"Disaster! Drought has caused many plantlife to wither and die!",
			"Disaster! Torrential rainfall has ruined many crops and destroyed the area!",
			"Disaster! A nearby volcanic eruption has rendered the land temporarily uninhabitable!",
			"Disaster! Blizzards have resulted in heavy snowfall and ice!"
		};
	
	private List<Player> players;
	private Dice rng = new Dice();
	private String text;
	
	/**
	 * Constructor for Disaster class for a Natural Disaster card affecting all players
	 * @param players - A list of all players
	 */
	public Disaster(List<Player> players) {
		this.players = players;
		Dice rng = new Dice();
		this.text = flavourText[rng.getRandomInt(0, flavourText.length - 1)];
		
		if (rng.getRandomInt(1, 2) == 1) {
			this.text += removeProperties();
		} else {
			this.text += removeSanctuaries();
		}
		
		System.out.print(this.text);
	}
	
	/**
	 * Constructor for Disaster class for a Natural Disaster card targeting a specific player
	 * @param target -  A player being targeted for the effect of the card
	 */
	public Disaster(Player target) {
		Dice rng = new Dice();
		this.text = flavourText[rng.getRandomInt(0, flavourText.length - 1)];
		if (rng.getRandomInt(1, 2) == 1) {
			this.text += removeProperty(target);
		} else {
			this.text += removeSanctuary(target);
		}
		System.out.print(this.text);
	}
	
	/**
	 * Removes a random property from the given player if they have any
	 * @param player - The player to remove a property from
	 */
	private String removeProperty(Player player) {
		List<Property> propertyList = player.getPurchaseList();
		Property property;
		
		if (!propertyList.isEmpty()) {
			property = propertyList.get(rng.getRandomInt(0, propertyList.size() - 1));
			property.removeOwner();
			player.removePurchase(property);
			return "\n" + property.getName() +" was badly damaged.\n" + player.getName() +" lost " + property.getName() + ".\n";
			

		} else {
			player.setBalance(player.getBalance() - 150);
			return "\n" + player.getName() + " pays a fine of 150 points for cost of restoration.\n";
		}
	}
	
	/**
	 * Removes a random property from every player that has one
	 */
	private String removeProperties() {
		String text = "";
		for (Player player : players) {
			text += removeProperty(player);
		}
		return text;
	}
	
	/**
	 * Removes a random sanctuary from a given player
	 * @param player - The player to remove a sanctuary from
	 */
	private String removeSanctuary(Player player) {
		List<Property> propertyList = player.getPurchaseList();
		List<Property> sanctuaryList = new ArrayList<>();
		
		if (!propertyList.isEmpty()) {
			for (Property sanctuary : propertyList) {
				if (sanctuary.getSanctuary()) {
					sanctuaryList.add(sanctuary);
				}
			}	
			if (!sanctuaryList.isEmpty()) {
				Property property = sanctuaryList.get(rng.getRandomInt(0, sanctuaryList.size() - 1));
				property.removeSanctuary();
				
				return "\nThe santuary on " + property.getName() +" was badly damaged.\n"
				+ player.getName() +" lost " + property.getName() + "'s sanctuary.\n";
			}
		}
		return "\nFortunately, not much happened.\n";
	}
	
	/**
	 * Removes a random sanctuary from every player
	 */
	private String removeSanctuaries() {
		String text = "";
		for (Player player : players) {
			text += removeSanctuary(player);
		}
		return text;
	}
}
