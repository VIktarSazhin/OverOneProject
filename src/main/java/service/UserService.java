package service;

import entity.User;
import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void insertUser(User user);
    User selectUser(int id);
    List<User> selectAllUsers();
    List<User> selectAnnaActivity();
    void deleteUser(int id) throws SQLException;
    void updateUser(User user) throws SQLException;
    String getJSON();
}
