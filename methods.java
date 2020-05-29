package Test;

import java.util.Arrays;

public class methods {


    public static void TrafTickSyst (int number) {
        if (number <= 0 || number > 250) {
            System.out.println ("Wrong Input");
        } else if (number <= 70) {
            System.out.println ("Thank you for driving within the speed limit");
        } else if (number > 70) {
            int points = (number - 70) / 5;
            if (points < 12) {
                System.out.println ("Your speed is: " + number + "  You got " + points + " points on your driving license");
            } else
                System.out.println ("Your speed is: " + number + "  You got " + points + " points on your driving license (License suspended)");
        }
    }

    public static void Remove (int[] numbers, int number) {
        int k = 0;
        int m = 1;
        int[] numbers3 = new int[m];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                int j = 0;
                int[] numbers2 = new int[j + 1];
                numbers2[j] = numbers[i];
                j++;
            } else {
                numbers3[k] = numbers[i];

            }

        }
        System.out.println (Arrays.toString (numbers3));


    }
}
