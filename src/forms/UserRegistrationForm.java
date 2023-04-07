package forms;


import account.Account;
import person.Person;
import user.User;
import user.dao.UserDAO;
import user.dao.UserDAOImpl;
import user.type.UserType;

import java.util.Scanner;

public class UserRegistrationForm {
    public static User createUser() {
        Scanner scanner = new Scanner(System.in);

        // Create a new Person object using the PersonForm
        Person person = PersonForm.createPerson();

        // Ask for user type
        System.out.print("Enter user type (ADMIN, USER): ");
        UserType userType = UserType.valueOf(scanner.nextLine().toUpperCase());

        // Ask for username and password
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Create and return User object
        User user = new User.UserBuilder()
                .withPerson(person)
                .withUserType(userType)
                .withAccount(new Account.AccountBuilder()
                        .withUsername(username)
                        .withPassword(password)
                        .build())
                .build();

        UserDAO userDAO = new UserDAOImpl();
        boolean success = userDAO.addUser(user);

        System.out.println(success);

        System.out.println("User Information");
        System.out.println(user.getPerson().getPersonInfo());
        System.out.println(user.getAccount().getUsername());
        System.out.println(user.getUserType().name());

        return user;
    }
}
