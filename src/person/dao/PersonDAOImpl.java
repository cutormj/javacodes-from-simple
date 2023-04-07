package person.dao;

import databaseConnection.DatabaseConnection;
import person.Person;

import java.sql.*;

public class PersonDAOImpl implements PersonDAO{

    @Override
    public boolean addPerson(Person person) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("INSERT INTO person_tbl(person_fname, person_mname, person_lname, person_email, person_phonenumber) VALUES (?,?,?,?,?)");
            stmt.setString(1, person.getName().getFirstName());
            stmt.setString(2, person.getName().getMiddleName());
            stmt.setString(3, person.getName().getLastName());
            stmt.setString(4, person.getEmail());
            stmt.setString(5, person.getPhoneNumber());
            int rows = stmt.executeUpdate();

            return rows > 0;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int addPersonWithGeneratedKey(Person person) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement("INSERT INTO person_tbl(person_fname, person_mname, person_lname, person_email, person_phonenumber) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, person.getName().getFirstName());
            stmt.setString(2, person.getName().getMiddleName());
            stmt.setString(3, person.getName().getLastName());
            stmt.setString(4, person.getEmail());
            stmt.setString(5, person.getPhoneNumber());
            int rows = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                System.out.println(rs.getInt(1));
                int gnrtd_id = rs.getInt(1);
                return gnrtd_id;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        return false;
    }
}
