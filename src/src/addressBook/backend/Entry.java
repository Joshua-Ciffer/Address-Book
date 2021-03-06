package src.addressBook.backend;

/**
 * This class represents a single entry in an address book. A single entry can store a name, phone number, and address.
 * 
 * @author Joshua Ciffer
 * @version 03/07/2018
 */
class Entry implements AddressEntry {

	/**
	 * This entry's name.
	 */
	private String name;

	/**
	 * This entry's phone number.
	 */
	private long phoneNumber;

	/**
	 * This entry's address.
	 */
	private String address;

	/**
	 * Constructs a new Entry object with blank information.
	 */
	public Entry() {
		name = "";
		phoneNumber = 0;
		address = "";
	}

	/**
	 * Constructs a new Entry object with specified information.
	 * 
	 * @param name - The entry's name.
	 * @param phoneNumber - The entry's phone number.
	 * @param address - The entry's address.
	 */
	public Entry(String name, long phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Name: " + name + "    -    Phone Number: " + phoneNumber + "    -    Address: " + address;
	}

	@Override
	public boolean equals(Object entry) {
		if (this.toString().equalsIgnoreCase(((Entry)entry).toString())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public long getPhoneNumber() {
		return phoneNumber;
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
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

}