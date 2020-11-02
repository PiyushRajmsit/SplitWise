package com.splitwise;

import com.splitwise.commands.CommandFactory;
import com.splitwise.exception.BadCommandException;
import com.splitwise.exception.IllegalExpenseType;
import com.splitwise.exception.IllegalSplitException;
import com.splitwise.exception.IllegalUserId;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalSplitException, IllegalUserId, IllegalExpenseType {
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

    }

}
// Command Test

// Add_User goofie goofie@goofie.com 444
// Add_Expense Food 200 1 1 3 Equal 1 2 3
// Show_All_User_Balance
// Show_User_Data 2
// Show_User_Expense 1
// Add_Expense Cable 100 1 1 3 Exact 1 2 3 40 50 10
// Add_Expense Travel 100 1 1 3 Exact 1 2 3 40 20 10
// Add_Expense Hotels 400 4 4 3 Percent 2 3 4 30 50 20