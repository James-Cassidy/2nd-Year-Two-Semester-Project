package game;

import game.Start;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class updateLocationTest {

	@Test
	public void updateLocationTest() {
		Player junitPlayer = new Player("player");
		int spaces = 11;
		int currentPos = junitPlayer.getNumLocation();
		Start.updateLocation(junitPlayer, spaces);
		assertEquals(junitPlayer.getNumLocation(), currentPos+spaces);
	}

}
