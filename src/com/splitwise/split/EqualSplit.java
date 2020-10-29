package com.splitwise.split;

import com.splitwise.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, double share) {
        super(SplitType.EQUAL, user, share);
    }
}
