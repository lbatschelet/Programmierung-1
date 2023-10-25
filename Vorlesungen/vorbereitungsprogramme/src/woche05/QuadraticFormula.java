package woche05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class QuadraticFormula {
    
    public static void main(String[] args) {
        double a, b, c;
        double x, x1, x2, discriminant;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dieses Programm berechnet die Nullstellen einer quadratischen Gleichung im format: \n" +
                            "a * x^2 + b * x + c");
        System.out.println("Geben Sie die Koeffizienten a, b und c ein:");
        System.out.print("a = ");
        a = scanner.nextDouble();
        System.out.print("b = ");
        b = scanner.nextDouble();
        System.out.print("c = ");
        c = scanner.nextDouble();

        scanner.close();

        discriminant = Math.pow(b, 2) - 4 * a * c;

        DecimalFormat fmt = new DecimalFormat("0.###");

        if (discriminant < 0) {
            System.out.println("Die Funktion hat keine Nullstelle.");
        } else if (discriminant == 0) {
            x = (-1 * b)  / (2 * a);
            System.out.println("Die Funktion hat genau eine Nullstelle: " + fmt.format(x));
        } else {
            System.out.println("Die Funktion hat zwei Nullstellen x1 und x2.");
            x1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
            x2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("x1 = " + fmt.format(x1));
            System.out.println("x2 = " + fmt.format(x2));
        }

    }
}
