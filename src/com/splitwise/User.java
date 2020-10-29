package com.splitwise;

import com.splitwise.expense.Expense;

import java.util.List;

public class User extends DBObject{

    private String name;
    private String email;
    private String phoneNumber;
    private double totalBalance;
    private List<Expense> expenseList;

    public User(String name, String email, String phoneNumber, double totalBalance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.totalBalance = totalBalance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addExpense(Expense expense){
        expenseList.add(expense);
    }


}
