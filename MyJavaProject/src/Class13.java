package src.Homework;

import java.util.*;

public class Class13 {
    public static void main (String[] args) {
        List<String> words = new ArrayList<> ();
        words.add ("happy");
        words.add ("peace");
        words.add ("joy");
        words.add ("grow");
        words.add ("joy");
        words.add ("laugh");
        words.add ("happy");
        words.add ("laugh");
        words.add ("joy");
        HashMap<String, Integer> duplicates = new HashMap<> ();
        for (int i = 0; i < (words.size () - 1); i++) {
            int k = 1;
            if (!duplicates.containsKey (words.get (i))) {
                for (int j = i + 1; j < words.size (); j++) {
                    if (words.get (i) == words.get (j)) {
                        k++;
                    }
                    if (k > 1) {
                        duplicates.put (words.get (i), k);
                    }
                }
            }
        }
        System.out.println (duplicates);







        Scanner input = new Scanner (System.in);
        Map<Integer, String> userMap = new HashMap<> ();
        System.out.println ("Please enter how many pairs you want to put in");
        int num = input.nextInt ();
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Enter Number and Text:");
        for (int i = 0; i < num; i++) {
            System.out.println ("Please enter a key (Integer) :");
            Integer key = scanner.nextInt ();
            if (userMap.containsKey (key)) {
                System.out.println ("Map already have this key: " + key + " = " + userMap.get (key));
                i = i - 1;
            } else {
                System.out.println ("Please enter value (String) to store with '" + key + "' key:");
                String value = scanner.next ();
                userMap.put (key, value);
            }
        }
        Collection<String> values = userMap.values ();
        ArrayList<String> values2 = new ArrayList<> (values);
        Collection<Integer> keys=userMap.keySet ();
        ArrayList<Integer> keys2= new ArrayList<> (keys);
        Set<String> Dublicates2 = new HashSet<> ();
        for (int i = 0; i < values2.size () - 1; i++) {
            for (int j = i + 1; j < values2.size (); j++) {
                if (values2.get (i).equals (values2.get (j))) {
                    Dublicates2.add (values2.get (j));
                }
            }
        }
        ArrayList<String> Dublicates3 = new ArrayList<> (Dublicates2);
        if (Dublicates3.size ()==0){
            System.out.println ("All keys have different values");
        } else
        for (int l = 0; l < Dublicates3.size (); l++) {
            String doubl = Dublicates3.get (l);
            for (int m = 0; m < values2.size (); m++) {
                if (doubl.equalsIgnoreCase (values2.get (m))) {
                    System.out.println ("Dublicate value " + values2.get (m) + " = " + keys2.get(m));

                }
            }
        }








            Scanner input2 = new Scanner (System.in);
            Map<String, Integer> userMap2 = new HashMap<> ();
            System.out.println ("Please enter how many students in a class");
            int num2 = input.nextInt ();
            Scanner scanner2 = new Scanner (System.in);
            System.out.println ("Enter Name and score:");
            for (int i = 0; i < num2; i++) {
                System.out.println ("Please enter a student name : ");
                String student = scanner2.next ();
                System.out.println ("Please enter a score(Integer) to store with " + student);
                Integer score = scanner2.nextInt ();
                userMap2.put (student, score);
            }
            Collection<Integer> scores = userMap2.values ();
            Object[] arr = scores.toArray ();
            Integer maxScore = Collections.max (scores);

            String studentmax = "";
            for (String name : userMap2.keySet ()) {
                if (userMap2.get (name) == maxScore) {
                    studentmax = name;
                    break;
                }
            }
            System.out.println (studentmax + " scored max ( " + maxScore + " ) in the class");
        }

    }



