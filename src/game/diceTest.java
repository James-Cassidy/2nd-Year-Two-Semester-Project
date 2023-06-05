package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class diceTest {

	@Test
	public void diceTest() {
		Dice junitDice = new Dice();
		junitDice.rollDice(2);
		int result = junitDice.getValue();
		boolean bool = false;
		if(result <= 12 && result >= 2) {
			bool = true;
		}
		assertEquals(bool, true);
	}

}
