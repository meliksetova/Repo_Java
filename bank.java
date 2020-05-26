package Banking;

public class bank {
    public static void main (String[] args) {
        Customer c1 = new Customer ("Karina", "055-558-6565", "Checking", 1500);
        c1.deposit (1001, 1000);
        c1.miniStatement ();
        Customer c2 = new Customer ("Valera", "15248662", "Checking", 1500);
        c2.deposit (1002, 2000);
        c2.miniStatement ();
        c1.withdraw (1001, 2000);
        c2.withdraw (1002, 5000);
        c1.miniStatement ();
            c1.OpenNewAccount ("checking",3000);
            c1.miniStatement ();
            c1.OpenNewAccount ("saving",1500);
            c1.OpenNewAccount ("checking",2500);
            c1.OpenNewAccount ("saving",3000);
            c1.miniStatement ();
            c1.OpenNewAccount ("checking",3000);
            c1.OpenNewAccount ("checking",5000);

        }

}


