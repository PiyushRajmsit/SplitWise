package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.PercentSplit;
import com.splitwise.split.Split;

import java.util.List;
import java.util.Map;

public class PercentExpense extends Expense{

    public PercentExpense(long totalAmount, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        super(totalAmount, ExpenseType.PERCENT, paidBy, createdBy, splitList);
    }

    @Override
    void validateExpense(List<Split> splitList) throws IllegalSplitException {


    }

    @Override
    void validateSplit(List<Split> splitList) throws IllegalSplitException {
        for(Split s: splitList){
            if(!(s instanceof PercentSplit)){
                throw new IllegalSplitException("Wrong Split! Must be Percent");
            }
        }

    }
//
//    @Override
//    Expense getExpenseAccount(long totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
//        validateSplit(splitList);
//        validateExpense(splitList);
//        PercentExpense percentExpense = new PercentExpense(totalAmount, paidBy, createdBy, splitList);
//        return percentExpense;
//    }
}
