package com.splitwise.commands;

import com.splitwise.BookKeeper;
import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalUserId;

public class ShowUserInfoCommand implements ICommand {


    private static ShowUserInfoCommand showUserInfoCommandInstance;
    BookKeeper bookKeeper;
    private ShowUserInfoCommand() {
        bookKeeper = BookKeeper.getInstance();
    }

    public static synchronized ShowUserInfoCommand getInstance() {
        if (showUserInfoCommandInstance == null) {
            showUserInfoCommandInstance = new ShowUserInfoCommand();
        }
        return showUserInfoCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {

        if(cmd.length != 2){
            throw new BadCommandException("Incorrect Add User Command");
        }
        Long userId = Long.valueOf(cmd[1]);
        try {
            bookKeeper.displayUserData(userId);
        } catch (IllegalUserId illegalUserId) {
            illegalUserId.printStackTrace();
        }
    }
}
