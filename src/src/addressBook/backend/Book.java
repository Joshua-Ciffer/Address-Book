package src.addressBook.backend;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class represents one address book that can contain multiple entries.
 * 
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
public class Book implements AddressBook {

	/**
	 * Stores the individual entries.
	 */
	private ArrayList<Entry> addressBook;
	
	/**
	 * Constructs a new Book object.
	 */
	public Book() {
		addressBook = new ArrayList<>();
	}

	@Override
	public boolean addEntry(String name, int phoneNumber, String address) {
		if (duplicateEntry(name)) {
			return false;
		} else {
			addressBook.add(new Entry(name, phoneNumber, address));
			return true;
		}
	}

	@Override
	public String deleteEntry(int index) {
		if ((addressBook.get(index) != null) || ((index > 0) && (index < addressBook.size()))) {
			String deletedEntry = addressBook.get(index).toString();
			addressBook.remove(index);
			return deletedEntry;
		} else {
			System.out.println("\nThis entry does not exist.\n");
			return null;
		}
	}

	@Override
	public void modifyEntry(int index) {
		if ((addressBook.get(index) != null) || ((index > 0) && (index < addressBook.size()))) {
			do {
				Scanner userInput = new Scanner(System.in);
				short userResponse;
				System.out.println(" (1) Name");
				System.out.println(" (2) Phone Number");
				System.out.println(" (3) Address");
				System.out.print("What do you want to change?: ");
				try {
					userResponse = userInput.nextShort();
				} catch (InputMismatchException e) {
					userInput.next();	// Clears the scanner,
					System.out.println("\nEnter one of the given options\n");
					continue;
				}
				switch (userResponse) {
					case 1: {
						userInput.nextLine();
						System.out.print("Enter the name: ");
						addressBook.get(index).setName(userInput.nextLine());
						break;
					}
					case 2: {
						do {
							System.out.print("Enter the phone number: ");
							try {
								addressBook.get(index).setPhoneNumber(userInput.nextInt());
							} catch (InputMismatchException e) {
								System.out.println("\nEnter the entry's number.\n");
								continue;
							}
							break;
						} while (true);
						break;
					}
					case 3: {
						userInput.nextLine();
						System.out.print("Enter the address: ");
						addressBook.get(index).setAddress(userInput.nextLine());
						break;
					}
					default: {
						System.out.println("\nEnter one of the given options.\n");
						continue;
					}
				}
				userInput.close();
				userInput = null;
				break;
			} while (true);
		} else {
			System.out.println("\nThis entry does not exist.\n");
		}
	}

	@Override
	public boolean duplicateEntry(String name) {
		if (findEntry(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Entry findEntry(String name) {
		for (Entry entry : addressBook) {
			if (entry.getName().equalsIgnoreCase(name)) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public Entry findEntry(String name, int phoneNumber, String address) {
		for (Entry entry : addressBook) {
			if ((entry.getName().equalsIgnoreCase(name)) && (entry.getPhoneNumber() == phoneNumber) && (entry.getAddress().equalsIgnoreCase(address))) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public void printUser(int index) {
		if ((addressBook.get(index) != null) || ((index > 0) && (index < addressBook.size()))) {
			System.out.println(addressBook.get(index));
		} else {
			System.out.println("\nThis entry does not exist.\n");
		}
	}

	@Override
	public void printAll() {
		for (int i = 0; i < addressBook.size(); i++) {
			if (addressBook.get(i) != null) {
				System.out.println("#" + i + ": " + addressBook.get(i));
			}
		}
	}

}