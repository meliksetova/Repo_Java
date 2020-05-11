package Homework;

import java.util.Arrays;

public class ClassLoops2 {
    public static void main (String[] args) {
        String msg = "Outfit of the day";
        String abr="";
        String[] msgsplit = msg.split (" ");
        for (int i = 0; i < msgsplit.length; i++) {
            String charatindex0 = String.valueOf ((msgsplit[i].charAt (0)));
            String cahratindex0cap = charatindex0.toUpperCase ();
            abr=abr+cahratindex0cap;
        }
        System.out.println ("Abbreviation : " + abr);



        String line = "once upon a time In the uNiverse";
        System.out.println("Line (Before modification) : " + line);
        String linelowercase =line.toLowerCase ();
        String[] linesplit = linelowercase .split (" ");
        String aftermod="";
        for (int i = 0; i < linesplit.length; i++) {
            String name = linesplit[i];
            String index0= String.valueOf ((linesplit[i].charAt(0)));
            String index0cap = index0.toUpperCase ();
            String namerep = name.replaceFirst (index0,index0cap);
            aftermod=aftermod + " " + namerep;

        }

        System.out.println ("Line (After modificationa) : "  + aftermod);


        String message = "Good MOrning";
        String messagereverse = "";
        int meslength = message.length ();
        for (int i = meslength-1; i < (meslength) && i>=0; i--) {
            String indi=String.valueOf (message.charAt(i));
            messagereverse = messagereverse + indi;
                    }
        System.out.println ("Message in reverse: " + messagereverse);

/**
 * Check if word is palindrome
 */
        String word = "level";
        String wordreverse="";
        int wordlength = word.length ();
        for (int i = wordlength-1; i < (wordlength) && i>=0; i--) {
            String indwi=String.valueOf (word.charAt(i));
            wordreverse = wordreverse + indwi;
        }
        boolean result= wordreverse.equalsIgnoreCase (word);

        System.out.println("is " + word + " a palindrome: " + result);


        }

    }




