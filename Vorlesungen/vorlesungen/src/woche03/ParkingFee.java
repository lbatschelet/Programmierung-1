package woche03;

import java.util.Scanner;

public class ParkingFee {
    
    public static void main(String[] args) {

        final double FEE_PER_HOUR = 2.5;
        final int MAX_HOURS = 5;
        final double FACTOR = 1.5;

        Scanner scan = new Scanner(System.in);

        System.out.println("Parkzeit in Stunden angeben: ");
        int parkingTime = scan.nextInt();

        scan.close();

        double fee = 0.0;
        if (parkingTime <= MAX_HOURS) {
            fee = parkingTime * FEE_PER_HOUR;
        } else {
            int additionalHours = parkingTime - MAX_HOURS;
            fee = MAX_HOURS * FEE_PER_HOUR;
            fee += additionalHours * FEE_PER_HOUR * FACTOR;
        }

        System.out.println("Parkgebühr: " + fee);
    }
}
