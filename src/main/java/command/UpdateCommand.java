package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class UpdateCommand implements Command{
    private final UserDao userDao;

    public UpdateCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        UserService userService = new UserServiceImpl(userDao);
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("user_name");
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");
        User newUser = new User(id, userName, spendTime, activities);
        userService.updateUser(newUser);

        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp");
        return "/user-list.jsp";
    }
}
