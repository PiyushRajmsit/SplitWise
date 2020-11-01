package com.splitwise.split;

import com.splitwise.DBObject;
import com.splitwise.User;

public abstract class Split extends DBObject{

    final private SplitType splitType;
    private User user;
    private double amount;

    public Split(SplitType splitType, User user, double amount) {
        this.splitType = splitType;
        this.user = user;
        this.amount = amount;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    abstract public double getShare();

    @Override
    public String toString() {
        return "Split{" +
                "id=" + getuId() +
                ", splitType=" + splitType +
                ", user=" + user.getName() +
                ", amount=" + amount +
                '}';
    }
}
