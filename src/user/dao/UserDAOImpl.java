package user.dao;

import databaseConnection.DatabaseConnection;
import person.Person;
import person.dao.PersonDAO;
import person.dao.PersonDAOImpl;
import user.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean addUser(User user) {

        PersonDAO personDAO = new PersonDAOImpl();
        int person_generated_id = personDAO.addPersonWithGeneratedKey(user.getPerson());

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement("INSERT INTO user_tbl (user_usertype_id, user_person_id, user_name, user_password) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, 1);
            stmt.setInt(2, person_generated_id);
            stmt.setString(3, user.getAccount().getUsername());
            stmt.setString(4, user.getAccount().getPassword());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        /*Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement("UPDATE users SET name=?, email=?, password=?, userType=? WHERE id=?");
            stmt.setString(1, user.getPerson().getName());
            stmt.setString(2, user.getPerson().getEmail());
            stmt.setString(3, user.getAccount().getPassword());
            stmt.setString(4, user.getUserType().toString());
            stmt.setInt(5, user.getId());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        /*Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM users WHERE id=?");
            stmt.setInt(1, user.getId());
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return false;
    }
}

