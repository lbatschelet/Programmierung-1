/**
 * UsernameAndPassword.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-11
 * @version 1.0
 * 
 * Schreiben Sie ein Programm, das einen Benutzer separat nach seinem Vor- und Nachnamen fragt und diese einliest.
 * Danach soll ein Benutzername nach folgendem Muster erzeugt werden:
 *      F L1 L2 L3 L4 L5 D1 D2 D3
 * wobei
 * - F dem ersten Buchstaben des Vornamens entspricht.
 * - Li dem i-ten Buchstaben des Nachnamens entspricht.
 * - D1 D2 D3 einer zufälligen Zahl zwischen 000 und 999 entspricht.
 * 
 * Falls der eingegebene Nachname kürzer als 5 Zeichen sein sollte, werden entsprechend weniger Zeichen verwendet.
 * Zusätzlich erzeugen Sie ein zufälliges Passwort für den Benutzer. Das Passwort soll mit einer 7 oder 8 oder 9 starten,
 * gefolgt von 5 zufälligen ganzen Zahlen von 0 bis 9, gefolgt von einem Bindestrich -, gefolgt von drei zufälligen 
 * Grossbuchstaben. Geben Sie Benutzernamen und Passwort aus.
 * Tipp: Die Zahlen 65 bis 90 repräsentieren die Grossbuchstaben A bis Z in Unicode und Sie können bspw. die ganze 
 * Zahl 77 folgendermassen in einen Buchstaben umwandeln:
 * char d1 = (char) 77;
 */

package aufgabe03;

import java.util.Scanner;
import java.util.Random;

public class UsernameAndPassword {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Dieses Programm generiert einen Benutzernamen und ein Passwort.");
        System.out.println("Geben Sie Ihren Vornamen ein:");
        String firstName = scan.nextLine();
        System.out.println("Geben Sie Ihren Nachnamen ein:");
        String lastName = scan.nextLine();
        scan.close();

        int lastNameLength = lastName.length();
        final int MAX_LETTERS_OF_LASTNAME = 5;

        String firstLetter = firstName.substring(0, 1);
        // Math.min(a, b) sorgt dafür, dass auch Nachnamen mit weniger als MAX_LETTERS_OF_LASTNAME Buchstaben funktionieren
        String lastNameArray = lastName.substring(0, Math.min(MAX_LETTERS_OF_LASTNAME, lastNameLength));

        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        // String.format("%03d", randomNumber) fügt führende Nullen hinzu, falls randomNumber < 100
        String username = firstLetter.toUpperCase() + lastNameArray.toUpperCase() + String.format("%03d", randomNumber);


        System.out.println("Der Benutzername lautet: " + username);

        final int UNICODE_LOWER_BOUND = 65;
        final int UNICODE_UPPER_BOUND = 91;
        // ermöglicht die zufällige Ausgabe des ganzen Zahlenteils des Passworts
        int randomPasswordNumber = random.nextInt(700000, 1000000);
        char randomPasswordLetter1 = (char) random.nextInt(UNICODE_LOWER_BOUND, UNICODE_UPPER_BOUND);
        char randomPasswordLetter2 = (char) random.nextInt(UNICODE_LOWER_BOUND, UNICODE_UPPER_BOUND);
        char randomPasswordLetter3 = (char) random.nextInt(UNICODE_LOWER_BOUND, UNICODE_UPPER_BOUND);

        String password = randomPasswordNumber + "-" + randomPasswordLetter1 + randomPasswordLetter2 + randomPasswordLetter3;

        System.out.println("Das Passwort lautet: " + password);
    }
}

