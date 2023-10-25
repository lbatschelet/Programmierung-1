package woche03;

import java.util.Scanner;
import java.util.Random;

public class NumberGuesser {
    
    /**
     * Spielt ein kleines 1,2 oder 3 Spiel und zeigt dabei die Verwendung der Klassen Scanner und Random
     */

     public static void main(String[] arg) {

        final int MAX = 3;
        int answer, guess;

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        answer = random.nextInt(MAX) + 1;

        System.out.println("Gesucht ist eine Zahl zwischen 1 und " + MAX + ". Raten Sie!");
        guess = scan.nextInt();

        if (guess == answer)
            System.out.println("Glück gehabt! Das ist richtig...");
        else {
            System.out.println("Leider daneben.");
            System.out.println("Gesucht war: " + answer);
        }

        scan.close();
     }
}
