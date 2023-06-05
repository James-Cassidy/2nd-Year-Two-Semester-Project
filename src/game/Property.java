package game;

public class Property extends LocationOnBoard {

	protected int cost;
	protected int sanctuaryCost;
	protected Player owner;
	protected boolean available;
	protected boolean ownedProperties;

	private boolean hasSanctuary;
	private int numSanctuary;
	protected int value;

	public Property() 
	{
		this(" ", 0, 0);
	}
	
	public Property(String name, int cost, int spacesFromGo) {
		super(spacesFromGo, name);
		
		this.available = true;
		if (cost > 0) { 
			this.cost = cost;
			this.value = cost = (int)(cost*0.2);
			this.sanctuaryCost = 100;
			this.numSanctuary = 0;
		}
		else
			this.cost = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void removeOwner() {
		this.owner = null;
		this.available = true;
		removeSanctuary();
	}
	
	public void addSanctuary() {
		if(this.numSanctuary < 3) {
			this.numSanctuary++;
			double valueMod = 0.2 + this.numSanctuary/10.0;
			int newValue = (int)(cost*valueMod);
			this.setValue(newValue);
		}
		if(this.numSanctuary > 0) {
			this.hasSanctuary = true;
		}
	}

	public void removeSanctuary() {
		if(numSanctuary > 0) {
			this.numSanctuary--;
			this.setValue((int)(cost*(0.2 + numSanctuary/10)));
		}
		if(this.numSanctuary <= 0) {
			this.hasSanctuary = false;
		}
	}
	
	public void removeAllSanctuary() {
		this.numSanctuary = 0;
		this.hasSanctuary = false;
	}


	public boolean getSanctuary() {
		return this.hasSanctuary;
	}
	
	public int getNumSanctuary() {
		return this.numSanctuary;
	}

	public int getSanctuaryCost() {
		return this.sanctuaryCost;
	}

	public void setValue(int value) {
		if (value > 0)
			this.value = value;
	}
	
	public void setOwner(Player player) {
		this.owner = player;
	}

	public String getName() {
		return this.name;
	}

	public int getCost() {
		return this.cost;
	}
	
	public int getValue() {
		return this.value;
	}

	public Player getOwner() {
		return this.owner;
	}

	public boolean getAvailability() {
		return this.available;
	}
}
