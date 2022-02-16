package command;

import dao.UserService;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class InsertCommand implements Command{
    private final UserService userService;

    public InsertCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("user_name");
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");
        User newUser = new User(userName, spendTime, activities);
        userService.insertUser(newUser);
        response.sendRedirect("list");
        return userName;
    }
}
