package com.splitwise.expense;

import com.splitwise.DBObject;
import com.splitwise.User;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.split.Split;

import java.util.List;

public abstract class Expense extends DBObject {

    private Double totalAmount;
    final private ExpenseType expenseType;
    private User paidBy;
    private User createdBy;
    private List<Split> splitList;

    public Expense(Double totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException {
        this.setTotalAmount(totalAmount);
        this.expenseType = expenseType;
        this.setPaidBy(paidBy);
        this.setCreatedBy(createdBy);
        this.setSplitList(splitList);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    private void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    private void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    private void setSplitList(List<Split> splitList) throws IllegalSplitException {
        validateSplit(splitList);
        validateExpense(splitList);
        this.splitList = splitList;
    }

    abstract void validateExpense(List<Split> splitList) throws IllegalSplitException;
    abstract void validateSplit(List<Split> splitList) throws IllegalSplitException;
//    abstract Expense getExpenseAccount(long totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList) throws IllegalSplitException;


    @Override
    public String toString() {
        return "Expense{" +
                "id=" + getuId() +
                ", totalAmount=" + totalAmount +
                ", expenseType=" + expenseType +
                ", paidBy=" + paidBy +
                ", createdBy=" + createdBy +
                '}';
    }
}
