package com.splitwise;

import com.splitwise.exception.IllegalUserId;

import java.util.HashMap;
import java.util.Map;

public class BookKeeper {

    private Map<Long,User> usersList;
    private static BookKeeper bookKeeperInstance;

    private BookKeeper() {
        usersList = new HashMap<>();
    }

    public static synchronized BookKeeper getInstance() {
        if (bookKeeperInstance == null) {
            bookKeeperInstance = new BookKeeper();
        }
        return bookKeeperInstance;
    }

    public void addUser(User user){
        usersList.put(user.getuId(),user);
    }
    public User getUser(Long id) throws IllegalUserId {
        if(usersList.containsKey(id)) {
            throw new IllegalUserId("Incorrect User Id");
        }
        return usersList.get(id);
    }






}
