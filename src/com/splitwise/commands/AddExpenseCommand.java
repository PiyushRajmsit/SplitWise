package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;

public class AddExpenseCommand implements Command {


    private static AddExpenseCommand addExpenseCommandInstance;

    private AddExpenseCommand() {
    }

    public static synchronized AddExpenseCommand getInstance() {
        if (addExpenseCommandInstance == null) {
            addExpenseCommandInstance = new AddExpenseCommand();
        }
        return addExpenseCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {

    }
}
