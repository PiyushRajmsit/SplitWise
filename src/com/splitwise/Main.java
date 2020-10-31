package com.splitwise;

import com.splitwise.commands.CommandFactory;
import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.expense.EqualExpense;
import com.splitwise.expense.ExactExpense;
import com.splitwise.expense.Expense;
import com.splitwise.split.EqualSplit;
import com.splitwise.split.ExactSplit;
import com.splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalSplitException {
	// write your code here


        BookKeeper bookKeeper = BookKeeper.getInstance();
        User u1 = new User("mickey","mickey@mickey.com","111");
        User u2 = new User("mini","mini@mini.com","222");
        User u3 = new User("pluto","pluto@pluto.com","333");

        bookKeeper.addUser(u1);
        bookKeeper.addUser(u2);
        bookKeeper.addUser(u3);

        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(u3.toString());


        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String[] cmd = sc.nextLine().split(" ");
            try {
                CommandFactory.getInstance().executeCommand(cmd);
            } catch (BadCommandException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }

//        List<Split> s = new ArrayList<>();
//        s.add( new EqualSplit(u1,50));
//        s.add( new EqualSplit(u2,50));
//        Expense e = new EqualExpense(100.0,u1,u2,s);
//        System.out.println(e.toString());
//        u1.addExpense(e);
//        u1.addBalance(50.0);
//        u2.addExpense(e);
//        u2.addBalance(50.0);
//        System.out.println(u1.toString());
//        System.out.println(u2.toString());
//
//        List<Split> s1 = new ArrayList<>();
//
//        s1.add(new ExactSplit(u1,99.98));
//        s1.add(new ExactSplit(u2,10.01));
//        s1.add(new ExactSplit(u3,90.01));
//        Expense e2 = new ExactExpense(200.0,u2,u2,s1);
//        u1.addBalance(100);
//        u1.addExpense(e2);
//        u2.addBalance(10);
//        u2.addExpense(e2);
//        u3.addExpense(e2);
//        u3.addBalance(90);
//
//        System.out.println(u1.toString());
//        System.out.println(u2.toString());
    }






}
