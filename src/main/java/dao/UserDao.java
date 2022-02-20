package dao;

import entity.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public UserDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://35.233.143.254:5432/postgres", "postgres", "password");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public String getJSON() {
        JSONObject jsonObject = new JSONObject();
        String jsonString = "";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_name, spend_time, activities FROM users")) {
            JSONArray array = new JSONArray();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                JSONObject record = new JSONObject();
                record.put("user_name", rs.getString("user_name"));
                record.put("spend_time", rs.getDouble("spend_time"));
                record.put("activities", rs.getString("activities"));
                array.add(record);
            }
            jsonObject.put("Players_data", array);
            jsonString= jsonObject.toJSONString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public void createFileJson(JSONObject jsonObject) {
        try {
            FileWriter file = new FileWriter("src/main/resources/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUserActivity(User user) {
        selectUser(user.getId());
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users" + "  (user_name, spend_time, activities) VALUES " +
                " (? , ?, ?);")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setDouble(2, user.getTimeToSpend());
            preparedStatement.setString(3, user.getActivity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void insertUser(User user) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users" + "  (user_name, spend_time, activities) VALUES " +
                " (?, ?, ?);")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setDouble(2, user.getTimeToSpend());
            preparedStatement.setString(3, user.getActivity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,user_name,spend_time,activities FROM users WHERE id =?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String userName = rs.getString("user_name");
                double spendTime = rs.getDouble("spend_time");
                String activities = rs.getString("activities");
                user = new User(id, userName, spendTime, activities);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("user_name");
                double spendTime = rs.getDouble("spend_time");
                String activities = rs.getString("activities");
                users.add(new User(id, userName, spendTime, activities));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public List<User> selectActivityAnna() {
        List<User> userAnnaList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_name='Anna Zanko'")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userAnna = resultSet.getString("user_name");
                double spendTime = resultSet.getDouble("spend_time");
                String activity = resultSet.getString("activities");
                Timestamp timestamp = resultSet.getTimestamp("time_to_add");
                userAnnaList.add(new User(id, userAnna, spendTime, activity, timestamp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAnnaList;
    }

    public List<User> selectActivityViktor() {
        List<User> userViktorList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_name='Viktor Sazhin'")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userAnna = resultSet.getString("user_name");
                double spendTime = resultSet.getDouble("spend_time");
                String activity = resultSet.getString("activities");
                Timestamp timestamp = resultSet.getTimestamp("time_to_add");
                userViktorList.add(new User(id, userAnna, spendTime, activity, timestamp));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userViktorList;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE users SET user_name = ?, spend_time = ?, activities = ? WHERE id = ?;")) {
            statement.setString(1, user.getUserName());
            statement.setDouble(2, user.getTimeToSpend());
            statement.setString(3, user.getActivity());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}