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
        System.out.println("New User has been Successfully Added ->" + user.toString());
    }
    public User getUser(Long id) throws IllegalUserId {
        if(!usersList.containsKey(id)) {
            throw new IllegalUserId("Incorrect User Id");
        }
        return usersList.get(id);
    }

    public void printAllUsers(){
        System.out.println("Displaying All User with Non-Zero Balance");
        for(Map.Entry<Long,User> users : usersList.entrySet()){
            if(users.getValue().getTotalBalance() > 0 ){
                System.out.println(users.getValue().toString());
            }
        }
    }

    public void displayUserData(Long userId) throws IllegalUserId{
        if(!usersList.containsKey(userId)){
            throw new IllegalUserId("Users Doesnt Exist");
        }
        System.out.println(usersList.get(userId).toString());
    }
}
