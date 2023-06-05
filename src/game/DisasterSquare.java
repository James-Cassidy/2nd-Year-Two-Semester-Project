package game;

public class DisasterSquare extends LocationOnBoard {
	private String Card;
	
	public DisasterSquare() 
	{
		
	}
	
	public DisasterSquare(int spacesFromGo, String card) {
		super(spacesFromGo, card);
		
		this.Card = card;
	}
	
	
	public void setCardSquare(String card) {
		this.Card = card;
	}
	
	public String getCardSquare() {
		return this.Card;
	}

}
