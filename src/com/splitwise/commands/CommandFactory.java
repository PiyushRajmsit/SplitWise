package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements Command{

    private Map<String,Command> commandMap;
    private static CommandFactory commandFactoryInstance;
    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("Add_User", AddUserCommand.getInstance());
        commandMap.put("Add_Expense", AddExpenseCommand.getInstance());
        commandMap.put("Show_User_Data", ShowUserInfoCommand.getInstance());
        commandMap.put("Show_All_User_Balance", ShowAllUserBalance.getInstance());
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static synchronized CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }


    @Override
    public void executeCommand(String[] cmd) throws BadCommandException {
        if(!commandMap.containsKey(cmd[0])) {
            throw new BadCommandException("InCorrect/Illegal Command ->" + cmd[0]);
        }
        getCommandMap().get(cmd[0]).executeCommand(cmd);

    }


}
