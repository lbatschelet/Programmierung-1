package woche03;

import java.util.Scanner;

public class ParkingFee {
    
    /**
     * Berechnet die Parkgebühr auf Basis der Parkzeit
     */

    public static void main(String[] args) {

        final double FEE_PER_HOUR = 2.5; //Parkgebühr für die ersten 5 Stunden
        final int MAX_HOURS = 5; //
        final double FACTOR = 1.5; // 1.5-fache Parkgebühr ab 5 Stunden

        Scanner scan = new Scanner(System.in);

        double fee = 0.0; // festlegen der Startgebühr
        System.out.println("Parkdauer in Stunden eingeben:");
        double parkingTime = scan.nextDouble();

        if (parkingTime <= MAX_HOURS)
            fee = parkingTime * FEE_PER_HOUR;
        else {
            double additionalHours = parkingTime - MAX_HOURS;
            fee = MAX_HOURS * FEE_PER_HOUR;
            fee += additionalHours * FEE_PER_HOUR * FACTOR;
        }

        System.out.println("Zu bezahlen: " + fee + " CHF");

        scan.close();
    }
}
