package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AnnaListCommand implements Command {
    private final UserDao userDao;

    public AnnaListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listAnnaActivity = userService.selectAnnaActivity();
        request.setAttribute("listAnnaActivity", listAnnaActivity);
        request.getRequestDispatcher("activityAnna.jsp");
        return "activityAnna.jsp";
    }
}
