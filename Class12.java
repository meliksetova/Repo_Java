package src.Homework;

import java.util.ArrayList;
import java.util.List;

public class Class12 {
    public static void main (String[] args) {
            returnComElem (new int[] {11, 32, 43, 54, 65}, new int[] {76, 11, 89, 43, 87, 23, 32});
            returnDupl (new String[]{"happy", "peace", "joy", "grow", "laugh", "happy", "laugh", "joy"});

    }

        public static void returnDupl(String[] words){
            List<String> words2=new ArrayList<> ();
            for( int i=0; i<words.length; i++){
                for(int j=i+1; j<words.length; j++){
                    if (words[i]==words[j] && i!=j ){
                        words2.add (words[i]);
                    }
                }
            }
            System.out.println (words2);
        }


public static void returnComElem(int[] arr1, int[] arr2){
    List<Integer> arr3=new ArrayList<> ();
    for( int i=0; i<arr1.length; i++){
        for(int j=0; j<arr2.length; j++){
            if (arr1[i]==arr2[j]){
                arr3.add (arr1[i]);
            }

        }
    }
    System.out.println (arr3);



}
}