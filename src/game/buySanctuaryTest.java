package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class buySanctuaryTest {

	@Test
	public void buySanctuaryTest() {
		Player junitPlayer = new Player("player");
		junitPlayer.setNumLocation(2);
		int cost = 60;
		int intialBal = junitPlayer.getBalance();
		Property junitProp = new Property("Sea 1", cost, junitPlayer.getNumLocation());
		junitPlayer.addPurchase(junitProp);
		
		junitProp.addSanctuary();
		
		boolean bool = false;
		if(junitProp.getNumSanctuary() == 1 && junitProp.getSanctuary()) {
			bool = true;
		}
		
		assertEquals(bool, true);
	}

}
