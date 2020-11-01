package com.splitwise.expense;

import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(Double totalAmount, User paidBy, User createdBy, List<Split> splitList, String expenseName) throws IllegalSplitException {
        super(totalAmount, ExpenseType.EQUAL, paidBy, createdBy, splitList, expenseName);
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
            for(Split s: splitList){
                if(s.getUser().getuId() == this.getPaidBy().getuId()){
                    s.setAmount(Utils.roundOff(s.getAmount()+remaining));
                }
            }
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

}
