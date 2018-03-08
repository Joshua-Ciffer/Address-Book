package src.addressBook.backend;

/**
 * This interface contains methods required to be implemented in the Entry class.
 *
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
interface AddressEntry {

	/**
	 * Returns the name stored in this entry.
	 *
	 * @returns The entry's name.
	 */
	String getName();

	/**
	 * Returns the phone number stored in this entry.
	 *
	 * @return The entry's phone number.
	 */
	long getPhoneNumber();

	/**
	 * Returns the address stored in this entry.
	 *
	 * @return The entry's address.
	 */
	String getAddress();

	/**
	 * Sets the name for this entry.
	 *
	 * @param name - The entry's name.
	 */
	void setName(String name);

	/**
	 * Sets the phone number for this entry.
	 *
	 * @param number - The entry's phone number.
	 */
	void setPhoneNumber(long phoneNumber);

	/**
	 * Sets the address for this entry.
	 *
	 * @param address - The entry's address.
	 */
	void setAddress(String address);

}