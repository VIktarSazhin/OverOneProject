package servlet;

import com.google.gson.Gson;
import dao.UserDao;
import entity.User;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.TestToGetJsonFromDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/ActivityAnnaZanko":
                    activityAnna(request, response);
                    break;
                case "/ActivitySergey":
                    showNewForm(request, response);
                    break;
                case "/ActivityAlex":
                    showNewForm(request, response);
                    break;
                case "/ActivityViktorSazhin":
                    activityViktor(request, response);
                    break;
                case "/ActivityVitya":
                    showNewForm(request, response);
                    break;
                case "/ActivityRauan":
                    showNewForm(request, response);
                    break;
                case "/addActivity":
                    addActivity(request, response);
                    break;
                case "/addActivityForm" :
                    showFormToAddActivity(request, response);
                    break;
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/sendJson":
                    sendJson(request, response);
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    public void showFormToAddActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addActivityForm.jsp");
        dispatcher.forward(request, response);
    }

    private void activityAnna(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        List<User> listAnnaActivity = userDAO.selectActivityAnna();
        request.setAttribute("listAnnaActivity", listAnnaActivity);
        RequestDispatcher dispatcher = request.getRequestDispatcher("activityAnna.jsp");
        dispatcher.forward(request, response);
    }

    private void activityViktor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        List<User> listAnnaActivity = userDAO.selectActivityViktor();
        request.setAttribute("listViktorActivity", listAnnaActivity);
        RequestDispatcher dispatcher = request.getRequestDispatcher("activityViktor.jsp");
        dispatcher.forward(request, response);
    }

    private void addActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");
        User newUser = new User(spendTime, activities);
        userDAO.addUserActivity(newUser);
        String nameActivity = "/Activity" + newUser.getUserName().replace(" ", "");
        System.out.println(nameActivity);
        response.sendRedirect(nameActivity);
    }


    private void sendJson(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject();
            JSONArray array = new JSONArray();
            ResultSet rs = TestToGetJsonFromDB.RetrieveData();
            while (rs.next()) {
                JSONObject record = new JSONObject();
                record.put("user_name", rs.getString("user_name"));
                record.put("spend_time", rs.getDouble("spend_time"));
                record.put("activities", rs.getString("activities"));
                array.add(record);
            }
            jsonObject.put("Players_data", array);
            String jsonData = gson.toJson(jsonObject);
            PrintWriter out = response.getWriter();
            out.println(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String userName = request.getParameter("user_name");
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");
        User newUser = new User(userName, spendTime, activities);
        userDAO.insertUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("user_name");
        double spendTime = Double.parseDouble(request.getParameter("spend_time"));
        String activities = request.getParameter("activities");

        User book = new User(id, userName, spendTime, activities);
        userDAO.updateUser(book);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("list");
    }
}