package command;

import dao.UserDao;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class DeleteCommand implements Command{
    private final UserDao userDao;

    public DeleteCommand(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl(userDao);
        userService.deleteUser(id);
        return "/user-list.jsp";
    }


}
