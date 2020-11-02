package com.splitwise.split;
import com.splitwise.User;

public class PercentSplit extends Split {


    private double percent;

    public PercentSplit(User user, double amount, double percent) {
        super(SplitType.PERCENT, user, amount);
        this.percent = percent;
    }

    @Override
    public double getShare() {
        return getPercent();
    }

    public double getPercent() {
        return percent;
    }
}
