package entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Builder
@ToString
public class User {
    private int id;
    private String userName;
    private double timeToSpend;
    private String activity;


    public User(String userName, double spendTime, String activities) {
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;

    }

    public User(int id, String userName, double spendTime, String activities) {
        this.id = id;
        this.userName = userName;
        this.timeToSpend = spendTime;
        this.activity = activities;
    }
}