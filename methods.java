package Test;

public class methods {


    public static void TrafTickSyst(int number){
        if (number<=0 || number>250){
            System.out.println ("Wrong Input");
        } else if (number<=70){
            System.out.println ("Thank you for driving within the speed limit");
        } else if (number>70){
            int points=(number-70)/5;
            if (points<12){
                System.out.println ("Your speed is: " + number + "  You got " + points + " points on your driving license");
            } else
                System.out.println ("Your speed is: " + number + "  You got " + points + " points on your driving license (License suspended)");
        }
    }



}
