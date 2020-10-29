package com.splitwise.split;

import com.splitwise.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double share) {
        super(SplitType.EXACT, user, share);
    }
}
