package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class VasyaListCommand implements Command {
    private final UserDao userDao;

    public VasyaListCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserServiceImpl(userDao);
        List<User> listVasyaActivity = userService.selectVasyaActivity();
        request.setAttribute("listVasyaActivity", listVasyaActivity);
        request.getRequestDispatcher("activityVasya.jsp");
        return "activityVasya.jsp";
    }
}

