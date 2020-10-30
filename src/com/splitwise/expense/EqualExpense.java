package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(Double totalAmount, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        super(totalAmount, ExpenseType.EQUAL, paidBy, createdBy, splitList);
    }


    @Override
    protected void validateExpense(List<Split> splitList) throws IllegalSplitException {
        Double totalAmount = getTotalAmount();
        Double currentAmount = 0.0;
        for(Split s: splitList){
            double share = Utils.roundOff(s.getShare());
            s.setAmount(share);
            currentAmount += share;
        }
        if(!Utils.isApproxEqual(currentAmount,totalAmount)){
            double remaining = totalAmount - currentAmount;
            splitList.get(0).setAmount(splitList.get(0).getAmount() + remaining);
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
