package woche05;

import java.util.Random;
import java.util.Scanner;

public class HighLow {
    
    public static void main(String[] args) {
        
        final int MAX = 100; // wieso nicht als final definieren?
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        String decision = "Y";

        while (decision.equalsIgnoreCase("Y")) {

            int choice = rand.nextInt(MAX) + 1;
            System.out.println("Ich denke an eine Zahl zwischen 1 und " + MAX);

            System.out.print("Rate!");
            int guess = scan.nextInt();
            int count = 1; // Counter for guesses

            while (guess != choice) {
                System.out.print("Daneben!");

                if (guess < choice) {
                    System.out.print(" Meine Zahl ist höher!");
                } else {
                    System.out.print(" Meine Zahl ist tiefer");
                }
                System.out.println(" Rate! ");
                guess = scan.nextInt();
                count++;
            }
            System.out.println("Gratuliere! Du hast " + count + " Versuche benötigt.");

            System.out.println("Nochmals? (y/n)");
            decision = scan.next();
        } 
        scan.close();
    }
}
