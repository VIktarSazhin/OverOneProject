package entity;


import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private int id;
    private String userName;
    private Timestamp time;
    private String activity;

    public User(int id, String userName, Timestamp time, String activity) {
        this.id = id;
        this.userName = userName;
        this.time = time;
        this.activity = activity;
    }

    public User(int id, String userName, String activity) {
        this.userName = userName;
        this.activity = activity;
    }

    public User(String userName, String activity) {
        this.userName = userName;
        this.activity = activity;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", time=" + time +
                ", activity='" + activity + '\'' +
                '}';
    }
}