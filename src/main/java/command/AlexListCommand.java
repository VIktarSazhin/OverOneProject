package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AlexListCommand implements Command {
    private final UserDao userDao;

    public AlexListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listAlexActivity = userService.selectAlexActivity();
        request.setAttribute("listAlexActivity", listAlexActivity);
        request.getRequestDispatcher("activityAlex.jsp");
        return "activityAlex.jsp";
    }
}

