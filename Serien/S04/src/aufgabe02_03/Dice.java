/**
 * Dice.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-30
 * @version 1.0
 * @serie   4
 * @aufgabe 2
 * 
 * Übernehmen Sie die Klasse `Dice` aus dem Skript. 
 * Schreiben Sie dann eine Klasse `PairOfDice`, welche aus zwei `Dice` Objekten besteht.
 * Definieren Sie Methoden zum Setzen und Auslesen der Punkte der einzelnen Würfel,
 * eine Methode um beide Würfel zu werfen,
 * und eine Methode, welche die aktuelle Summe der Würfel zurückgibt.
 */


package aufgabe02_03;

import java.util.Random;

public class Dice {

	// maximale Punktezahl des Würfels
	public final int MAX = 6;

	// aktuelle Punktezahl des Würfels
	private int points;

	// Objekt zur Erzeugung von Zufallszahlen
	private Random randomGenerator;

	/**
	 * instanziiert einen neuen Würfel und initialisiert die Variablen
	 */
	public Dice() {
		this.randomGenerator = new Random();
		this.points = 1;
	}

	/**
	 * "wirft" den Würfel (setzt die Punktezahl auf eine zufällige, gültige Zahl)
	 */
	public int roll() {
		this.points = this.randomGenerator.nextInt(MAX) + 1;
		return this.points;
	}

	/**
	 * setzt die aktuelle Punktezahl des Würfels auf den übergebenen Wert
	 */
	public void setPoints(int points) {
		if (points >= 1 && points <= MAX)
			this.points = points;
		else
			this.printMessage("Unzulässige Eingabe. " + "Würfel wird nicht verändert.");
	}

	/**
	 * gibt die aktuelle Punktezahl des Würfels zurück
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * gibt eine Systemmeldung aus
	 */
	private void printMessage(String message) {
		System.out.println(message);
	}


	/**
	 * Returns an array of strings representing the art of a dice with a certain number of points.
	 * The art is represented using ASCII characters.
	 */
	public String[] getDiceArt() {
        String[] art = new String[5];
        String topAndBottom = "+-------+";
        String middle = "|   *   |";
        String empty = "|       |";
        String left = "| *     |";
        String right = "|     * |";
        String both = "| *   * |";

        art[0] = topAndBottom;
        art[4] = topAndBottom;
        
        switch (this.points) {
            case 1:
                art[1] = art[3] = empty;
                art[2] = middle;
                break;
            case 2:
                art[1] = left;
                art[2] = empty;
                art[3] = right;
                break;
            case 3:
                art[1] = left;
                art[2] = middle;
                art[3] = right;
                break;
            case 4:
                art[1] = art[3] = both;
                art[2] = empty;
                break;
            case 5:
                art[1] = art[3] = both;
                art[2] = middle;
                break;
            case 6:
                art[1] = art[2] = art[3] = both;
                break;
        }

        return art;
    }
	
	
}
