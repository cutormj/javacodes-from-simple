package databaseConnection.test;
import databaseConnection.DatabaseConnection;
import name.Name;
import person.Person;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person_tbl");

            while (resultSet.next()) {

                Name name = new Name.Builder()
                        .firstName(resultSet.getString("person_fname"))
                        .middleName(resultSet.getString("person_mname"))
                        .lastName(resultSet.getString("person_lname"))
                        .build();

                Person person = new Person.Builder()
                        .name(name)
                        .email(resultSet.getString("person_email"))
                        .phoneNumber(resultSet.getString("person_phonenumber"))
                        .build();

                System.out.println(person.getPersonInfo());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
