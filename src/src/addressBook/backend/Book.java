package src.addressBook.backend;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Book implements AddressBook {

	private ArrayList<Entry> addressBook = new ArrayList<>();

	@Override
	public boolean addEntry(String name, int number, String address) {
		if (duplicateEntry(name)) {
			return false;
		} else {
			addressBook.add(new Entry(name, number, address));
			return true;
		}
	}

	@Override
	public String deleteEntry(int index) {
		if (addressBook.get(index) != null) {
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
		if (addressBook.get(index) != null) {
			do {
				Scanner userInput = new Scanner(System.in);
				int userResponse;
				System.out.println(" (1) Name");
				System.out.println(" (2) Number");
				System.out.println(" (3) Address");
				System.out.print("What do you want to change?: ");
				try {
					userResponse = userInput.nextInt();
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
							System.out.print("Enter the number: ");
							try {
								addressBook.get(index).setNumber(userInput.nextInt());
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
		if (findUser(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Entry findUser(String name) {
		for (Entry entry : addressBook) {
			if (entry.getName().equalsIgnoreCase(name)) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public Entry findUser(String name, int number, String address) {
		for (Entry entry : addressBook) {
			if ((entry.getName().equalsIgnoreCase(name)) && (entry.getNumber() == number) && (entry.getAddress().equalsIgnoreCase(address))) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public void printUser(int index) {
		System.out.println(addressBook.get(index));
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