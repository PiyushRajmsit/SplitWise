package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.ExactSplit;
import com.splitwise.split.PercentSplit;
import com.splitwise.split.Split;

import java.util.List;
import java.util.Map;

public class ExactExpense extends Expense {


    public ExactExpense(long totalAmount,User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        super(totalAmount, ExpenseType.EXACT, paidBy, createdBy, splitList);
    }
    @Override
    void validateExpense(List<Split> splitList) throws IllegalSplitException {

    }

    @Override
    void validateSplit(List<Split> splitList) throws IllegalSplitException {
        for(Split s: splitList){
            if(!(s instanceof ExactSplit)){
                throw new IllegalSplitException("Wrong Split! Must be Exact");
            }
        }
    }

//    @Override
//    Expense getExpenseAccount(long totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
//        validateSplit(splitList);
//        validateExpense(totalAmount,splitList);
//        ExactExpense exactExpense = new ExactExpense(totalAmount, paidBy, createdBy, splitList);
//        return exactExpense;
//    }
}
