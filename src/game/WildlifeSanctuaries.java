package game;

/*
 * This class acts as the lots on a property
 * A maximum of 3 wildlife sanctuaries(lots) can be added on a property
 * A player that does not own a property will have to pay rent depending on the lots on a property
 */

public class WildlifeSanctuaries extends Property {
	
	protected int rent;
	protected int wsPrice;
	protected int wsOwned;
	
	//Default Constructor
	public WildlifeSanctuaries()
	{
		this(" ", 0, 0, 0, 0); //name, cost, spacesFromGo, rent, price
	}
	
	//Constructor
	public WildlifeSanctuaries(String name, int cost, int spacesFromGo, int rent, int wsPrice) 
	{
		super(name, cost, spacesFromGo);
		
		if (rent >= 0 )
			this.rent = rent;
		else
			this.rent = 0;
		
		this.wsPrice = 0;
		this.wsOwned = 0;
	}
	
	public void setRent(int rent) {
		if (rent >= 0)
			this.rent = rent;
	}

	public void setWSPrice(int wsPrice) {
		if (wsPrice >= 0) 
			this.wsPrice = 0;
	}

	public void setWSsOwned(int wsOwned) {
		if (wsOwned > 0 && wsOwned < 4 )
			this.wsOwned = wsOwned;
	}

	public int getRent() {
		return this.rent;
	}

	public int getWSPrice() {
		return this.wsPrice;
	}

	public int getWSOwned() {
		return this.wsOwned;
	}
}
