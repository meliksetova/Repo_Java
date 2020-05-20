package Homework;

public class Printer {

    public static int toner;
    public static int pages;

    public static void addPages (int inpPages) {
        if (inpPages > 0 && (inpPages + pages) <= 100) {
            pages = inpPages + pages;
        } else
            System.out.println ("Paper input error");
    }

    public static void addToner (int inpToner) {
        if (inpToner > 0 && (inpToner + toner) <= 100) {
            toner = inpToner + toner;
        } else
            System.out.println ("Error");
    }

    public static void print(int inpPages, String sides) {
        int prnPages =0;
        if (sides.equalsIgnoreCase ("double")) {
            if (inpPages % 2 == 0) {
                prnPages = inpPages / 2;
            } else
                prnPages = inpPages / 2 + 1;
        } else if (sides.equalsIgnoreCase ("single")) {
            prnPages = inpPages;
        } else
            System.out.println ("Wrong Input");

        if ( prnPages>0 && prnPages<=pages && prnPages<=toner ){
            pages = pages-prnPages;
            toner = toner-inpPages;
        } else if (prnPages<=0 || prnPages>100) {
            System.out.println ("Wrong Paper Input");
        } else if (prnPages>pages){
            System.out.println ("Not enough papers");
        } else if (prnPages>toner){
            System.out.println ("Not enough toner");
        }
        if (toner<10){
            System.out.println ("Please add toner");
        }
    }

    public static void printSummary(){
        System.out.println ("Toner level: " + toner);
        System.out.println ("Pages in tray: " + pages);
    }

}








