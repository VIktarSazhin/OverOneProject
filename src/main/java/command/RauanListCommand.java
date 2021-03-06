package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RauanListCommand implements Command {
    private final UserDao userDao;

    public RauanListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listRauanActivity = userService.selectRauanActivity();
        request.setAttribute("listRauanActivity", listRauanActivity);
        request.getRequestDispatcher("activityRauan.jsp");
        return "activityRauan.jsp";
    }
}
