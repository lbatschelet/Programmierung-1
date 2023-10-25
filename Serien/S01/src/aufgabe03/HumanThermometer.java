/**
 * HumanThermometer.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-01
 * @version 1.0
 * Schreiben Sie ein Programm, das vom Benutzer die Eingabe einer Temperatur t fordert.
 * Die Ausgabe Ihres Programms definiert sich danach folgendermassen:
 * - "Kalt", wenn t < 15
 * - "Angenehm", wenn 15 <= t < 24
 * - "Warm", wenn t >= 24
 * Hinweis: Verwenden Sie Konstanten für beide Temperaturgrenzen.
*/

package aufgabe03;

import java.util.Scanner;

public class HumanThermometer {
    public static void main(String[] args) {
		final int LOWER_BOUND = 15;
		final int UPPER_BOUND = 24;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Die aktuelle Temperatur: ");
		int temperature = scan.nextInt();
		
		if (temperature < LOWER_BOUND) {
			System.out.println("Es ist kalt");
		} 
		else if ((LOWER_BOUND <= temperature) && (temperature <= UPPER_BOUND)) {
			System.out.println("Es ist angenehm");
		} 
		else
			System.out.println("Es ist warm");
		
		scan.close();
	}
}
