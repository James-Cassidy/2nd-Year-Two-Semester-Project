package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Board.squareType;

class squareTypeTest {

	@Test
	public void squareTypeTest() {
		Player junitPlayer = new Player("player");
		Board junitBoard = new Board();
		squareType junitType = junitBoard.getSquareType(8);
		assertEquals(junitType, squareType.AIRPORT);
	}

}
