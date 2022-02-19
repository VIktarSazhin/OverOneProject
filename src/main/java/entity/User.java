package entity;

import lombok.*;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private int id;
    private String userName;
    private double timeToSpend;
    private String activity;
    private Timestamp timeToAdd;


    public User(int id, String userName, double spendTime, String activities) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
    }

    public User(String userName, double spendTime, String activities) {
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
    }
}