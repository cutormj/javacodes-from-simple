package person.test;

import name.Name;
import person.Person;
import person.dao.PersonDAO;
import person.dao.PersonDAOImpl;

public class Main {

    public static void main(String[] args) {

        Name name = new Name.Builder()
                .firstName("Mark Joseph")
                .middleName("Gare")
                .lastName("Cutor")
                .build();

        Person person = new Person.Builder()
                .name(name)
                .email("mark@mail.com")
                .phoneNumber("435843095")
                .build();

        PersonDAO personDAO = new PersonDAOImpl();
        int result = personDAO.addPersonWithGeneratedKey(person);

        System.out.println(result);
    }

}
