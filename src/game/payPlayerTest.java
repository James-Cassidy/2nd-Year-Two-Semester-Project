package game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class payPlayerTest {

	@Test
	public void payPlayerTest() {
		Player junitPlayer = new Player("player");
		Player junitOwner = new Player("owner");
		int playerStarting = junitPlayer.getBalance();
		int ownerStarting = junitOwner.getBalance();
		int value = 200;
		Start.payPlayer(junitPlayer, junitOwner, value);
		assertEquals(junitPlayer.getBalance(), playerStarting - value);
		assertEquals(junitOwner.getBalance(), ownerStarting + value);
	}

}
