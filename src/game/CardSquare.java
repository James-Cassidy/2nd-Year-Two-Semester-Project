package game;

public class CardSquare extends LocationOnBoard {
	private String Card;
	
	public CardSquare() 
	{
		
	}
	
	public CardSquare(int spacesFromGo, String card) {
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
