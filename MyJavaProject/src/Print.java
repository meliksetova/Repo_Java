package Homework;

        public class Print extends Printer {


                public static void main (String[] args) {
                        addToner (20);
                        addToner (50);
                        addToner (10);
                        addToner (30);
                        addPages (20);
                        addPages (30);
                        addPages (50);
                        addPages (20);
                        printSummary ();
                        print (20,"double");
                        print (40,"double");
                        print (30,"single");
                        printSummary ();
                        print (19,"double");
                        printSummary ();

                }
        }