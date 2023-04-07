package person.dao;

import person.Person;

public interface PersonDAO {
    boolean addPerson(Person person);
    int addPersonWithGeneratedKey(Person person);
    boolean deletePerson(Person person);
    boolean updatePerson(Person person);
}
