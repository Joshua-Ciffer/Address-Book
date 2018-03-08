package src.addressBook;
import java.util.Scanner;
import java.util.InputMismatchException;
import src.addressBook.backend.Book;
import src.addressBook.backend.Entry;

/**
 * The command line entry point of the address book program.
 * 
 * @author Joshua
 * @version 03/07/2018
 */
public class MainCLI {

	/**
	 * Accepts user text input.
	 */
	private static Scanner userInput = new Scanner(System.in);
	
	/**
	 * Stores user responses to menu prompts.
	 */
	private static short userResponse;
	
	/**
	 * The Book object that stores address entries.
	 */
	private static Book addressBook;
	
	/**
	 * Main entry point.
	 * 
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		do {
			System.out.println("-----Address Book Main Menu-----");
			System.out.println(" (1) Add Entry");
			System.out.println(" (2) Delete Entry");
			System.out.println(" (3) Modify Entry");
			System.out.println(" (4) Find User");
			System.out.println(" (5) View All Entries");
			System.out.print("Enter an option: ");
			try {
				userResponse = userInput.nextShort();
			} catch (InputMismatchException e) {
				userInput.next();	// Clears the scanner.
				
			}
		} while (true);
	}

}