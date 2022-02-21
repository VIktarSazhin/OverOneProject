package service;

import dao.UserDao;
import entity.User;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(User user) {
        try {
            if (user == null) throw new IllegalArgumentException();
            if (user.getTimeToSpend() < 0 || user.getTimeToSpend() > 24) throw new NumberFormatException();

            User newUser = User.builder()
                    .userName(user.getUserName())
                    .timeToSpend(user.getTimeToSpend())
                    .activity(user.getActivity())
                    .timeToAdd(user.getTimeToAdd())
                    .build();
            userDao.insertUser(newUser);

        } catch (NumberFormatException exception) {
            throw new NumberFormatException("incorrect time");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("not found user");
        }
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public List<User> selectAnnaActivity() {
        return userDao.selectActivityAnna();
    }

    @Override
    public List<User> selectViktorActivity() {
        return userDao.selectActivityViktor();
    }

    @Override
    public List<User> selectAlexActivity() {
        return userDao.selectActivityAlex();
    }

    @Override
    public List<User> selectVasyaActivity() {
        return userDao.selectActivityVasya();
    }

    @Override
    public List<User> selectRauanActivity() {
        return userDao.selectActivityRauan();
    }

    @Override
    public List<User> selectSergeyActivity() {
        return userDao.selectActivitySergey();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        User user = userDao.selectUser(id);
        LocalDateTime userDate = user.getTimeToAdd().toLocalDateTime();
        LocalDateTime previousDay = LocalDateTime.now().minusDays(1);
        try {
            if (userDate.compareTo(previousDay) >= 0) {
                userDao.deleteUser(id);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("not found user");
        }
    }

    @Override
    public String getJSON() {
        return userDao.getJSON();
    }
}
