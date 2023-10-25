/**
 * Quotient.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-01
 * @version 1.0
 * 
 * Schreiben Sie ein Programm, das vom Benutzer die Eingabe von zwei ganzzahligen Werten a und b fordert.
 * Ihr Programm soll den Quotienten a^2 / b sowohl als Gleitkommazahl (d.h. ungerundet) 
 * als auch als ganze Zahl mit Rest berechnen und beide Ergebnisse am Bildschirm ausgeben.
 * Testen Sie Ihr Programm mit beliebigen Zahlen.
 * Beobachten Sie insbesondere das Programmverhalten bei Eingabe der Zahl 0 als Divisor
 * und versuchen Sie diesen Laufzeitfehler abzufangen.
 */
package aufgabe02;

import java.util.Scanner;

public class Quotient {
    public static void main(String[] args) {

        System.out.println("Dieses Programm berechnet den Quotienten zweier Zahlen \"a\" und \"b\".");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie den Teil \"a\" ein:");
        double var1 = scan.nextDouble();
        
        System.out.println("Geben Sie den Teil \"b\" ein:");
        double var2 = scan.nextDouble();
        
        /*
         * Nach Feedback:
         * Verhalten führt so zu division by zero bei bspw Eingabe von 0.1
         * int quotientInt = (int) var1 * (int) var1) / (int) var2;
         * berechnet den Quotienten als int, was zu einer Rundung führt
         * Um mit b Werten wie 0.1 zu rechnen, muss der Quotient als double berechnet werden,
         * und erst dann in einen int umgewandelt werden
         */
        if (var2 != 0) { //Wert 0 führt zu divide by zero
            double quotientDouble = (var1 * var1) / var2;
            // int quotientInt = (int) var1 * (int) var1) / (int) var2;
            int quotientInt = (int) quotientDouble;
            System.out.println("________________________________________________________________________\n" + 
                "Der Quotient Ihrer Zahlen: \t" + quotientDouble + 
                "\nUnd als \"int\":\t \t \t" + quotientInt);
        } else { 
            System.out.println("Geben Sie nicht 0 ein!");
        }

        scan.close();
    }
}
