package src.addressBook;
import java.util.Scanner;
import java.util.InputMismatchException;
import src.addressBook.backend.Book;

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
				System.out.println("\nEnter on of the given options.\n");
				continue;
			}
			switch (userResponse) {
				case 1: {	// Add entry.
					String name, address;
					int number;
					userInput.nextLine();
					System.out.print("Enter the name: ");
					name = userInput.nextLine();
					do {
						System.out.print("Enter the number: ");
						try {
							
						} catch (InputMismatchException e) {
							userInput.next();	// Clears the scanner.
							System.out.println("\nPlease enter the number.\n");
							
						}
					} while (true);
				}
				case 2: {
					
				}
				case 3: {
					
				}
				case 4: {
					
				}
				case 5: {
					
				}
			}
		} while (true);
	}

}