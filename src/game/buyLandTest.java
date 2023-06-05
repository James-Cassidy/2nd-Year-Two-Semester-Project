package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class buyLandTest {

	@Test
	public void buyLandTest() {
		Player junitPlayer = new Player("player");
		junitPlayer.setNumLocation(2);
		int cost = 60;
		int intialBal = junitPlayer.getBalance();
		
		Property junitProp = new Property("Sea 1", cost, junitPlayer.getNumLocation());
		junitPlayer.addPurchase(junitProp);
		
		boolean bool = false;
		if(!(junitPlayer.getPurchaseList() == null)) {
			bool = true;
		}
		
		assertEquals(bool, true);
	}

}