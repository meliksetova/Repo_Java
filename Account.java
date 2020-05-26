package Banking;

public class Account {
    public static int accNum = 1000;
    public int amount;
    public double balance;
    public String type;
    public int userAccNum;
    public int userCount;
    double [] balances = new double[5];
    int [] userActs= new int[5];


    public void OpenNewAccount (String type, int amount) {
        type = type;
        if (type.equalsIgnoreCase ("Checking") || type.equalsIgnoreCase ("Saving")) {
            if (amount >= 1000) {
                if (userCount < 5) {
                    userAccNum = ++accNum;
                    userActs[userCount]=userAccNum;
                    balances[userCount]=amount;
                    userCount=++userCount;
                    double [] balances = new double[userCount+1];
                    int [] userActs = new int[userCount+1];
                } else
                    System.out.println ("Too many accounts");
            } else if (amount > 0) {
                System.out.println ("Not enough to open an account");
            } else
                System.out.println ("Wrong amount input");
        }  else
            System.out.println ("Wrong account type");

    }



       }




