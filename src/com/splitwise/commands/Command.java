package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;

public interface Command {

    public void executeCommand(String cmd[]) throws BadCommandException;
}
