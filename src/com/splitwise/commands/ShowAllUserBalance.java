package com.splitwise.commands;

import com.splitwise.BookKeeper;
import com.splitwise.exception.BadCommandException;

public class ShowAllUserBalance implements Command {
    private static ShowAllUserBalance showAllUserBalanceInstance;
    BookKeeper bookKeeper;
    private ShowAllUserBalance() {
        bookKeeper = BookKeeper.getInstance();
    }

    public static synchronized ShowAllUserBalance getInstance() {
        if (showAllUserBalanceInstance == null) {
            showAllUserBalanceInstance = new ShowAllUserBalance();
        }
        return showAllUserBalanceInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {
        bookKeeper.printAllUsers();
    }
}
