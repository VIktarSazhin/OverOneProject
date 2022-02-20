package entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Builder
@ToString
public class User {
    private int id;
    private String userName;
    private double timeToSpend;
    private String activity;
    private Timestamp timeToAdd;

    public User(String userName, double spendTime, String activities) {
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;

    }

    public User(int id, String userName, double spendTime, String activities, Timestamp timeToAdd) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
        this.timeToAdd = timeToAdd;
    }

    public User(int id, String userName, double spendTime, String activities) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
    }

    public User(String userAnna, double spendTime, String activities, Timestamp timestamp) {
        this.userName = userAnna;
        this.timeToSpend = spendTime;
        this.activity = activities;
        this.timeToAdd = timestamp;
    }

    public User(double spendTime, String activities) {
        this.timeToSpend = spendTime;
        this.activity = activities;
    }
}