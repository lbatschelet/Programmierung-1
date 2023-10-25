package woche03;

import java.util.Random;

public class RandomNumbers {
    
    /**
     * Demonstriert den Gebrauch der Klasse random
     */

     public static void main(String[] args) {

        Random random = new Random();
        int num1;
        double num2;

        num1 = random.nextInt();
        System.out.println("Eine zufällige ganze Zahl: " + num1);

        num1 = random.nextInt(2);
        System.out.println("0 oder 1?: " + num1);

        num1 = random.nextInt(10);
        System.out.println("Eine zuföllige ganze Zahl zwischen 0 und 9: " + num1);

        num1 = random.nextInt(10) + 1;
        System.out.println("Eine zuföllige ganze Zahl zwischen 1 und 10: " + num1);

        num1 = random.nextInt(21) - 10;
        System.out.println("Eine zufällige ganze Zahl zwischen -10 und 10: " + num1);

        num2 = random.nextFloat();
        System.out.println("Zufallszahl aus [0.0, 1.0[: " + num2);

        num2 = random.nextFloat() * 5;
        System.out.println("Zufallszahl zwischen [0.0, 5.0[: " + num2);

     }


}
