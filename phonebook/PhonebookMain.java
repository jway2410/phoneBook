package phonebook;

import java.util.Scanner;

public class PhonebookMain {

	public static person addPerson(Directory contact, Scanner sc) {

		System.out.println("Please type the first name");
		String firstName = sc.nextLine();

		System.out.println("Please type the middle name");
		String middleName = sc.nextLine();
		System.out.println("Please type the last name");
		String lastName = sc.nextLine();
		System.out.println("Please type the street number");
		int streetNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Please type the street name");
		String streetName = sc.nextLine();
		System.out.println("Please type the city");
		String city = sc.nextLine();
		System.out.println("Please type the state");
		String state = sc.nextLine();
		System.out.println("Please type the zip code");
		String zipCode = sc.nextLine();
		System.out.println("Please type the phone number. ex:1234567890");
		long phoneNumber = sc.nextLong();

		person p3 = new person(firstName, middleName, lastName, phoneNumber);
		p3.addAddress(streetNumber, streetName, city, state, zipCode);
		return p3;

	}

	public static void searchFirstName(Directory contact, Scanner sc) {
		System.out.println("Please type the first name");
		String firstName = sc.nextLine();

		person[] matches = contact.searchByFirstName(firstName); // this finds all the people with the requested first
																	// name

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static void searchLastName(Directory contact, Scanner sc) {
		System.out.println("Please type the last name");
		String lastName = sc.nextLine();

		person[] matches = contact.searchByLastName(lastName);

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static void searchFullName(Directory contact, Scanner sc) {
		System.out.println("Please type the full name");
		String fullName = sc.nextLine();

		person[] matches = contact.searchByFullName(fullName);

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static void searchPhoneNumber(Directory contact, Scanner sc) {
		System.out.println("Please type the phone number");
		long phoneNumber = sc.nextLong();

		person[] matches = contact.searchByPhoneNumber(phoneNumber);

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static void searchCity(Directory contact, Scanner sc) {
		System.out.println("Please type the city");
		String city = sc.nextLine();

		person[] matches = contact.searchByCity(city);

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static void searchState(Directory contact, Scanner sc) {
		System.out.println("Please type the state");
		String state = sc.nextLine();

		person[] matches = contact.searchByState(state);

		for (int i = 0; i < matches.length; i++) {
			matches[i].getPerson(); // each person is printed out
		}
	}

	public static Directory deleteContact(Directory contact, Scanner sc) {
		System.out.println("Please type the phone number of an entry you want to delete");
		Long phoneNumber = sc.nextLong();
		Directory directory = new Directory();

		person[] matches = contact.removeContact(phoneNumber);

		for (int j = 0; j < matches.length; j++) {
			matches[j].getPerson(); // each person is printed out
			directory.addPerson(matches[j]);
		}
		return directory;
	}

	public static Directory updateContact(Directory primary, Scanner sc) {
		System.out.println("Please type the phone number of an entry you want to update");
		Long phoneNumber = sc.nextLong();
		Directory directory = new Directory();
		primary.updateContact(phoneNumber);
		return directory;
	}

	public static void showContact(Directory primary, Scanner sc) {
		primary.printDirectory();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Directory primary = new Directory();

		person p1 = new person("Joo", "Seung", "Kim", 7037777613L);
		person p2 = new person("Jin", "Hyung", "Kim", 7033031437L);

		// add address
		p1.addAddress(4356, "battery st", "Centreville", "VA", "20120");
		p2.addAddress(4356, "battery st", "Centreville", "VA", "20120");

		// add to the directory
		primary.addPerson(p2);
		primary.addPerson(p1);

		primary.printDirectory();

		/*
		 * System.out.
		 * println("Please enter information for the to be added separated by commas");
		 * System.out.println("FORMAT: Name, Stree Address, City(no periods, i.e)," +
		 * "state, ZipCode, Phone Number");
		 * 
		 * String info = input.nextLine();
		 * 
		 * //separate info into an array of strings String[] tempInfo =
		 * info.split(", ");
		 * 
		 * //set variables for each index String name = tempInfo[0]; String street =
		 * tempInfo[1]; String city = tempInfo[2]; String state = tempInfo[3]; String
		 * zipCode = tempInfo[4]; long phoneNumber = Long.parseLong(tempInfo[5]);
		 */

		int choice;

		do {
			System.out.println("1 = add new contact");
			System.out.println("2 = search by first name");
			System.out.println("3 = search by last name");
			System.out.println("4 = search by full name");
			System.out.println("5 = search by phone number");
			System.out.println("6 = search by city");
			System.out.println("7 = search by state");
			System.out.println("8 = Delete a contact");
			System.out.println("9 = Update a contact");
			System.out.println("10 = Show all contact");
			System.out.println("11 = exit the program");

			choice = sc.nextInt();
			sc.nextLine();

			person p3 = new person();

			person empty;
			System.out.println();

			if (choice == 1) {

				empty = addPerson(primary, sc);
				primary.addPerson(empty);

			} else if (choice == 2) {
				searchFirstName(primary, sc);
			} else if (choice == 3) {
				searchLastName(primary, sc);
			} else if (choice == 4) {
				searchFullName(primary, sc);
			} else if (choice == 5) {
				searchPhoneNumber(primary, sc);
			} else if (choice == 6) {
				searchCity(primary, sc);
			} else if (choice == 7) {
				searchState(primary, sc);
			} else if (choice == 8) {
				primary = deleteContact(primary, sc);
			} else if (choice == 9) {
				updateContact(primary, sc);
			} else if (choice == 10) {
				showContact(primary, sc);
			}
		} while (choice != 11);
		System.out.println("Thank you for using the program");
	}
}
