package pattern.commands;

import dao.UserDao;
import entity.User;
import pattern.Command;
import service.UserService;
import service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class SelectCommand implements Command {
    private final UserDao userDao;

    public SelectCommand(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        UserService userService = new UserServiceImpl(userDao);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp");
        return "user-list.jsp";
    }
}
