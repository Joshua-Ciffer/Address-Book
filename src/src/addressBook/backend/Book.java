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
		index--;
		if (((index > 0) && (index < addressBook.size())) && (addressBook.get(index) != null)) {
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
		index--;
		if (((index > 0) && (index < addressBook.size())) && (addressBook.get(index) != null)) {
			do {
				Scanner tempUserInput = new Scanner(System.in);
				short userResponse;
				System.out.println(" (1) Name");
				System.out.println(" (2) Phone Number");
				System.out.println(" (3) Address");
				System.out.print("What do you want to change?: ");
				try {
					userResponse = tempUserInput.nextShort();
				} catch (InputMismatchException e) {
					tempUserInput.next();	// Clears the scanner,
					System.out.println("\nEnter one of the given options\n");
					continue;
				}
				switch (userResponse) {
					case 1: {
						tempUserInput.nextLine();
						System.out.print("\nEnter the name: ");
						addressBook.get(index).setName(tempUserInput.nextLine());
						break;
					}
					case 2: {
						do {
							System.out.print("\nEnter the phone number: ");
							try {
								addressBook.get(index).setPhoneNumber(tempUserInput.nextInt());
							} catch (InputMismatchException e) {
								System.out.println("\nEnter the entry's phone number.\n");
								continue;
							}
							break;
						} while (true);
						break;
					}
					case 3: {
						tempUserInput.nextLine();
						System.out.print("\nEnter the address: ");
						addressBook.get(index).setAddress(tempUserInput.nextLine());
						break;
					}
					default: {
						System.out.println("\nEnter one of the given options.\n");
						continue;
					}
				}
				tempUserInput.close();
				tempUserInput = null;
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
		index--;
		if (((index > 0) && (index < addressBook.size())) && (addressBook.get(index) != null)) {
			System.out.println(addressBook.get(index));
		} else {
			System.out.println("\nThis entry does not exist.\n");
		}
	}

	@Override
	public void printAll() {
		for (int i = 0; i < addressBook.size(); i++) {
			if (addressBook.get(i) != null) {
				System.out.println("#" + (i + 1) + ": " + addressBook.get(i));
			}
		}
	}

}