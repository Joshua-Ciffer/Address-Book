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
	private static Scanner userInput;

	/**
	 * Stores user responses to menu prompts.
	 */
	private static int userResponse;

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
		userInput = new Scanner(System.in);
		addressBook = new Book();
		do {
			System.out.println("-----Address Book Main Menu-----");
			System.out.println(" (1) Add Entry");
			System.out.println(" (2) Delete Entry");
			System.out.println(" (3) Modify Entry");
			System.out.println(" (4) Find User");
			System.out.println(" (5) View All Entries");
			System.out.println(" (6) Exit");
			System.out.print("Enter an option: ");
			try {
				userResponse = userInput.nextInt();
			} catch (InputMismatchException e) {
				userInput.next();	// Clears the scanner.
				System.out.println("\nEnter on of the given options.\n");
				continue;
			}
			switch (userResponse) {
				case 1: {	// Add entry.
					String name, address;
					long phoneNumber;
					userInput.nextLine();
					System.out.print("\nEnter the name: ");
					name = userInput.nextLine();
					do {
						System.out.print("Enter the phone number: ");
						try {
							phoneNumber = userInput.nextLong();
						} catch (InputMismatchException e) {
							userInput.next();	// Clears the scanner.
							System.out.println("\nPlease enter the phone number.\n");
							continue;
						}
						break;
					} while (true);
					userInput.nextLine();
					System.out.print("Enter the address: ");
					address = userInput.nextLine();
					if (addressBook.addEntry(name, phoneNumber, address)) {
						System.out.println("\nAdded new entry to the address book.\n");
					} else {
						System.out.println("\nThere is already an entry that exists with the same name.\n");
					}
					break;
				}
				case 2: {	// Delete entry.
					System.out.print("\n");
					addressBook.printAll();
					do {
						System.out.print("\nWhich entry would you like to delete?: ");
						try {
							userResponse = userInput.nextInt();
						} catch (InputMismatchException e) {
							userInput.next();	// Clears the scanner;
							System.out.println("\nPlease specify which entry you want to delete.\n");
							continue;
						}
						String deletedEntry = addressBook.deleteEntry(userResponse);
						if (deletedEntry != null) {
							System.out.println("\nDeleted entry.\n");
						}
						break;
					} while (true);
					break;
				}
				case 3: {	// Modify entry.
					System.out.print("\n");
					addressBook.printAll();
					do {
						System.out.print("\nWhich entry would you like to modify?: ");
						try {
							userResponse = userInput.nextInt();
						} catch (InputMismatchException e) {
							userInput.next();	// Clears the scanner;
							System.out.println("\nPlease specify which entry you want to modify.\n");
							continue;
						}
						addressBook.modifyEntry(userResponse, userInput);
						System.out.print("\n");
						break;
					} while (true);
					break;
				}
				case 4: {	// Find user.
					String name;
					userInput.nextLine();
					System.out.print("\nEnter the name of the entry you would like to search for: ");
					name = userInput.nextLine();
					if (addressBook.findEntry(name) != null) {
						System.out.println("\nFound entry: " + addressBook.findEntry(name) + "\n");
					} else {
						System.out.println("\nNo matching entries could be found.\n");
					}
					break;
				}
				case 5: {	// View all entries.
					System.out.print("\n");
					addressBook.printAll();
					System.out.print("\n");
					break;
				}
				case 6: {	// Exit.
					System.exit(0);
					break;
				}
				case 7: {
					System.out.println(addressBook.addressBook);
					System.out.println(addressBook.addressBook.size());
				}
				default: {	// Error
					System.out.println("\nEnter one of the given options.\n");
					continue;
				}
			}
		} while (true);
	}

}