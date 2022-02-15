package entity;

import java.sql.Timestamp;

public class User {
    private int id;
    private String userName;
    private double timeToSpend;
    private String activity;
    private Timestamp timeToAdd;

    public User(int id, String userName, double timeToSpend, String activity, Timestamp timeToAdd) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = timeToSpend;
        this.activity = activity;
        this.timeToAdd = timeToAdd;
    }

    public User() {
    }

    public User(int id, String userName, double timeToSpend, String activity) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = timeToSpend;
        this.activity = activity;
    }

    public User(String userName, double spendTime, String activities) {
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
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

    public Timestamp getTimeToAdd() {
        return timeToAdd;
    }

    public void setTimeToAdd(Timestamp timeToAdd) {
        this.timeToAdd = timeToAdd;
    }

    public double getTimeToSpend() {
        return timeToSpend;
    }

    public void setTimeToSpend(double timeToSpend) {
        this.timeToSpend = timeToSpend;
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
                ", timeToAdd=" + timeToAdd +
                ", timeToSpend=" + timeToSpend +
                ", activity='" + activity + '\'' +
                '}';
    }
}