package woche03;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        
        final int MAX = 3;
        int answer, guess;

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        answer = rand.nextInt(MAX) + 1;

        System.out.println("Gesucht ist eine Zahl zwischen 1 und " + MAX);

        guess = scan.nextInt();

        scan.close();

        if (guess == answer) {
            System.out.println("Juhuuuu!");
        } else {
            System.out.println("Buhuuu");
            System.out.println("Gesucht war: " + answer);
        }

    }
}
