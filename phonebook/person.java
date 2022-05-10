package phonebook;

public class person {

    private String firstName;
    private String lastName;
    private String middleName;
    private long phoneNumber;
    private Address address;

    public void addAddress(int streetNum, String streetName, String city, String state, String zipCode) {
        Address tempAddress = new Address(streetNum, streetName, city, state, zipCode);
        address = tempAddress;
    }

    public Address getAddress() {
        return this.address;
    }

    public person() {

    }

    public person(String firstName, String middleName, String lastName, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void getPerson() {
        if(middleName.length() !=0) {
            System.out.println(firstName + " " + middleName + " " + lastName);
        } else {
            System.out.println(firstName + " " + lastName);
        }
        address.printAddress();
        System.out.println("Phone Number: " + formatPhone(phoneNumber));
        System.out.println("-------------------------------------");
    }

    // format phone number
    public String formatPhone(long phone) {
        String newPhone = Long.toString(phone);
        String formattedPhone = "(" + newPhone.substring(0,3) + ")" + newPhone.substring(3,6) + "-" + newPhone.substring(6);
        return formattedPhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
