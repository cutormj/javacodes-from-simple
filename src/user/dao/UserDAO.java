package user.dao;

import user.User;

public interface UserDAO {
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}

