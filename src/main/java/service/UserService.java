package service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void insertUser(User user);

    List<User> selectAllUsers();

    List<User> selectAnnaActivity();

    List<User> selectViktorActivity();

    List<User> selectAlexActivity();

    List<User> selectVasyaActivity();

    List<User> selectRauanActivity();

    List<User> selectSergeyActivity();

    void deleteUser(int id) throws SQLException;

    String getJSON();
}
