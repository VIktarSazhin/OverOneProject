package service;

import dao.UserDao;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(User user) {
        User newUser = User.builder()
                .userName(user.getUserName())
                .timeToSpend(user.getTimeToSpend())
                .activity(user.getActivity())
                .timeToAdd(user.getTimeToAdd())
                .build();
        userDao.insertUser(newUser);
    }

    @Override
    public User selectUser(int id) {
        return userDao.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }
}
