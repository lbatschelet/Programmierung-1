package woche05;

import java.util.Scanner;

public class GCD {
    
    public static void main(String[] args) {
        
        String another = "Y";
        Scanner scan = new Scanner(System.in);

        int value1, value2;

        while (another.equalsIgnoreCase("Y")) {
            System.out.print("Erste Zahl: ");
            value1 = scan.nextInt();
            System.out.print("Zweite Zahl: ");
            value2 = scan.nextInt();

            while (value1 != value2) {
                if (value1 > value2) {
                    value1 -= value2;
                } else {
                    value2 -= value1;
                }
            }
            int gcd = value1;
            System.out.println("Der ggT Ihrer Zahlen ist: " + gcd);
            System.out.println("Wollen Sie einen weiteren ggT berechnen? (Y/N)");
            another = scan.next();
        }
        scan.close();
    }
}
