package Homework;

public class Operators {
    public static void main (String[] args) {
        double tempC = 20;
        double tempF = (9.0/5.0) * tempC + 32;
        System.out.println (tempC + " C" + " = " + tempF + " F");
        double tempK = 285;
        double tempF2 = (9.0/5.0) * (tempK - 273) + 32;
        System.out.println (tempK + " K" + " = " + tempF2 + " F");
        double tempC2 = 20;
        double tempK2 = tempC2 + 273;
        System.out.println (tempC2 + " C" + " = " + tempK2 + " K");
        double tempK3 = 285;
        double tempC3 = tempK3 - 273;
        System.out.println (tempK3 + " K" + " = " + tempC3 + " C");
        double tempF4 = 68;
        double tempK4 = (5.0/9.0) * (tempF4 - 32) + 273;
        System.out.println (tempF4 + " F" + " = " + tempK4 + " K");
    }
}
