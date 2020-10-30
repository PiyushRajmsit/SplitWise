package com.splitwise;

public class Utils {
    public static double getAmountFromPercent(double totalAmount,double percent) {
        double amount = (totalAmount * percent)/100.0d;
        return amount;
    }
    public static double getEqualShare(double totalAmount, long userCount){
        double share = totalAmount/totalAmount;
        share = share*100.0d/100.0d;
        return share;
    }
}
