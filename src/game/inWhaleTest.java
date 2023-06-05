package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class inWhaleTest {

	@Test
	public void inWhaleTest() {
		Player junitPlayer = new Player("player");
		junitPlayer.setNumLocation(16);
		junitPlayer.setWhale();
		boolean junitWhale = junitPlayer.isInWhale();
		assertEquals(junitWhale,true);
	}

}
