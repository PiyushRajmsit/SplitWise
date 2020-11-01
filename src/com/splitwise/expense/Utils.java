package com.splitwise.expense;


import com.splitwise.exception.IllegalExpenseType;

public class Utils {

    public static double getAmountFromPercent(double totalAmount,double percent) {
        double amount = (totalAmount * percent)/100.0d;
        return amount;
    }

    public static double roundOff(double value) {
        return ((long) (value * 100)) / 100.0d; // round off up to two decimal
    }

    public static boolean isApproxEqual(double v1, double v2) {
        return (Math.abs(v1 - v2) / (Math.min(Math.abs(v1), Math.abs(v2)))) < 1e-10; // relative error
    }

    public static ExpenseType expenseTypeFromString(String expType) throws IllegalExpenseType {
        if(expType.toLowerCase().equals("equal")){
            return ExpenseType.EQUAL;
        }
        else if(expType.toLowerCase().equals("exact")){
            return ExpenseType.EXACT;
        }
        return ExpenseType.PERCENT;
    }
}
