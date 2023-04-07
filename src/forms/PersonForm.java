package forms;

import name.Name;
import person.Person;

import java.util.Scanner;

public class PersonForm {
    public static Person createPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Personal Information Registration Form");

        // Ask for name
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter middle name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Create Name object
        Name name = new Name.Builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();

        // Ask for email and phone number
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create and return Person object
        Person person = new Person.Builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();

        System.out.println("Personal Information");
        System.out.println(person.getPersonInfo());

        return person;
    }

}
