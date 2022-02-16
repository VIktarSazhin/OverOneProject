package service;

import dao.UserService;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements service.UserService {
    private final UserService userDao;

    public UserServiceImpl(UserService userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(User user) {
        try{
            if (user == null) throw new IllegalArgumentException();
            if (user.getTimeToSpend() < 0 || user.getTimeToSpend() > 24) throw new NumberFormatException();


                User newUser = User.builder()
                        .userName(user.getUserName())
                        .timeToSpend(user.getTimeToSpend())
                        .activity(user.getActivity())
                        .timeToAdd(user.getTimeToAdd())
                        .build();
                userDao.insertUser(newUser);

        }catch (NumberFormatException exception){
            throw new NumberFormatException("incorrect time");
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("not found user");
        }
    }

    @Override
    public User selectUser(int id) {
        User user = userDao.selectUser(id);
        try {
            if (user == null) throw new NullPointerException();

            return userDao.selectUser(id);

        }catch (NullPointerException e){
            throw new NullPointerException("not found user");
        }
    }
    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        User user = userDao.selectUser(id);
        try {
            if (user == null) throw new NullPointerException();

            return userDao.deleteUser(id);

        }catch (NullPointerException e){
            throw new NullPointerException("not found user");
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        User newUser = userDao.selectUser(user.getId());
        try {
            if (newUser == null) throw new IllegalArgumentException();
            if (user.getTimeToSpend() < 0 || user.getTimeToSpend() > 24) throw new NumberFormatException();

            return userDao.updateUser(user);

        }catch (NumberFormatException exception){
            throw new NumberFormatException("incorrect time");
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("not found user");
        }

    }
}
