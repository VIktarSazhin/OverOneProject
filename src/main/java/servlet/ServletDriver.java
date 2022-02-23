package servlet;

import command.*;
import dao.UserDao;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class ServletDriver extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Map<String, Command> commandMap = new HashMap<>();

    public void init() {
        UserDao userDao = new UserDao();
        new UserServiceImpl(userDao);
        commandMap.put("select", new SelectCommand(userDao));
        commandMap.put("insert", new InsertCommand(userDao));
        commandMap.put("delete", new DeleteCommand(userDao));
        commandMap.put("AnnaListActivity", new AnnaListCommand(userDao));
        commandMap.put("ViktorListActivity", new ViktorListCommand(userDao));
        commandMap.put("AlexListActivity", new AlexListCommand(userDao));
        commandMap.put("SergeyListActivity", new SergeyListCommand(userDao));
        commandMap.put("VasyaListActivity", new VasyaListCommand(userDao));
        commandMap.put("RauanListActivity", new RauanListCommand(userDao));
        commandMap.put("GetJSON", new JSONSenderCommand(userDao));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String commandName = request.getParameter("command");
        Command command = get(commandName);
        String forward = command.execute(request, response);
        if (forward != null) {
            RequestDispatcher disp = request.getRequestDispatcher(forward);
            disp.forward(request, response);
        }
    }

    private static Command get(String commandName) {
        try {
            if (commandName == null || !commandMap.containsKey(commandName)) {
                throw new NullPointerException();
            }
            return commandMap.get(commandName);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}

