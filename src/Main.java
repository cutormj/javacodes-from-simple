import forms.PersonForm;
import forms.UserRegistrationForm;
import person.Person;
import user.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        User user = UserRegistrationForm.createUser();

        System.out.println(user.getPerson().getPersonInfo());

    }
}