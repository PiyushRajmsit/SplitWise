package com.splitwise.split;

import com.splitwise.User;

public class PercentSplit extends Split {

    private double amount;
    public PercentSplit(User user, double share) {
        super(SplitType.PERCENT, user, share);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
