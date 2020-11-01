package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalExpenseType;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.exception.IllegalUserId;

public interface ICommand {
    public void executeCommand(String cmd[]) throws BadCommandException, IllegalUserId, IllegalExpenseType, IllegalSplitException;
}
