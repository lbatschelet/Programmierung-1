package woche05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CashDesk {
    
    public static void main(String[] args) {
        
        double priceSum = 0.0;
        int count = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Geben Sie den Preis von Position " + count + " ein." +
                           " (-1 zum Beenden)");
        double price = scan.nextDouble();

        while (price != -1) {
            priceSum += price;
            count++;
            System.out.println("Geben Sie den Preis von Position " + count + " ein." +
                               " (-1 zum Beenden)");
            price = scan.nextDouble();
        }
        scan.close();
        
        if (count == 1) {
            System.out.println("Keine Eingabe getätigt.");
        } else {
            DecimalFormat fmt = new DecimalFormat("CHF 0.00");
            System.out.println("Anzahl Eingaben: " + count);
            System.out.println("Total: " + fmt.format(priceSum));
        }
    }
}
