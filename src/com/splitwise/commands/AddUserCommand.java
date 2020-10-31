package com.splitwise.commands;

import com.splitwise.BookKeeper;
import com.splitwise.User;
import com.splitwise.exception.BadCommandException;

public class AddUserCommand implements Command {


    private static AddUserCommand addUserCommandInstance;
    BookKeeper bookKeeper;
    private AddUserCommand() {
        bookKeeper = BookKeeper.getInstance();
    }

    public static synchronized AddUserCommand getInstance() {
        if (addUserCommandInstance == null) {
            addUserCommandInstance = new AddUserCommand();
        }
        return addUserCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {
        if(cmd.length != 4)
        {
            throw new BadCommandException("Incorrect User Command");
        }
        User newUser = new User(cmd[1],cmd[2],cmd[3]);
        bookKeeper.addUser(newUser);
    }
}
