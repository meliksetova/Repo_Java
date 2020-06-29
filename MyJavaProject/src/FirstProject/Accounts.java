package src.ProjectExcel;

import java.util.ArrayList;

public class Accounts {
    ArrayList<String> AcctNames=new ArrayList<> ();
    ArrayList<String> acctnumbers = new ArrayList<> ();
    ArrayList<String> accttypes = new ArrayList<> ();
    ArrayList<Double> balances = new ArrayList<> ();
    ArrayList<Integer> withdraws = new ArrayList<> ();
    int AcctNumber;
    String AcctType;
    double Balance;
    int withdraw;
    String message;



    public void setAccount (String name, String account, String type, double amount, int withdraw) {
        acctnumbers.add (account);
        AcctNames.add(name);
        accttypes.add (type);
        balances.add (amount);
        withdraws.add (withdraw);
    }

}
