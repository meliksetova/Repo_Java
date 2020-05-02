package Homework;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Class3 {
    public static void main (String[] args) {
        String myFirstName = "Karina";
        int myFirstNameLength = myFirstName.length ();
        boolean startsWithK = myFirstName.startsWith ("K");
        boolean startsWithk = myFirstName.startsWith ("k");
        char firstLetter = myFirstName.charAt (0);
        boolean endswithm = myFirstName.toLowerCase ().endsWith ("M");
        System.out.println ("Length of my name: " + myFirstNameLength + " letters");
        System.out.println ("Is my name start with K? " + startsWithK);
        System.out.println ("Is my name start with k? " + startsWithk);
        System.out.println ("What is first letter of my name? " + firstLetter);
        System.out.println ("Is my name end with M? " + endswithm);
        System.out.println ("                  ");

        String myStatement = "I am a good programmer";
        String[] afterSplit = myStatement.split (" ");
        int afterSplitLen = afterSplit.length;
        String afterReplace = myStatement.replace ("r","f");
        System.out.println ("Last word of my statement: " + afterSplit[afterSplitLen-1]);
        System.out.println ("Total numbers of words in my statement: " + afterSplitLen);
        System.out.println ("My statement after replacing 'r' with 'f': " + afterReplace);
        System.out.println("              ");

        String[] myFirstNameSplit = myFirstName.split ("");
        int myFirstNameSplitLen = myFirstNameSplit.length;
        System.out.println ("Length of my name: " + myFirstNameSplitLen + " letters");






    }
}
