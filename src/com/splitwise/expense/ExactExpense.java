package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.ExactSplit;
import com.splitwise.split.Split;

import java.util.List;

public class ExactExpense extends Expense {


    public ExactExpense(Double totalAmount, User paidBy, User createdBy, List<Split> splitList, String expenseName) throws IllegalSplitException {
        super(totalAmount, ExpenseType.EXACT, paidBy, createdBy, splitList, expenseName);
    }
    @Override
    void validateExpense(List<Split> splitList) throws IllegalSplitException {

        double totalAmount = getTotalAmount();
        double currentAmount = 0.0;
        for(Split s: splitList ){
            currentAmount += s.getShare();
        }
        if(!Utils.isApproxEqual(currentAmount,totalAmount)){
            throw  new IllegalSplitException("Incorrect Amount for Exact Split ->" + currentAmount);
        }
    }

    @Override
    void validateSplit(List<Split> splitList) throws IllegalSplitException {
        for(Split s: splitList){
            if(!(s instanceof ExactSplit)){
                throw new IllegalSplitException("Wrong Split! Must be Exact");
            }
        }
    }
}
