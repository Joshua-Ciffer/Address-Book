package src.addressBook.backend;

/**
 * This interface contains methods required to be implemented in the Entry class.
 *
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
interface AddressEntry {

	/**
	 * @return The entry's name.
	 */
	String getName();

	/**
	 * @return The entry's phone number.
	 */
	long getPhoneNumber();

	/**
	 * @return The entry's address.
	 */
	String getAddress();

	/**
	 * @param name - The entry's name.
	 */
	void setName(String name);

	/**
	 * @param phoneNumber - The entry's phone number.
	 */
	void setPhoneNumber(long phoneNumber);

	/**
	 * Sets the address for this entry.
	 *
	 * @param address - The entry's address.
	 */
	void setAddress(String address);

}