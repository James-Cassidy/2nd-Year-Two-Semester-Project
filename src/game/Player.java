package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
		private String name;
		private String colour;
		private int balance;
		private boolean bankrupt;
		private boolean inWhale;
		private int placesOnBoard;
		private List<Property> ownedPlaces;
		//Array list Properties owned
		
		public Player() {
			this(" ");
		}
		
		public Player(String name) {
			this.name = name;
			this.balance = 1500;
			this.bankrupt = false;
			this.inWhale = false;
			this.placesOnBoard = 0;
			this.ownedPlaces = new ArrayList<Property>();
		}
		
		//Getters and Setters
		public void setName(String name) {
			this.name = name;
		}
		
		public void setBalance(int balance) {
			this.balance = balance;
		}
		
		public int getNumLocation() {
			return this.placesOnBoard;
		}
		
		public String getName() {
			return this.name;
		}

		public int getBalance() {
			return this.balance;
		}
		
		public void setNumLocation(int numLocation) {
			this.placesOnBoard = numLocation;
			if (this.placesOnBoard >= 32) // If player lands on or passes Go going forwards
				this.placesOnBoard -= 32;
			
			if (this.placesOnBoard < 0) // If player passes Go going backwards
				this.placesOnBoard += 32;
		}
		
		public void addPurchase(Property location) {
			ownedPlaces.add(location);
		}
		public void removePurchase(Property location) {
			ownedPlaces.remove(location);
		}
		public List<Property> getPurchaseList(){
			return this.ownedPlaces;
		}
		
		public boolean isBankrupt() {
			return this.bankrupt;
		}
		
		public boolean isInWhale() {
			return this.inWhale;
		}
		
		public void setWhale() {
			this.inWhale = true;
		}
}

