package src.ProjectExcel;

import src.ProjectExcel.Users;

import java.util.ArrayList;
import java.util.Scanner;

public class Transactions extends Users {
    ArrayList<String> accounts=new ArrayList<> ();
    ArrayList<String> transactmessages=new ArrayList<> ();
    ArrayList<String> transaccounts=new ArrayList<> ();

    public void login() {
        Scanner input = new Scanner (System.in);

        int pass = -1;
        String name = "generic";
        for (int i = 0; i < 3; i++) {
            System.out.println ("Please provide your user ID ");
            String login = input.next ();
            for (int j = 0; j < IDs.size (); j++) {
                if (login.equalsIgnoreCase (IDs.get (j))) {
                    pass = j;
                    break;
                }
            }
            if (pass == -1) {
                System.out.println ("Wrong User ID");
            } else if (passwords.get(pass).equalsIgnoreCase ("locked")){
                break;
            }
            else {
                for (int k = 0; k < 3; k++) {
                    System.out.println ("Please provide your password");
                    String password = input.next ();
                    if (password.equals (passwords.get (pass))) {
                        name = names.get (pass);
                        System.out.println ("Welcome to your account " + names.get (pass));
                        System.out.println ("How we can help you today?");
                        ArrayList<String> accounts=new ArrayList<> ();
                        for (int l=0; l<acctnumbers.size (); l++){
                            if ( AcctNames.get (l).equalsIgnoreCase (name)){
                                accounts.add (acctnumbers.get (l));
                            }
                        }
                        Transactions (accounts);
                        break;
                    } else
                        System.out.println ("Wrong Password. Try again");

                }
                break;
            }

        }
        if (name.equalsIgnoreCase ("generic") && pass!=-1) {
            String namedef=names.get(pass);
            passwords.set (pass,"locked");
            System.out.println ("Your account is locked");
        }
        accounts.clear ();
        transactmessages.clear ();
        transaccounts.clear ();
        System.out.println ("Have a good day!!!");
        System.out.println ("Welcome to our ATM Machine!");

    }


    public void Transactions(ArrayList accounts){
        Scanner input = new Scanner (System.in);
        System.out.println ("Please choose from the following options:" );
        System.out.println ("1.Deposit, 2.Withdraw, 3.Transfer, 4.Transaction history, 5.Quit");
        System.out.println ("Please press number from 1 to 5");
        String transaction=input.next ();
        switch (transaction){
            case "1":
                deposit (accounts);
                Transactions (accounts);
                break;
            case "2":
                withdraw (accounts);
                Transactions (accounts);
                break;
            case "3":
                transfer(accounts);
                Transactions (accounts);
                break;
            case "4":
                transactionHistory (accounts,transaccounts,transactmessages);
                Transactions (accounts);
                break;
            case "5":
                quit (accounts);
                break;
            default:
                System.out.println ("Wrong command");
                Transactions (accounts);
                break;
            }
    }

    public void deposit (ArrayList accounts) {   // Fatema
        Scanner input = new Scanner (System.in);
        if (accounts.size () == 1) {
            System.out.println ("You have only one available account");
        } else
            System.out.println ("You have " + accounts.size () + " available accounts");
        for (int i = 0; i < accounts.size (); i++) {
            System.out.println ("Account number: " + accounts.get (i) + " Account type: " + accttypes.get (acctnumbers.indexOf (accounts.get (i))));
        }
        System.out.println ("Please enter the account number:");
        String account = input.next ();
        if (accounts.contains (account)) {
            int number = acctnumbers.indexOf (account);
            double balance = balances.get (number);
            System.out.println ("Do you want to deposit: check or cash");
            System.out.println ("Press 1 for cash and 2 for check");
            String type = input.next ();
            switch (type) {
                case "1":
                    System.out.println ("Please enter how much you want to deposit");
                    int amount = -50;
                    try {
                        amount = input.nextInt ();
                    } catch (java.util.InputMismatchException a) {
                        amount = -50;
                    }
                    if (amount > 0) {
                        balance = balances.get (number) + amount;
                        balances.set (number, balance);
                        message = "You deposited: " + amount + "$ in cash to this account";
                        transactmessages.add (message);
                        transaccounts.add (account);
                        System.out.println (message);
                    } else {
                        System.out.println ("Wrong amount to deposit");
                        deposit (accounts);
                    }
                    break;
                case "2":
                    System.out.println ("Please enter your check number");
                    String checkNumber = input.next ();
                    System.out.println ("Please enter how much you want to deposit");
                    int amount2 = -50;
                    try {
                        amount2 = input.nextInt ();
                    } catch (java.util.InputMismatchException a) {
                        amount2 = -50;
                    }
                    if (amount2 > 0) {
                        balance = balances.get (number) + amount2;
                        balances.set (number, balance);
                        message = "You deposited: " + amount2 + "$ in check ( check # " + checkNumber + " ) to this account";
                        transactmessages.add (message);
                        transaccounts.add (account);
                        System.out.println (message);
                    } else {
                        System.out.println ("Wrong amount to deposit");
                        deposit (accounts);
                    }
                    break;
                default:
                    System.out.println ("Wrong input");
                    deposit (accounts);
            }
        } else {
            System.out.println ("Wrong account");
            deposit (accounts);
        }
    }


    public void quit(ArrayList accounts){   // Mahadi
        Scanner input = new Scanner (System.in);
        System.out.println ("Do you want to print transaction history?");
        System.out.println ("Press 1 for Yes or 2 for No");
        String option = input.next ();
        switch (option){
            case "1":
                transactionHistory (accounts,transaccounts,transactmessages);
                break;
            case "2":
                System.out.println ("Thank you");
                break;
            default:
                System.out.println ("Wrong Input");
                quit (accounts);
                break;
        }
    }



    public void withdraw(ArrayList accounts) {   // Alex
        Scanner input = new Scanner (System.in);
        if (accounts.size ()==1){
            System.out.println ("You have only one available account");
        } else
            System.out.println ("You have " + accounts.size () + " available accounts");
        for (int i=0; i<accounts.size (); i++){
            System.out.println ("Account number: " + accounts.get (i) + " Account type: " + accttypes.get (acctnumbers.indexOf (accounts.get(i))) );
        }
        System.out.println ("Please enter account number ");
        String acc = input.next ();
        if (accounts.contains (acc)) {
            int num = acctnumbers.indexOf (acc);
            double balance = balances.get (num);
            String accType = accttypes.get (num);
            switch (accType) {
                case "Savings":
                    System.out.println ("Please enter the amount you want to withdraw: ");
                    int amount=-50;
                    try {
                        amount=input.nextInt ();
                    }
                    catch (java.util.InputMismatchException a) {
                        amount=-50;
                    }
                    if (amount > 0 && amount <= balance) {
                        if ( amount%5==0) {

                            int withdraw = withdraws.get (num);
                            if (withdraw < 5) {
                                balance = balances.get (num) - amount;
                                balances.set (num, balance);
                                withdraw = (withdraws.get (num));
                                withdraw++;
                                withdraws.set (num, withdraw);
                                message = "You withdraw " + amount + "$";
                                transactmessages.add (message);
                                transaccounts.add (acc);
                                System.out.println (message);
                                if (amount%100==0){
                                    System.out.println ("You will get " + amount/100 + " --- 100 $ dollar bills" );
                                } else if (amount%20==0){
                                    System.out.println ("You will get " + amount/100 + " ---- 100 $ dollar bills." );
                                    System.out.println ("You will get " + (amount %100)/ 20 + " --- 20$ dollar bills.");
                                } else if (amount%10==0){
                                    System.out.println ("You will get " + amount/100 + "  - 100 $ dollar bills." );
                                    System.out.println ("You will get " + (amount %100)/ 20 + " - 20$ dollar bills.");
                                    System.out.println ("You will get " + (amount %20)/ 10 + " - 10$ dollar bills.");
                                } else {
                                    System.out.println ("You will get " + amount / 100 + "  - 100 $ dollar bills.");
                                    System.out.println ("You will get " + (amount % 100) / 20 + " - 20$ dollar bills.");
                                    System.out.println ("You will get " + (amount % 20) / 10 + " - 10$ dollar bills.");
                                    System.out.println ("You will get " + (amount % 10) / 5 + " - 5$ dollar bills.");
                                }



                            } else if (withdraw == 5) {
                                balance = balances.get (num) - amount;
                                balances.set (num, balance);
                                withdraw = (withdraws.get (num));
                                withdraw++;
                                withdraws.set (num, withdraw);
                                System.out.println ("This is your last free withdraw");
                                message = "You withdraw " + amount + "$ ";
                                transactmessages.add (message);
                                transaccounts.add (acc);
                                System.out.println (message);
                                if (amount%100==0){
                                    System.out.println ("You will get " + amount/100 + " --- 100 $ dollar bills" );
                                } else if (amount%20==0){
                                    System.out.println ("You will get " + amount/100 + " ---- 100 $ dollar bills." );
                                    System.out.println ("You will get " + (amount %100)/ 20 + " --- 20$ dollar bills.");
                                } else if (amount%10==0){
                                    System.out.println ("You will get " + amount/100 + "  - 100 $ dollar bills." );
                                    System.out.println ("You will get " + (amount %100)/ 20 + " - 20$ dollar bills.");
                                    System.out.println ("You will get " + (amount %20)/ 10 + " - 10$ dollar bills.");
                                } else {
                                    System.out.println ("You will get " + amount / 100 + "  - 100 $ dollar bills.");
                                    System.out.println ("You will get " + (amount % 100) / 20 + " - 20$ dollar bills.");
                                    System.out.println ("You will get " + (amount % 20) / 10 + " - 10$ dollar bills.");
                                    System.out.println ("You will get " + (amount % 10) / 5 + " - 5$ dollar bills.");
                                }

                            } else {
                                System.out.println ("Your max of withdraw is six, after that you have to pay a fee for any withdraw");
                                System.out.println ("If you want to pay with the same saving account pres 1 for yes, if you want to pay with another account pres 2 for 'no'");
                                String answer = input.next ();
                                switch (answer) {
                                    case "1":
                                        int fee = 2;
                                        balance = balance - amount - fee;
                                        balances.set (num, balance);
                                        withdraw = (withdraws.get (num));
                                        withdraw++;
                                        withdraws.set (num, withdraw);
                                        message = "You withdraw " + amount + "$. And you were charged " + fee + "$ fee.";
                                        transactmessages.add (message);
                                        transaccounts.add (acc);
                                        System.out.println (message);
                                        if (amount%100==0){
                                            System.out.println ("You will get " + amount/100 + " --- 100 $ dollar bills" );
                                        } else if (amount%20==0){
                                            System.out.println ("You will get " + amount/100 + " ---- 100 $ dollar bills." );
                                            System.out.println ("You will get " + (amount %100)/ 20 + " --- 20$ dollar bills.");
                                        } else if (amount%10==0){
                                            System.out.println ("You will get " + amount/100 + "  - 100 $ dollar bills." );
                                            System.out.println ("You will get " + (amount %100)/ 20 + " - 20$ dollar bills.");
                                            System.out.println ("You will get " + (amount %20)/ 10 + " - 10$ dollar bills.");
                                        } else {
                                            System.out.println ("You will get " + amount / 100 + "  - 100 $ dollar bills.");
                                            System.out.println ("You will get " + (amount % 100) / 20 + " - 20$ dollar bills.");
                                            System.out.println ("You will get " + (amount % 20) / 10 + " - 10$ dollar bills.");
                                            System.out.println ("You will get " + (amount % 10) / 5 + " - 5$ dollar bills.");
                                        }
                                        break;
                                    case "2":
                                        withdraw2 (accounts);
                                        balance = balance - amount;
                                        balances.set (num, balance);
                                        message = "You withdraw " + amount + "$ ";
                                        transactmessages.add (message);
                                        transaccounts.add (acc);
                                        System.out.println (message);
                                        if (amount%100==0){
                                            System.out.println ("You will get " + amount/100 + " --- 100 $ dollar bills" );
                                        } else if (amount%20==0){
                                            System.out.println ("You will get " + amount/100 + " ---- 100 $ dollar bills." );
                                            System.out.println ("You will get " + (amount %100)/ 20 + " --- 20$ dollar bills.");
                                        } else if (amount%10==0){
                                            System.out.println ("You will get " + amount/100 + "  - 100 $ dollar bills." );
                                            System.out.println ("You will get " + (amount %100)/ 20 + " - 20$ dollar bills.");
                                            System.out.println ("You will get " + (amount %20)/ 10 + " - 10$ dollar bills.");
                                        } else {
                                            System.out.println ("You will get " + amount / 100 + "  - 100 $ dollar bills.");
                                            System.out.println ("You will get " + (amount % 100) / 20 + " - 20$ dollar bills.");
                                            System.out.println ("You will get " + (amount % 20) / 10 + " - 10$ dollar bills.");
                                            System.out.println ("You will get " + (amount % 10) / 5 + " - 5$ dollar bills.");
                                        }
                                        break;
                                    default:
                                        System.out.println ("Wrong Input");
                                }
                            }
                        }
                       else {
                                System.out.println (" You can only withdraw amount, that divides by 5");
                            }
                    } else if (amount > balance){
                        System.out.println ("You do not have enough money on your account. Your balance is " + balances.get (num));
                        withdraw (accounts);
                    } else {
                        System.out.println (" Wrong amount for withdraw");
                        withdraw(accounts);
                    }
                    break;
                case "Checking":
                    System.out.println ("Please enter the amount you want to withdraw: ");
                    int amount2 = -50;
                    try {
                        amount2=input.nextInt ();
                    }
                    catch (java.util.InputMismatchException a) {
                        amount2=-50;
                    }
                    if (amount2 > 0 && amount2 <= balance) {
                        if ( amount2%5==0){
                        balance = balance - amount2;
                        balances.set (num, balance);
                        message="You withdraw " + amount2 + " from account: " + acc;
                        transactmessages.add (message);
                        transaccounts.add (acc);
                        System.out.println (message);
                            if (amount2%100==0){
                                System.out.println ("You will get " + amount2/100 + " --- 100 $ dollar bills" );
                            } else if (amount2%20==0){
                                System.out.println ("You will get " + amount2/100 + " --- 100 $ dollar bills." );
                                System.out.println ("You will get " + (amount2 %100)/ 20 + " --- 20$ dollar bills.");
                            } else if (amount2%10==0){
                                System.out.println ("You will get " + amount2/100 + "  - 100 $ dollar bills." );
                                System.out.println ("You will get " + (amount2 %100)/ 20 + " - 20$ dollar bills.");
                                System.out.println ("You will get " + (amount2 %20)/ 10 + " - 10$ dollar bills.");
                            } else {
                                System.out.println ("You will get " + amount2 / 100 + "  - 100 $ dollar bills.");
                                System.out.println ("You will get " + (amount2 % 100) / 20 + " - 20$ dollar bills.");
                                System.out.println ("You will get " + (amount2 % 20) / 10 + " - 10$ dollar bills.");
                                System.out.println ("You will get " + (amount2 % 10) / 5 + " - 5$ dollar bills.");
                            }
                        } else {
                            System.out.println (" You can only withdraw amount, that divides by 5");
                            withdraw(accounts);  }

                        } else if(amount2 > balance) {
                        System.out.println (" You do not have enough money on your account. Your balance is " + balances.get (num));
                        withdraw(accounts);
                    } else  {
                        System.out.println ("Invalid amount to withdraw: " + amount2);
                        withdraw(accounts);
                    }
                    break;
                case "Money Market":
                    System.out.println ("Sorry, your account is not available for withdraw. This is Money Market Account");
                    withdraw (accounts);
                    break;
                default:
                    System.out.println ("Wrong input");
                    withdraw (accounts);
            }
        } else {
            System.out.println ("Wrong account");
            withdraw(accounts);
        }

    }


        public void withdraw2(ArrayList accounts){   // Alex
            Scanner input = new Scanner (System.in);
            System.out.println ("You want to pay the fee from different account, select account: ");
            for (int i = 0; i < accounts.size (); i++) {
                System.out.println ("Account number: " + accounts.get (i) + " Account type: " + accttypes.get (acctnumbers.indexOf (accounts.get(i))) );

            }
            String account = input.next ();
            if (accounts.contains (account)) {
                int num = acctnumbers.indexOf (account);
                double balance = balances.get (num);
                String accType = accttypes.get (num);
                switch (accType) {
                    case "Savings":
                        if (2 <= balance) {
                            int withdraw = withdraws.get (num);
                            if (withdraw < 5) {
                                balance = balances.get (num) - 2;
                                balances.set (num, balance);
                                withdraw=(withdraws.get (num));
                                withdraw++;
                                withdraws.set (num,withdraw);
                                message="You were charged 2$ fee from account " + account;
                                transactmessages.add (message);
                                transaccounts.add (account);
                                System.out.println (message);
                            } else if (withdraw == 5) {
                                balance = balances.get (num) - 2;
                                balances.set (num, balance);
                                withdraw++;
                                System.out.println ("This is your last free withdraw from this account");
                                message="You were charged 2$ fee from account " + account;
                                transactmessages.add (message);
                                transaccounts.add (account);
                                System.out.println (message);
                            } else {
                                System.out.println ("You will be charged  2$ extra");
                                balance=balance-4;
                                balances.set (num,balance);
                                withdraw=(withdraws.get (num));
                                withdraw++;
                                withdraws.set (num,withdraw);
                                message="You were charged 4$ fee from account " + account;
                                transactmessages.add (message);
                                transaccounts.add (account);
                                System.out.println (message);
                                }
                                break;
                            } else {
                            System.out.println ("You don't have enough money to pay from this account");
                            withdraw2 (accounts);
                        }
                        break;
                    case "Checking":
                        if (2 <= balance) {
                            balance = balance - 2;
                            balances.set (num, balance);
                            message="You were charged 2$ fee from account " + account;
                            transactmessages.add (message);
                            transaccounts.add (account);
                            System.out.println (message);
                        } else {
                            System.out.println ("You don't have enough money to pay from this account");
                            withdraw2 (accounts);
                        }
                        break;
                    case "Money Market":
                        System.out.println ("Sorry, your can not pay from this account. This is Money market account");
                        withdraw2 (accounts);
                        break;
                    default:
                        System.out.println ("Wrong input");
                        withdraw2 (accounts);
                }
            } else {
                System.out.println ("Wrong account");
                withdraw2 (accounts);
            }
    }


        public void transactionHistory (ArrayList accounts, ArrayList transaccounts,ArrayList transactmessages){   //Fatema
        Scanner input = new Scanner (System.in);
            System.out.println ("Do you want account displayed by account type or by account number");
            System.out.println ("Press 1 for account types and press 2 for Account Numbers");
            String sort=input.next ();
            switch (sort){
                case "1":
                    ArrayList<String> acctcheck=new ArrayList<> ();
                    ArrayList<String> acctsav=new ArrayList<> ();
                    ArrayList<String> acctcmon=new ArrayList<> ();
                    for (int k=0; k<accounts.size (); k++) {
                        String acttype = accttypes.get (acctnumbers.indexOf (accounts.get (k)));
                        String acctnummb = acctnumbers.get (acctnumbers.indexOf (accounts.get (k)));
                        if (acttype.equalsIgnoreCase ("Checking")) {
                            acctcheck.add (acctnummb);
                        } else if (acttype.equalsIgnoreCase ("Savings")) {
                            acctsav.add (acctnummb);
                        } else {
                            acctcmon.add (acctnummb);
                        }
                    }

                    System.out.println ("       Checking Accounts        ");
                    if (acctcheck.size ()==0){
                        System.out.println ("You do not have Checking Accounts");
                    } else
                        for (int i=0; i<acctcheck.size ();i++) {
                        System.out.println ("Transactions for account number " + acctcheck.get (i) + ":");
                        if (transaccounts.contains (acctcheck.get (i))) {
                            for (int j = 0; j < transaccounts.size (); j++) {
                                if (transaccounts.get (j).equals (acctcheck.get (i))) {
                                    System.out.println (transactmessages.get (j));
                                }
                            }
                        } else {
                            System.out.println ("No transactions for this account");
                        }
                        System.out.println ("Account balance: " + balances.get (acctnumbers.indexOf (acctcheck.get (i))));
                        }

                    System.out.println ("      Savings       ");
                    if (acctsav.size ()==0){
                        System.out.println ("You do not have Savings Accounts");
                    } else
                    for (int i=0; i<acctsav.size ();i++) {
                        System.out.println ("Transactions for account number " + acctsav.get (i) + ":");
                        if (transaccounts.contains (acctsav.get (i))) {
                            for (int j = 0; j < transaccounts.size (); j++) {
                                if (transaccounts.get (j).equals (acctsav.get (i))) {
                                    System.out.println (transactmessages.get (j));
                                }
                            }
                        } else {
                            System.out.println ("No transactions for this account");
                        }
                        System.out.println ("Account balance: " + balances.get (acctnumbers.indexOf (acctsav.get (i))));
                    }

                    System.out.println ("    Money Market    ");
                    if (acctcmon.size ()==0){
                        System.out.println ("You do not have Money Market Accounts");
                    } else
                        for (int i=0; i<acctcmon.size ();i++) {
                        System.out.println ("Transactions for account number " + acctcmon.get (i) + ":");
                        if (transaccounts.contains (acctcmon.get (i))) {
                            for (int j = 0; j < transaccounts.size (); j++) {
                                if (transaccounts.get (j).equals (acctcmon.get (i))) {
                                    System.out.println (transactmessages.get (j));
                                }
                            }
                        } else {
                            System.out.println ("No transactions for this account");
                        }
                        System.out.println ("Account balance: " + balances.get (acctnumbers.indexOf (acctcmon.get (i))));
                        }
                    break;
                case "2":
                    for (int i=0; i<accounts.size ();i++) {
                        System.out.println ("Transactions for account number " + accounts.get (i) + ":");
                        if (transaccounts.contains (accounts.get (i))) {
                            for (int j = 0; j < transaccounts.size (); j++) {
                                if (transaccounts.get (j).equals (accounts.get (i))) {
                                    System.out.println (transactmessages.get (j));
                                }
                            }

                        } else {
                            System.out.println ("No transactions for this account");
                        }
                        System.out.println ("Account balance: " + balances.get (acctnumbers.indexOf (accounts.get (i))));
                    }
                    break;
                default:
                    System.out.println ("Wrong Input");
                    transactionHistory (accounts,transaccounts,transactmessages);
            }

    }





        public void transfer(ArrayList accounts){     // Mahadi
        Scanner input = new Scanner (System.in);
            if (accounts.size ()==1){
                System.out.println ("You have only one available account. You can not perform this operation.");
            } else {
                System.out.println ("You have " + accounts.size () + " available accounts");
                for (int i = 0; i < accounts.size (); i++) {
                    System.out.println ("Account number: " + accounts.get (i) + " Account type: " + accttypes.get (acctnumbers.indexOf (accounts.get (i))));
                }
                System.out.println ("Please enter account number you want your money to be transfer from  ");
                String acc = input.next ();
                System.out.println ("Please enter account number you want your money to be transfer to  ");
                String acc2 = input.next ();
                if (accounts.contains (acc) && accounts.contains (acc2)) {
                    int num = acctnumbers.indexOf (acc);
                    double balance = balances.get (num);
                    String accType = accttypes.get (num);
                    int num2 = acctnumbers.indexOf (acc2);
                    double balance2 = balances.get (num2);
                    switch (accType) {
                        case "Savings":
                            System.out.println ("Please enter the amount you want to transfer: ");
                            int amount = -0;
                            try {
                                amount = input.nextInt ();
                            } catch (java.util.InputMismatchException a) {
                                amount = 0;
                            }
                            if (amount > 0 && amount <= balance) {
                                int withdraw = withdraws.get (num);
                                if (withdraw < 5) {
                                    balance = balances.get (num) - amount;
                                    balance2 = balances.get (num2) + amount;
                                    balances.set (num2, balance2);
                                    balances.set (num, balance);
                                    withdraw = (withdraws.get (num));
                                    withdraw++;
                                    withdraws.set (num, withdraw);
                                    String message = "You transfer " + amount + "$ from account " + acc;
                                    String message2 = "You transfer " + amount + "$ to account " + acc2;
                                    transactmessages.add (message);
                                    transaccounts.add (acc);
                                    transactmessages.add (message2);
                                    transaccounts.add (acc2);
                                    System.out.println (message +" " + message2);
                                } else if (withdraw == 5) {
                                    balance = balances.get (num) - amount;
                                    balances.set (num, balance);
                                    balance2 = balances.get (num2) + amount;
                                    balances.set (num2, balance2);
                                    withdraw = (withdraws.get (num));
                                    withdraw++;
                                    withdraws.set (num, withdraw);
                                    System.out.println ("This is your last free withdraw");
                                    String message = "You transfer " + amount + "$ from account " + acc;
                                    String message2 = "You transfer " + amount +"$ to account " + acc2;
                                    transactmessages.add (message);
                                    transaccounts.add (acc);
                                    transactmessages.add (message2);
                                    transaccounts.add (acc2);
                                    System.out.println (message + " " + message2);

                                } else {
                                    System.out.println ("Your max of withdraw is six, after that you have to pay a fee for any withdraw");
                                    System.out.println ("If you want to pay with the same saving account pres 1 for yes, if you want to pay with another account pres 2 for 'no'");
                                    String answer = input.next ();
                                    switch (answer.toLowerCase ()) {
                                        case "1":
                                            int fee=2;
                                            balance = balances.get (num) - amount - fee;
                                            balance2 = balances.get (num2) + amount;
                                            balances.set (num2, balance2);
                                            balances.set (num, balance);
                                            withdraw = (withdraws.get (num));
                                            withdraw++;
                                            withdraws.set (num, withdraw);
                                            message = "You transfer " + amount + "$ from account " + acc + " And you were charged 2$ fee";
                                            String message2 = "You transfer " + amount + "$ to account " + acc2;
                                            transactmessages.add (message);
                                            transaccounts.add (acc);
                                            transactmessages.add (message2);
                                            transaccounts.add (acc2);
                                            System.out.println (message +" " + message2);
                                            break;
                                        case "2":
                                            withdraw2 (accounts);
                                            balance = balances.get (num) - amount;
                                            balance2 = balances.get (num2) + amount;
                                            balances.set (num2, balance2);
                                            balances.set (num, balance);
                                            withdraw = (withdraws.get (num));
                                            withdraw++;
                                            withdraws.set (num, withdraw);
                                            message = "You transfer " + amount + "$ from account " + acc;
                                            String message3 = "You transfer " + amount + "$ to account " + acc2;
                                            transactmessages.add (message);
                                            transaccounts.add (acc);
                                            transactmessages.add (message3);
                                            transaccounts.add (acc2);
                                            System.out.println (message +" " + message3);
                                            break;
                                        default:
                                            System.out.println ("Wrong Input");
                                            transfer (accounts);
                                    }
                                }
                            } else if(amount > balance) {
                                System.out.println (" You do not have enough money on your account. Your balance is " + balances.get (num));
                                transfer (accounts);
                            }
                            else {
                                System.out.println ("Invalid amount to withdraw: " + amount);
                                transfer (accounts);
                            }
                            break;
                        case "Checking":
                            System.out.println ("Please enter the amount you want to transfer: ");
                            int amount2 = -0;
                            try {
                                amount2 = input.nextInt ();
                            } catch (java.util.InputMismatchException a) {
                                amount2 = 0;
                            }
                            if (amount2 > 0 && amount2 <= balance) {
                                balance = balances.get (num) - amount2;
                                balance2 = balances.get (num2) + amount2;
                                balances.set (num2, balance2);
                                balances.set (num, balance);
                                message = "You transfer " + amount2 + "$ from account " + acc;
                                String message2 = "You transfer " + amount2 + "$ to account " + acc2;
                                transactmessages.add (message);
                                transaccounts.add (acc);
                                transactmessages.add (message2);
                                transaccounts.add (acc2);
                                System.out.println (message + " " + message2);
                            } else if(amount2 > balance) {
                                System.out.println (" You do not have enough money on your account. Your balance is " + balances.get (num));
                                transfer (accounts);
                            }else {
                                System.out.println ("Invalid amount to withdraw: " + amount2);
                                transfer (accounts);
                            }
                            break;
                        case "Money Market":
                            System.out.println ("Sorry, your account is not available for transfer. This is Money Market Account");
                            transfer (accounts);
                            break;
                        default:
                            System.out.println ("Wrong input");
                            transfer (accounts);
                    }
                } else {
                    System.out.println ("Wrong account");
                    transfer (accounts);
                }
            }
        }




        }























