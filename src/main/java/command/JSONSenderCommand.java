package command;

import com.google.gson.Gson;
import dao.UserDao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.TestToGetJsonFromDB;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JSONSenderCommand implements Command{
    private final UserDao userDao;

    public JSONSenderCommand(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        try{
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            Gson gson = new Gson();
//            JSONObject jsonObject = new JSONObject();
//            JSONArray array = new JSONArray();
//            ResultSet rs = TestToGetJsonFromDB.RetrieveData();
//            while (rs.next()) {
//                JSONObject record = new JSONObject();
//                record.put("user_name", rs.getString("user_name"));
//                record.put("spend_time", rs.getDouble("spend_time"));
//                record.put("activities", rs.getString("activities"));
//                array.add(record);
//            }
//            jsonObject.put("Players_data", array);
//            String jsonData = gson.toJson(jsonObject);
//            PrintWriter out = response.getWriter();
//            out.println(jsonData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
        UserService userService = new UserServiceImpl(userDao);
        String jsonData = userService.getJSON();
        PrintWriter out = response.getWriter();
        out.println(jsonData);

        return "send-json.jsp";
    }
}
