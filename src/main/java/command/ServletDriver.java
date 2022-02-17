package command;

import dao.UserDao;
import lombok.NoArgsConstructor;

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

@NoArgsConstructor
public class ServletDriver extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Map<String,Command> commandMap = new HashMap<>();
    private UserDao userDao;

    public ServletDriver(UserDao userDao) {
        this.userDao = userDao;
    }

    public void init() {
        commandMap.put("/showNew",new ShowNewCommand());
        commandMap.put("/select",new SelectCommand(userDao));
        commandMap.put("/insert",new InsertCommand(userDao));
        commandMap.put("/delete",new DeleteCommand(userDao));
        commandMap.put("/update",new UpdateCommand(userDao));
        userDao = new UserDao();
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
            process(request,response);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
    }

    private static Command get(String commandName){
        try {
//            if (commandName == null || !commandMap.containsKey(commandName)) {
//                throw new NullPointerException();
//            }
            return commandMap.get(commandName);

        }catch (NullPointerException e){
            throw new NullPointerException();
        }
    }
}
