package game;

public class LocationOnBoard {
	
	private static final int maxSquares = 32;
	protected int spacesFromGo;
	protected String name;
	
	public LocationOnBoard() {
		this(0, " ");	
	}

	public LocationOnBoard(int spacesFromGo, String name) {
		
		if (spacesFromGo >= 0 && spacesFromGo < maxSquares) 
			this.spacesFromGo = spacesFromGo;

		else
			this.spacesFromGo = 0;
		this.name = name;
	}
	
	public void setSpacesFromGo (int spacesFromGo) {
		if (spacesFromGo >= 0 && spacesFromGo < maxSquares) 
			this.spacesFromGo = spacesFromGo;
	}

	public int getSpacesFromGo() {
		return this.spacesFromGo;
	}

	public String getName() {
		return this.name;
	}
}
