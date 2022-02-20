package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEditCommand implements Command{
    private final UserDao userDao;

    public ShowEditCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserServiceImpl(userDao);
        User existingUser = userService.selectUser(id);
        request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        return "user-form.jsp";
    }
}
