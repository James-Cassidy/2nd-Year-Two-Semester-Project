package game;

/**
 * @author James Cassidy Class used to generate the Whale Square
 */
public class WhaleSquare extends LocationOnBoard {

	private String Whale;

	public WhaleSquare(int spacesFromGo, String whale) {
		super(spacesFromGo, whale);

		this.Whale = whale;
	}

	public void setWhaleSquare(String whale) {
		this.Whale = whale;
	}

	public String getWhaleSquare() {
		return this.Whale;
	}
}
