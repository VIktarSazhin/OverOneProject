package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SergeyListCommand implements Command {
    private final UserDao userDao;

    public SergeyListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listSergeyActivity = userService.selectSergeyActivity();
        request.setAttribute("listSergeyActivity", listSergeyActivity);
        request.getRequestDispatcher("activitySergey.jsp");
        return "activitySergey.jsp";
    }
}
