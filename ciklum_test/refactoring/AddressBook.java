import java.util.LinkedList;
import java.util.List;

public class AddressBook {
	private static  AddressBook instance = null;

	private AddressDb db =new AddressDb();

	private List<Person> addressBookList = new LinkedList<>();

	public AddressBook() {
		new Checker().start();
	}

	public boolean hasMobile(String name) {
		if (db.findPerson(name).getPhoneNumber().getNumberVal().startsWith("070")) {
			return true;		
		} else {
			return false;
		}		
	}
	
	public int getSize() {
		List<Person> people = db.getAll();
		int count = -1;

		for (Person person : people) {
            ++count;
        }
			
		return count;
	}
	
	/**
	 * Gets the given user's mobile phone number,
	 * or null if he doesn't have one.
	 */
	public String getMobile(String name) {			
		Person person = db.findPerson(name);
		PhoneNumber phone = person.getPhoneNumber();
		
		return phone.getNumber();
	}
	
	/**
	 * Returns all names in the book truncated to the given length.
	 */
	public List getNames(int maxLength) {
		List<Person> people = db.getAll();
		List<String> names = new LinkedList<>();
		
		for (Person person : people) {
			String name = person.getName();
			if (name.length() > maxLength) {
				name = name.substring(0, maxLength);
			}
			names.add(name);
		}
			
		return names;
	}

	/**
	 * Returns all people who have mobile phone numbers.
	 */
	private List<Person> getList() {
		List<Person> people = db.getAll();
		LinkedList<Person> personWithMobile = new LinkedList<>();
		
		for (Person person : people) {
			if (person.getPhoneNumber().getNumber().startsWith("070")) {
				personWithMobile.add(person);
			}
		}
		
		return personWithMobile;
	}

	private class Checker extends Thread {
		public void run() {
			while(true) {
				AddressBook.this.addressBookList = AddressBook.this.getList();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					/*null*/
				}
			}
		}
	}


	public List<Person> getAddressBookList() {
		return addressBookList;
	}

	public static AddressBook getInstance() {
		if (instance==null)
			instance= new AddressBook();
		return instance;
	}
}
