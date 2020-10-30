package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;

public class ShowUserInfoCommand implements Command {


    private static ShowUserInfoCommand showUserInfoCommandInstance;

    private ShowUserInfoCommand() {
    }

    public static synchronized ShowUserInfoCommand getInstance() {
        if (showUserInfoCommandInstance == null) {
            showUserInfoCommandInstance = new ShowUserInfoCommand();
        }
        return showUserInfoCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {

    }
}
