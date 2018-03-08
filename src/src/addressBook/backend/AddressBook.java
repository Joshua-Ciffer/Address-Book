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
  * @return True - If the entry is successfully added to the address book.
  */
  boolean addEntry();
  
  /**
   * Deletes the current entry.
   *
   * @return The info from the deleted entry.
   */
  String deleteEntry();
  
  /**
   * Modifies the current entry.
   */
  void modifyEntry();
  
  /**
   * Determines if there are any duplicate entries.
   *
   * @return True - If more than one of the given entry exists.
   */
  boolean duplicateEntry();
  
  /**
   * Locates a specific entry in the address book.
   *
   * @param name - The user's name.
   * @param number - The user's number.
   * @param address - The user's address.
   * @return The Entry object associated with that user.
   */
  Entry findUser(String name, int number, String address);
  
  /**
   * Prints out the information of the user with the given name.
   *
   * @param name - The user's name.
   */
  void printUsers(String name);
  
}