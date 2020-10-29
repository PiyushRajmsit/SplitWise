package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.PercentSplit;
import com.splitwise.split.Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualExpense extends Expense{

    public EqualExpense(long totalAmount,User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        super(totalAmount, ExpenseType.EQUAL, paidBy, createdBy, splitList);
    }


    @Override
    protected void validateExpense(List<Split> splitList) throws IllegalSplitException {
        Double totalAmount = Double.valueOf(getTotalAmount());
        Double currentAmount  = 0.0;
        for(Split s: splitList){
            currentAmount += s.getShare();
        }


    }

    @Override
    protected void validateSplit(List<Split> splitList) throws IllegalSplitException {
        for(Split s: splitList){
            if(!(s instanceof EqualSplit)){
                throw new IllegalSplitException("Wrong Split! Must be Equal");
            }
        }
    }

//    @Override
//    Expense getExpenseAccount(long totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
//
//        validateSplit(splitList);
//        validateExpense(splitList);
//        EqualExpense e = new EqualExpense(totalAmount, paidBy, createdBy, splitList);
//        return e;
//    }


}
