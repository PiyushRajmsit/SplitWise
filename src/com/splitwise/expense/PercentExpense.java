package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.PercentSplit;
import com.splitwise.split.Split;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(Double totalAmount, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        super(totalAmount, ExpenseType.PERCENT, paidBy, createdBy, splitList);
    }

    @Override
    void validateExpense(List<Split> splitList) throws IllegalSplitException {
        double totalPercent = 0;
        for(Split s: splitList){
            totalPercent = totalPercent + s.getShare();
        }
        if(!Utils.isApproxEqual(totalPercent , 100.0)){
            throw new IllegalSplitException("Incorrect Percentage Split" + totalPercent);
        }

    }

    @Override
    void validateSplit(List<Split> splitList) throws IllegalSplitException {
        for(Split s: splitList){
            if(!(s instanceof PercentSplit)){
                throw new IllegalSplitException("Wrong Split! Must be Percent");
            }
        }

    }
}
