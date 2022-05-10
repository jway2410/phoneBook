package phonebook;

import java.util.Scanner;

public class Directory {
	// create an array of peaopl

	person[] person = new person[0];
	Address[] Address = new Address[0];

	// add person to array
	public void addPerson(person newPerson) {
		// create temp array one larger than current array
		person[] temp = new person[person.length + 1];

		// add people in the original array to the temporary array
		for (int i = 0; i < person.length; i++) {
			temp[i] = person[i];
		}
		// at the end of the array, add the new person object
		temp[temp.length - 1] = newPerson;

		// reassign the original array to the temp one
		person = temp;
	}

	public person[] getPerson() {
		return person;
	}

	// print entire directory
	public void printDirectory() {
		for (int i = 0; i < person.length; i++) {
			person[i].getPerson();
		}
	}

	public void printDirectoryArray(person[] searched) {
		for (int i = 0; i < searched.length; i++) {
			searched[i].getPerson();
		}
	}

	// search functions below
	// search by first name
	public person[] searchByFirstName(String firstName) {
		// set a counter for the size of the array
		int counter = 0;

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length; i++) {
			// search parameters via conditional statement
			if (person[i].getFirstName().equals(firstName)) {
				counter++;
			}
		}
		// create a new array to hold the found people in the directory
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equals(firstName)) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] searchByLastName(String lastName) {
		// set a counter for the size of the array
		int counter = 0;

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length; i++) {
			// search parameters via conditional statement
			if (person[i].getLastName().equals(lastName)) {
				counter++;
			}
		}
		// create a new array to hold the found people in the directory
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getLastName().equals(lastName)) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] searchByFullName(String fullName) {
		String[] names = fullName.split(" ");
		String firstName = names[0];
		String middleName = names[1];
		String lastName = names[2];

		// set a counter for the size of the array
		int counter = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equals(firstName) && person[i].getMiddleName().equals(middleName)
					&& person[i].getLastName().equals(lastName)) {
				counter++;
			}
		}
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equals(firstName) && person[i].getMiddleName().equals(middleName)
					&& person[i].getLastName().equals(lastName)) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] searchByPhoneNumber(long phoneNumber) {
		// set a counter for the size of the array
		int counter = 0;

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length; i++) {
			// search parameters via conditional statement
			if (person[i].getPhoneNumber() == phoneNumber) {
				counter++;
			}
		}
		// create a new array to hold the found people in the directory
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getPhoneNumber() == phoneNumber) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] searchByCity(String city) {
		// set a counter for the size of the array
		int counter = 0;

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length; i++) {
			// search parameters via conditional statement
			if (person[i].getAddress().getCity().equals(city)) {
				counter++;
			}
		}
		// create a new array to hold the found people in the directory
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getCity().equals(city)) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] searchByState(String state) {
		// set a counter for the size of the array
		int counter = 0;

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length; i++) {
			// search parameters via conditional statement
			if (person[i].getAddress().getState().equals(state)) {
				counter++;
			}
		}
		// create a new array to hold the found people in the directory
		person[] tempArray = new person[counter];

		// set a counter for the new array
		int x = 0;

		for (int i = 0; i < person.length; i++) {
			if (person[i].getAddress().getState().equals(state)) {
				tempArray[x] = person[i];
				x++;
			}
		}
		return tempArray;
	}

	public person[] removeContact(long phoneNumber) {
		// set a counter for the size of the array
		person[] tempArray = new person[person.length - 1];

		// for loop to determine the number of people in the new array
		for (int i = 0; i < person.length - 1; i++) {

			// search parameters via conditional statement
			if (person[i].getPhoneNumber() != phoneNumber) {
				for (int j = 0; j < person.length - 1; j++)
					tempArray[i] = person[j];

			}
		}
		return tempArray;
	}

	public void updateContact(long phoneNumber) {
		// set a counter for the size of the array
		person[] searchResults = searchByPhoneNumber(phoneNumber);	
      	
		if (searchResults.length > 0) {
          person personToUpdate = searchResults[0];
          updatePerson(personToUpdate);
          
        }
	}

	public static void updatePerson(person personToUpdate) {
      	Scanner sc = new Scanner(System.in);

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


        personToUpdate.setFirstName(firstName);
        personToUpdate.setMiddleName(middleName);
        personToUpdate.setLastName(lastName);
        personToUpdate.setPhoneNumber(phoneNumber);

        Address updatedAddress = new Address(streetNumber, streetName, city, state, zipCode);
        personToUpdate.setAddress(updatedAddress);


	}
}