package com.splitwise.split;

import com.splitwise.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, double amount) {
        super(SplitType.EQUAL, user, amount);
    }

    @Override
    public double getShare() {
        return getAmount();
    }





}

