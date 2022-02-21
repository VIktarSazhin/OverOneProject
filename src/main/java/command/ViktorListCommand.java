package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ViktorListCommand implements Command {
    private final UserDao userDao;

    public ViktorListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listViktorActivity = userService.selectViktorActivity();
        request.setAttribute("listViktorActivity", listViktorActivity);
        request.getRequestDispatcher("activityViktor.jsp");
        return "activityViktor.jsp";
    }
}
