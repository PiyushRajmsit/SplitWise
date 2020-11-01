package com.splitwise.commands;

import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalExpenseType;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.exception.IllegalUserId;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand {

    private Map<String, ICommand> commandMap;
    private static CommandFactory commandFactoryInstance;
    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("Add_User", AddUserCommand.getInstance());
        commandMap.put("Add_Expense", AddExpenseCommand.getInstance());
        commandMap.put("Show_User_Data", ShowUserInfoCommand.getInstance());
        commandMap.put("Show_All_User_Balance", ShowAllUserBalance.getInstance());
        commandMap.put("Show_User_Expense", ShowUserExpense.getInstance());
    }

    public Map<String, ICommand> getCommandMap() {
        return commandMap;
    }

    public static synchronized CommandFactory getInstance() {
        if (commandFactoryInstance == null) {
            commandFactoryInstance = new CommandFactory();
        }
        return commandFactoryInstance;
    }


    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, IllegalUserId, IllegalExpenseType, IllegalSplitException {
        if(!commandMap.containsKey(cmd[0])) {
            throw new BadCommandException("InCorrect/Illegal Command ->" + cmd[0]);
        }
        getCommandMap().get(cmd[0]).executeCommand(cmd);

    }


}
