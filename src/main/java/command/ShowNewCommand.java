package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowNewCommand implements Command {
    private final UserDao userDao;

    public ShowNewCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        UserService userService = new UserServiceImpl(userDao);
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp");
        return "/user-list.jsp";
    }
}