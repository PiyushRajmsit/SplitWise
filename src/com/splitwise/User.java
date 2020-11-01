package com.splitwise;

import com.splitwise.expense.Expense;
import com.splitwise.expense.Utils;

import java.util.ArrayList;
import java.util.List;

public class User extends DBObject{

    private String name;
    private String email;
    private String phoneNumber;
    private double totalBalance;
    private List<Expense> expenseList;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.totalBalance = 0;
        expenseList = new ArrayList<>();
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

    public void addBalance(double balance){
        this.totalBalance = Utils.roundOff(this.totalBalance + balance);
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + getuId()+ '\''+
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", totalBalance=" + totalBalance +
                '}';
    }

    public String showUserExpense(){
        return expenseList.toString();
    }
}
