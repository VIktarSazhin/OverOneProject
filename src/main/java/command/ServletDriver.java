package command;

import dao.UserDao;
import service.UserService;
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
    private static Map<String,Command> commandMap = new HashMap<>();
    private UserService userService;



    public void init() {
        UserDao userDao = new UserDao();
        userService = new UserServiceImpl(userDao);
        commandMap.put("new",new ShowNewCommand(userDao));
        commandMap.put("select",new SelectCommand(userDao));
        commandMap.put("insert",new InsertCommand(userDao));
        commandMap.put("delete",new DeleteCommand(userDao));
        commandMap.put("update",new UpdateCommand(userDao));
        commandMap.put("edit",new ShowEditCommand(userDao));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            process(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String commandName = request.getParameter("command");
        Command command = get(commandName);
        String forward = command.execute(request,response);
        if (forward != null){
            RequestDispatcher disp = request.getRequestDispatcher(forward);
            disp.forward(request,response);
        }
//        String redirectUrl = command.execute(request,response);
//        response.sendRedirect(redirectUrl);
    }
    private void redirect(Command command,HttpServletRequest request,HttpServletResponse response) throws ServletException, SQLException, IOException {
        String redirectUrl = command.execute(request,response);
        response.sendRedirect(redirectUrl);
    }
    private void forward(Command command, HttpServletResponse response,HttpServletRequest request) throws ServletException, SQLException, IOException {
        String forward = command.execute(request,response);
        if (forward != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
            dispatcher.forward(request,response);
        }
    }
    private static Command get(String commandName){
        try {

            if (commandName == null || !commandMap.containsKey(commandName)) {
                throw new NullPointerException();
            }
            return commandMap.get(commandName);
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
    }


}
