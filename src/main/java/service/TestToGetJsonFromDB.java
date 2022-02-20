package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestToGetJsonFromDB {
    public static ResultSet RetrieveData() throws Exception {
        DriverManager.registerDriver(new org.postgresql.Driver());
        String mysqlUrl = "jdbc:postgresql://35.233.143.254:5432/postgres";
        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "password");
        System.out.println("Connection established......");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from users");
        return rs;
    }

    public static void create() throws Exception {
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ResultSet rs = RetrieveData();
        while(rs.next()) {
            JSONObject record = new JSONObject();
            record.put("user_name", rs.getString("user_name"));
            record.put("spend_time", rs.getDouble("spend_time"));
            record.put("activities", rs.getString("activities"));
            array.add(record);
        }
        jsonObject.put("Players_data", array);
        try {
            FileWriter file = new FileWriter("src/main/resources/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created......");
    }
}
