package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;

public class AddUserCommand implements Command {


    private static AddUserCommand addUserCommandInstance;

    private AddUserCommand() {
    }

    public static synchronized AddUserCommand getInstance() {
        if (addUserCommandInstance == null) {
            addUserCommandInstance = new AddUserCommand();
        }
        return addUserCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {

    }
}
