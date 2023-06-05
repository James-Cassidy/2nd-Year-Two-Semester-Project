package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	protected String options[];
	protected String title;
	
	/**
	 * Constructor for Menu object
	 * @param title - Title of the menu
	 * @param options - Options of the menu
	 */
	public Menu(String title, String options[]) {
		this.title = title;
		this.options = options;
	}

	/**
	 * Prints out the menu title and options
	 */
	public void displayMenu() {
		if (title != "") { System.out.println(title + "\n"); }
		for (int count = 0; count < options.length; count++) {
			System.out.println((count + 1) + ") " + options[count]);
		}
	}
	
	/**
	 * Gets a choice for the menu
	 * @return - Returns the number entered
	 */
	public int getChoice(Scanner scanner) {
		
		int choice = 0;
		
		do {
			System.out.print("\nEnter your choice : ");
			
			try { // Only allows the user to input an integer between 2-8
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0; // Sets choice to 1 if an invalid option is entered, which will cause to loop to re-iterate
			}
			scanner.nextLine();
			
			if (choice < 1 || choice > options.length) {
				System.out.println("Choice must be between 1-" + options.length);
			}
		} while (choice < 1 || choice > options.length);
		
		return choice;
	}
}
