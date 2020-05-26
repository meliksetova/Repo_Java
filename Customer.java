package Banking;

public class Customer extends Account {
    public String name;
    public String ssn;
    public int amount;
    int position = 0;

    public Customer (String name, String ssn, String type, int amount) {
        this.name = name;
        this.ssn = ssn;
        type = type;
        OpenNewAccount (type, amount);

    }

    public double deposit (int userAccNum, double amount) {
        if (amount > 0) {
            for (int i = 0; i < userCount; i++) {
                if (userActs[i] == userAccNum) {
                    position = i;
                    break;
                } else {
                    System.out.println ("Wrong account number");
                }
            }
            return balances[position] = balances[position] + amount;
        } else
            System.out.println ("Invalid amount to deposit -> " + amount);
        return amount;
    }


    public double withdraw (int userAccNum, double amount) {
        for (int i = 0; i < userCount; i++) {
            if (userActs[i] == userAccNum) {
                position = i;
                if (amount > 0 && amount <= balances[position]) {
                    balances[position] = balances[position] - amount;
                } else {
                    System.out.println ("Invalid amount to withdraw -> " + amount);
                }
                break;
            } else {
                System.out.println ("Wrong account number");

            }
        } return amount;
    }

        public void miniStatement() {
            System.out.println ("Name: " + name);
            System.out.println ("SSN: " + ssn);
            for (int i = 0; i < userCount; i++) {
                System.out.println ("Account number: " + " " + userActs[i]);
                System.out.println ("Account balance: " + " " + balances[i]);
            }

        }
    }
