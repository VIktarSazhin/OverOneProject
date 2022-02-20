package command;

import dao.UserDao;
import entity.User;
import service.UserService;
import service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class InsertCommand implements Command{
    private final UserDao userDao;

    public InsertCommand(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("user_name");
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");
        User newUser = new User(userName, spendTime, activities);
        UserService userService = new UserServiceImpl(userDao);
        userService.insertUser(newUser);

        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("user-list.jsp");
        return "/user-list.jsp";
    }
}
