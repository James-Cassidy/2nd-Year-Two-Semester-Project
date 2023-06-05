package game;

public class AirportSquare extends LocationOnBoard {

	private String Airport;

	public AirportSquare() {
		this(0, "GO");
	}

	public AirportSquare(int spacesFromGo, String airport) {
		super(spacesFromGo, airport);

		this.Airport = airport;
	}
	
	public void setAirportSquare(String airport) {
		this.Airport = airport;
	}
	
	public String getAirportSquare() {
		return this.Airport;
	}
}
