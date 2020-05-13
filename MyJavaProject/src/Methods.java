package Homework;

public class Methods {

    private static int[] scores;

    public static void main (String[] args) {

        System.out.println (nameplace ("Michael"));
        int[] numbers = {2, 5, 89, 75, 48, 90};
        System.out.println (Average (numbers));
        int[] numbers2 = {45, 22, 11, 65, 189, 91, 100, 81};
        System.out.println (Max (numbers2));
        int[] scores = {90, 89, 191, 100, 81};
        String[] names = {"Happy", "Peace", "Jesse", "Kaitlin", "Lucky"};
        System.out.println (getScore(scores,names));
    }

    public static String getScore(int[] scores, String[] names){
        String message = "";
        int maxscore=0;
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
        if (scores[i] > max) {
            max = scores[i];
        }
    }
        for (int i = 0; i < scores.length; i++) {
        if (scores[i] == max) {
            maxscore = i;
            break;
        }
    }
       return message=names[maxscore] + " scored the maximum score - " + max;
}


    public static String Max(int[] numbers2){
        String message="";
            int max= numbers2[0];
            for(int i=0;i < numbers2.length; i++){
                if(numbers2[i] > max){
                    max = numbers2[i];
                }
            }
            return message = "Maximum value in the given array: " + max;
        }

    public static String Average(int[] numbers){
        int length=numbers.length;
        double total=0;
        double average=0.00;
        String message ="";
        for (int i=0; i < length; i++) {
            total = total + numbers[i];
        }  average = total / length;
        return message = "Average of the given array: " + average;

    }
    public static String nameplace(String nameToSearch){
        String[] names = {"john" , "michael" , "dora" , "philip" , "ilena" , "palena" , "fahry"};
        String message="";
        for (int i=0; i < names.length-1; i++ ){
            if (names[i].equalsIgnoreCase (nameToSearch)){
                message = nameToSearch + " is on position " + i;
                break;
            } else {
                message = nameToSearch + " is not present in the array";
            }

        }
        return message;
    }
}
