package Functions;

import java.util.Arrays;

public class functAndMethods {

    public static void Max (int[] numbers2) {
        int max = numbers2[0];
        for (int i = 0; i < numbers2.length; i++) {
            if (numbers2[i] > max) {
                max = numbers2[i];
            }
        }
        System.out.println ("Maximum value in the given array: " + max);
    }

    public static void Average (int[] numbers) {
        int length = numbers.length;
        double total = 0;
        double average = 0.00;
        String message = "";
        for (int i = 0; i < length; i++) {
            total = total + numbers[i];
        }
        average = total / length;
        System.out.println ("Average of the given array: " + average);

    }

    public static void Abbr (String msg) {
        String abr = "";
        String[] msgsplit = msg.split (" ");
        for (int i = 0; i < msgsplit.length; i++) {
            String charatindex0 = String.valueOf ((msgsplit[i].charAt (0)));
            String cahratindex0cap = charatindex0.toUpperCase ();
            abr = abr + cahratindex0cap;
        }
        System.out.println ("Abbreviation : " + abr);
    }

    public static void Capital (String line) {
        String[] linesplit = line.toLowerCase ().split (" ");
        String aftermod = "";
        for (int i = 0; i < linesplit.length; i++) {
            String name = linesplit[i];
            String index0 = String.valueOf ((linesplit[i].charAt (0)));
            String index0cap = String.valueOf ((linesplit[i].charAt (0))).toUpperCase ();
            String namerep = name.replaceFirst (index0, index0cap);
            aftermod = aftermod + " " + namerep;

        }

        System.out.println ("Line (After modificationa) : " + aftermod);
    }

    public static int[] sortArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    public static void Prime (int number) {
        boolean prime = true;
        if (number == 1) {
            prime = true;
        } else if (number <= 0) {
            prime = false;
        } else
            for (int i = 2; i < number; i++) {
                if (number % (i) == 0) {
                    prime = false;
                    break;
                } else
                    prime = true;
            }
        System.out.println ("Number " + number + " is prime: " + prime);
    }


    public static boolean SleepIn (boolean weekday, boolean vacation) {
        boolean sleepIn;
        if (vacation == true) {
            sleepIn = true;
        } else if (weekday == true) {
            sleepIn = false;
        } else
            sleepIn = true;
        return sleepIn;
    }

    public int diff21 (int n) {
        int diff;
        if (n == 21) {
            diff = 0;
        } else if (n < 21) {
            diff = 21 - n;
        } else
            diff = (n - 21) * 2;
        return diff;
    }

    public static boolean makes10 (int a, int b) {
        boolean makes10 = false;
        if (a == 10) {
            makes10 = true;
        } else if (b == 10) {
            makes10 = true;
        } else if ((a + b) == 10) {
            makes10 = true;
        }

        return makes10;
    }

    public static int countEvens (int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                j++;
            }
        }
        return j;
    }

    public static int bigDiff (int[] nums) {
        int diff;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return diff = max - min;

    }


    public int centeredAverage (int[] nums) {
        int centeredAverage;
        int max = nums[0];
        int min = nums[0];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            total = total + nums[i];
        }

        centeredAverage = (total - min - max) / (nums.length - 2);
        return centeredAverage;
    }

    public int sum13 (int[] nums) {
        int total = 0;
        int j = 0;
        if (nums.length == 0) {
            total = 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 13) {
                    if (i == (nums.length - 1)) {
                        nums[i] = 0;
                    } else if (i < (nums.length - 1)) {
                        nums[i] = 0;
                        nums[i + 1] = 0;

                    }
                }

            }
            for (int i = 0; i < nums.length; i++) {
                total = total + nums[i];
            }


        } return total;
    }

/**
 * Question 1:
 * Create a method to return an array after remove a specific value from a given int array.
 * Original array: {32, 14, 24, 98, 24, 56, 148, 24, 78, 24}    Remove: 24
 * Returned array: {32, 14, 98, 56, 148, 78}
 *
 * Input array:     {1, 2, 4, 3, 1, 6, 1}    Remove: 11
 * Returned Array:  {1, 2, 4, 3, 1, 6, 1}
 *
 */

public static void Remove(int[] numbers,int number) {
    int k = numbers.length - 1;
    int[] numbers2 = new int[k];
    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == number) {
                k--;
            } else {
                numbers2[i] = numbers[i];
            System.out.println (numbers2[i]);
            }

        //for (int l = 0; l < numbers2.length; l++) {
          //  System.out.println (numbers2[l]);
        }
    System.out.println (Arrays.toString (numbers2));

    }



public static void SmallPosInt(int[] numbers){
        int miss =1;
        for (int i=0; i<numbers.length; i++){
            if (numbers[i]==miss) {
                miss++;
            } else
                miss=1;


        } System.out.println ("Smallest positive integer missing is " + miss);
}



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











