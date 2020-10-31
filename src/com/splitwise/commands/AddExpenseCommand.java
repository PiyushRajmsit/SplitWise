package com.splitwise.commands;

import com.splitwise.BookKeeper;
import com.splitwise.User;
import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalExpenseType;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.exception.IllegalUserId;
import com.splitwise.expense.*;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.ExactSplit;
import com.splitwise.split.PercentSplit;
import com.splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;

public class AddExpenseCommand implements Command {


    private static AddExpenseCommand addExpenseCommandInstance;
    BookKeeper bookKeeper;
    private AddExpenseCommand() {
        bookKeeper = BookKeeper.getInstance();
    }

    public static synchronized AddExpenseCommand getInstance() {
        if (addExpenseCommandInstance == null) {
            addExpenseCommandInstance = new AddExpenseCommand();
        }
        return addExpenseCommandInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, IllegalUserId, IllegalExpenseType, IllegalSplitException {
        String expType = cmd[1];
        Double totalAmount = Double.valueOf(cmd[2]);
        User paidBy = bookKeeper.getUser(Long.valueOf(cmd[3]));
        User createdBy = bookKeeper.getUser(Long.valueOf(cmd[4]));
        Long totalUsers = Long.valueOf(cmd[5]);
        List<Split> splitList = new ArrayList<>();
        ExpenseType expenseType = Utils.expenseTypeFromString(cmd[6]);

        if(expenseType == ExpenseType.EQUAL){
            Double getEachShare = totalAmount/totalUsers;
            for(int userCount = 0;userCount < totalUsers ; userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                splitList.add(new EqualSplit(user,getEachShare));
            }
            Expense newExpenseCreated = new EqualExpense(totalAmount,paidBy,createdBy,splitList);
            for(int userCount = 0;userCount < totalUsers ; userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                user.addExpense(newExpenseCreated);
                user.addBalance(getEachShare);
            }

        }
        else if(expenseType == ExpenseType.EXACT){
            for(int userCount = 0;userCount < totalUsers ; userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                Double getUserShare = Double.valueOf(cmd[Math.toIntExact(7 + totalUsers + userCount)]);
                splitList.add(new ExactSplit(user,getUserShare));
            }
            Expense newExpenseCreated = new ExactExpense(totalAmount,paidBy,createdBy,splitList);
            for(int userCount = 0;userCount < totalUsers ; userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                user.addBalance(splitList.get(userCount).getAmount());
            }
        }
        else if(expenseType == ExpenseType.PERCENT){
            for(int userCount = 0;userCount < totalUsers;userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                Double getPercent = Double.valueOf(cmd[Math.toIntExact(7 + totalUsers + userCount)]);
                Double userShare = Utils.getAmountFromPercent(totalAmount,getPercent);
                splitList.add(new PercentSplit(user,userShare,getPercent));
            }
            Expense newExpenseCreated = new PercentExpense(totalAmount,paidBy,createdBy,splitList);
            for(int userCount = 0;userCount < totalUsers ; userCount++){
                Long userId = Long.valueOf(cmd[7+userCount]);
                User user = bookKeeper.getUser(userId);
                user.addBalance(splitList.get(userCount).getAmount());
            }

        }
        System.out.println("Expense Successfully Added");

    }
}
