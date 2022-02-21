package command;

import dao.UserDao;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class JSONSenderCommand implements Command {
    private final UserDao userDao;

    public JSONSenderCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        UserService userService = new UserServiceImpl(userDao);
        String jsonData = userService.getJSON();
        PrintWriter out = response.getWriter();
        out.println(jsonData);

        return "send-json.jsp";
    }
}
