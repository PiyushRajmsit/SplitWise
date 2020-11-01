package com.splitwise.commands;

import com.splitwise.BookKeeper;
import com.splitwise.User;
import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalExpenseType;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.exception.IllegalUserId;

public class ShowUserExpense implements ICommand {

    private static ShowUserExpense showUserExpenseInstance;
    BookKeeper bookKeeper;
    private ShowUserExpense() {
        bookKeeper = BookKeeper.getInstance();
    }

    public static synchronized ShowUserExpense getInstance() {
        if (showUserExpenseInstance == null) {
            showUserExpenseInstance = new ShowUserExpense();
        }
        return showUserExpenseInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, IllegalUserId, IllegalExpenseType, IllegalSplitException {
        if(cmd.length != 2){
            throw new BadCommandException("Bad Command Exception");
        }
        Long userId = Long.valueOf(cmd[1]);
        User user = bookKeeper.getUser(userId);
        System.out.println(user.showUserExpense());
    }
}
