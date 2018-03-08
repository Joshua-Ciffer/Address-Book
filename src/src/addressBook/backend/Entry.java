package src.addressBook.backend;

/**
 * This class represents a single entry in an address book. A single entry can store a name, number, and address.
 * 
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
public class Entry implements AddressEntry {

	/**
	 * This entry's name.
	 */
	private String name;

	/**
	 * This entry's number.
	 */
	private int number;

	/**
	 * This entry's address.
	 */
	private String address;

	/**
	 * Constructs a new Entry object with blank information.
	 */
	public Entry() {
		name = "";
		address = "";
	}

	/**
	 * Constructs a new Entry object with specified information.
	 * 
	 * @param name - The entry's name.
	 * @param number - The entry's number.
	 * @param address - The entry's address.
	 */
	public Entry(String name, int number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

}