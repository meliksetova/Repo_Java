package Homework;

public class loops {

    public static void main (String[] args) {
        double studentScore = 30;
        double totalscore = 150;
        double studentPerc = (studentScore / totalscore) * 100;
        String studentPercRound = String.format ("%.2f", studentPerc);
        char studentGrade = ' ';
        if (studentPerc > 90 && studentPerc <= 100) {
            studentGrade = 'A';
        } else if (studentPerc > 80 && studentPerc <= 90) {
            studentGrade = 'B';
        } else if (studentPerc > 70 && studentPerc <= 80) {
            studentGrade = 'C';
        } else if (studentPerc > 60 && studentPerc <= 70) {
            studentGrade = 'D';
        } else if (studentPerc > 50 && studentPerc <= 60) {
            studentGrade = 'E';
        } else if (studentPerc <= 50) {
            studentGrade = 'F';
        } else {
            System.out.println ("Wrong Input");
        }
        if (studentPerc > 0 && studentPerc <= 100) {
            System.out.println ("Your percentage is : " + studentPercRound + "% and your Grade is: " + studentGrade
            );
        }



        char mode = 'R';
        String drivetype = "eco";
        String drivet = drivetype.toLowerCase ();
        String message = "";

        switch (mode) {
            case 'P':
            case 'p':
                message = "You can park car";
                break;
            case 'D':
            case 'd':
                if (drivet == "snow") {
                    message = "You are on Snow mode";
                } else if (drivet == "sport") {
                    message = "You are on Sport mode";
                }else if (drivet == "eco"){
                    message = "You are on Eco Mode";
                } else {
                    message = "Error";
                }
                break;
            case 'N':
            case 'n':
                message = "Put car in car wash";
                break;
            case 'r':
            case 'R':
                 message = "Reverse the car";
                 break;
            default:
                 message = "Error";
                }

                System.out.println (message);




        int num = 22;
        int b=num%3;
        int c=num%5;
        String message2="";
        if (b==0 && c!=0){
            message2="Number is divisible by 3";
        } else if (c==0 && b!=0){
            message2="Number is divisible by 5";
        } else if (c==0 && b==0){
            message2="Number is divisible by both";
        } else {
            message2 = String.valueOf (num);
        }
                System.out.println (message2);
    }

}








