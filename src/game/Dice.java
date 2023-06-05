package game;
import java.util.Random;

//Dice Class
public class Dice {

    private int value;

    public Dice() {
    	value = -1;
    }
    
    public void setValue(int diceValue) {
           value = diceValue;
    }

    public int getValue() {
           return value;
    }

    public void rollDice(int numOfDice) {
        value = 0;
        for(int i = 1; i <= numOfDice; i++)
        	value += getRandomInt(1, 6);
    }
    
    /**
	 * Gets a random integer between a provided minimum and maximum integer inclusive
	 * @param min - The minimum value in the range
	 * @param max - The maximum value in the range
	 * @return - A random value between min and max inclusive
	 */
	public int getRandomInt(int min, int max) {
		Random rng = new Random();
		int num = rng.nextInt(max - min + 1) + min;
		
		return num;
	}
}
