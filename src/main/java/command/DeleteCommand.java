package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class DeleteCommand implements Command {
    private final UserDao userDao;

    public DeleteCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl(userDao);
        userService.deleteUser(id);

        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp");
        return "/user-list.jsp";
    }
}

