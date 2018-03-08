package src.addressBook.backend;

/**
 * This interface contains the methods that must be implemented in the Book class.
 *
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
interface AddressBook {

	/**
	 * Adds a new entry.
	 *
	 * @param name - The entry's name.
	 * @param number - The entry's phone number.
	 * @param address - The entry's address.
	 * @return True - If the entry is successfully added to the address book.
	 */
	boolean addEntry(String name, int phoneNumber, String address);

	/**
	 * Deletes the current entry.
	 *
	 * @param entry - The entry's index.
	 * @return The info from the deleted entry.
	 */
	String deleteEntry(int entry);

	/**
	 * Modifies the current entry.
	 * 
	 * @param entry - The entry's index.
	 */
	void modifyEntry(int entry);

	/**
	 * Determines if there are any duplicate entries.
	 *
	 * @param name - The entry's name.
	 * @return True - If more than one of the given entry exists.
	 */
	boolean duplicateEntry(String name);

	/**
	 * Locates a specific entry in the address book.
	 * 
	 * @param name - The user's name.
	 * @return The Entry object associated with that user.
	 */
	Entry findEntry(String name);

	/**
	 * Locates a specific entry in the address book.
	 *
	 * @param name - The user's name.
	 * @param number - The user's phone number.
	 * @param address - The user's address.
	 * @return The Entry object associated with that user.
	 */
	Entry findEntry(String name, int phoneNumber, String address);

	/**
	 * Prints out the information of the user with the given name.
	 *
	 * @param entry - The entry's index.
	 */
	void printUser(int entry);

	/**
	 * Prints out all of the entries in the address book.
	 */
	void printAll();

}