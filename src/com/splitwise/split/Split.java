package com.splitwise.split;

import com.splitwise.DBObject;
import com.splitwise.User;

public abstract class Split extends DBObject{

    final private SplitType splitType;
    private User user;
    private double share;

    public Split(SplitType splitType, User user, double share) {
        this.splitType = splitType;
        this.user = user;
        this.share = share;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public User getUser() {
        return user;
    }

    public double getShare() {
        return share;
    }


}
