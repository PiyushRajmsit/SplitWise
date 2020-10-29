package com.splitwise;

public abstract class DBObject {


    private static long NEW_UID = 0;
    private final long uId;

    protected DBObject() {
        uId = ++NEW_UID;
    }

    public long getuId() {
        return uId;
    }
}
