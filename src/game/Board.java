package game;
public class Board {
	
	private Player currentPlayer;
	private LocationOnBoard[] squares = new LocationOnBoard[32];
	private int numOfPlayers;
	
	public enum squareType {
		PROPERTY, AIRPORT, CARD, WHALEINSIDE, LOCATION, DISASTER
	}

	public Board() {
		this(0);
	}
	
	public Board(int numOfPlayers) {
		
		if (numOfPlayers > 2)
			this.numOfPlayers = numOfPlayers;
		else 
			this.numOfPlayers = 1;

		this.currentPlayer = null;
		initializeGameBoard();
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		if ( numOfPlayers > 2 && numOfPlayers < 6)
			this.numOfPlayers = numOfPlayers;
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public int getNumOfPlayers() {
		return this.numOfPlayers;
	}
	
	public LocationOnBoard getSpace(int pos) {
		return this.squares[pos];
	}
	
	/**
	 * If the player lands on a property tile, returns it. Otherwise, returns null
	 * @param pos - The position on the board the player is on
	 * @return - Returns the property tile, or null if player isn't on a property tile
	 */
	public Property getProperty(int pos) {	
		if (getSquareType(pos) == squareType.PROPERTY) {
			return (Property) this.squares[pos];
		}
		return null;
	}
	
	/**
	 * If the player lands on an airport tile, returns it. Otherwise, returns null
	 * @param pos - The position on the board the player is on
	 * @return - Returns the airport tile, or null if player isn't on a property tile
	 */
	public AirportSquare getAirport(int pos) {	
		if (getSquareType(pos) == squareType.AIRPORT) {
			return (AirportSquare) this.squares[pos];
		}
		return null;
	}
	
	/**
	 * If the player lands on a card tile, returns it. Otherwise, returns null
	 * @param pos - The position on the board the player is on
	 * @return - Returns the card tile, or null if player isn't on a property tile
	 */
	public CardSquare getCardSquare(int pos) {	
		if (getSquareType(pos) == squareType.CARD) {
			return (CardSquare) this.squares[pos];
		}
		return null;
	}
	
	/**
	 * If the player lands on a jail tile, returns it. Otherwise, returns null
	 * @param pos - The position on the board the player is on
	 * @return - Returns the jail tile, or null if player isn't on a property tile
	 */
	public WhaleSquare getWhaleInside(int pos) {	
		if (getSquareType(pos) == squareType.WHALEINSIDE) {
			return (WhaleSquare) this.squares[pos];
		}
		return null;
	}
	
	/**
	 * If the player lands on a disaster tile, returns it. Otherwise, returns null
	 * @param pos - The position on the board the player is on
	 * @return - Returns the disaster tile, or null if player isn't on a disaster tile
	 */
	public DisasterSquare getDisaster(int pos) {	
		if (getSquareType(pos) == squareType.DISASTER) {
			return (DisasterSquare) this.squares[pos];
		}
		return null;
	}
	
	public squareType getSquareType(int pos) {
		if (squares[pos] instanceof Property) {
			return squareType.PROPERTY;
		} else if (squares[pos] instanceof AirportSquare) {
			return squareType.AIRPORT;
		} else if (squares[pos] instanceof CardSquare) {
			return squareType.CARD;
		} else if (squares[pos] instanceof WhaleSquare) {
			return squareType.WHALEINSIDE;
		} else if (squares[pos] instanceof DisasterSquare) {
			return squareType.DISASTER;
		} else {
			return squareType.LOCATION;
		}		
	}
	
	//Used to show squares and their values
	public void initializeGameBoard() 
	{
		squares[0] = new LocationOnBoard(0, "Start");
		squares[1] = new DisasterSquare(1, "Natural Disaster");
		squares[2] = new Property("Sea 1", 60, 2);
		squares[3] = new Property("Sea 2", 100, 3);
		squares[4] = new CardSquare(4, "Opportunity");
		squares[5] = new Property("Ocean 1", 120, 5);
		squares[6] = new Property("Ocean 2", 100, 6);
		squares[7] = new Property("Ocean 3", 130, 7);
		squares[8] = new AirportSquare(8, "Airport 1");
		squares[9] = new Property("Plains 1", 140, 9);
		squares[10] = new Property("Plains 2", 150, 10);
		squares[11] = new Property("Plains 3", 160, 11);
		squares[12] = new CardSquare(12, "Opportunity"); 
		squares[13] = new Property("Desert 1", 170, 13);
		squares[14] = new Property("Desert 2", 180, 14);
		squares[15] = new Property("Desert 3", 200, 15);
		squares[16] = new WhaleSquare(16, "Whale");
		squares[17] = new DisasterSquare(17, "Natural Disaster");
		squares[18] = new Property("Forest 1", 220, 18);
		squares[19] = new Property("Forest 2", 240, 19);
		squares[20] = new CardSquare(20, "Opportunity");
		squares[21] = new Property("Rainforest 1", 260, 21);
		squares[22] = new Property("Rainforest 2", 260, 22);
		squares[23] = new Property("Rainforest 3", 280, 23); 
		squares[24] = new AirportSquare(24, "Airport 2");
		squares[25] = new Property("Tundra 1", 300, 25);
		squares[26] = new Property("Tundra 2", 300, 26);
		squares[27] = new Property("Tundra 3", 320, 27);
		squares[28] = new CardSquare(28, "Opportunity");
		squares[29] = new Property("Arctic 1", 330, 29);
		squares[30] = new Property("Arctic 2", 360, 30);
		squares[31] = new Property("Arctic 3", 400, 31);
	}
}
