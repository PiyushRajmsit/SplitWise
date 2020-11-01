# SplitWise Problem

### Description
Create an expense sharing application.

An expense sharing application is where you can add your expenses and split it among different people. 
The app keeps balances between people as in who owes how much to whom.

### Functional Requirements

* User: Each user should have a userId, name, email, mobile number.

* Expense: Could either be EQUAL, EXACT or PERCENT

* Users can add any amount, select any type of expense and split with any of the available users.

* The percent and amount provided could have decimals upto two decimal places.

* In case of percent, you need to verify if the total sum of percentage shares is 100 or not.

* In case of exact, you need to verify if the total sum of shares is equal to the total amount or not.

* The application should have a capability to show expenses for a single user as well as balances for everyone.

* When asked to show balances, the application should show balances of a user with all the users where there is a non-zero balance.

* The amount should be rounded off to two decimal places. Say if User1 paid 100 and amount is split equally among 3 people. Assign 33.34 to first person and 33.33 to others.


### Queries
1) Add User: 
* (Input Format): Add_User [Name] [Email] [PhoneNumber]

2) Add Equal Expense to User Account:
*  (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Equal [User 1 Id] [User 2 Id] ........[User totalUsers Id]

3) Add Exact Expense to User Account:
*  (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Exact [User 1 Id] [User 2 Id] ........[User totalUsers Id] [Amount Paid by User 1] [Amount Paid by User 2] ......

4) Add Percent Expense to User Account:
* (Input Format) : Add_Expense [ExpenseName] [totalAmount] [paidBy UserId] [createdBy UserId] [totalUsers] Percent [User 1 Id] [User 2 Id] ........[User totalUsers Id] [Percent Share by User 1] [Percent Share by User 2] ..... 

5) Show User Data:
* (Input Format) : Show_User_Data [UserId]

6) Show All User Data with Positive Due Balance:
* (Input Format) : Show_All_User_Balance

7) Show_User_Expense By A User
* (Input Format) : Show_User_Expense [UserId]


### Sample Test Case

* Add_User goofie goofie@goofie.com 444
* Add_Expense Food 200 1 1 3 Equal 1 2 3
* Add_Expense Cable 100 1 1 3 Exact 1 2 3 40 50 10
* Add_Expense Hotels 400 4 4 3 Percent 2 3 4 30 50 20
* Show_All_User_Balance
* Show_User_Data 2
* Show_User_Expense 1

