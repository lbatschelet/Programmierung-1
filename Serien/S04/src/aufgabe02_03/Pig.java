/**
 * Pig.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-01
 * @version 2.0
 * @serie   4
 * @aufgabe 3
 * 
 * Implementiert das Spiel Pig.
 * 
 * In diesem Spiel ist das Ziel, als erster Spieler 100 Punkte zu erreichen.
 * Ein Spieler würfelt innerhalb eines Zuges so oft er möchte mit zwei Würfeln (verwende dazu die Klasse PairOfDice aus Aufgabe 2).
 * Die Punkte werden addiert, solange keine der folgenden Bedingungen erfüllt ist:
 * 
 * 1. Wird eine EINS gewürfelt, endet der Zug des Spielers, und alle Punkte dieses Zuges gehen verloren.
 * 2. Wirft der Spieler zwei EINSEN, verliert er alle bisher gesammelten Punkte und sein Zug endet.
 * 
 * Ein Spieler muss nach jedem Wurf entscheiden:
 * - Weiter würfeln und riskieren, die Punkte des Zuges oder alle Punkte zu verlieren
 * - Den Zug beenden und die Punkte dem eigenen Konto gutschreiben
 * 
 * Modi:
 * - Einspielermodus: Der Spieler spielt gegen den Rechner, der solange würfelt, bis er eine Summe von mindestens 20 erreicht hat.
 * - Zweispielermodus: Spieler gegen Spieler.
 * 
 * Zugehörige Klassen:
 * - PigGame.java
 * - Player.java
 * - PairOfDice.java
 * - Dice.java
 */

package aufgabe02_03;

public class Pig {
    
    public static void main(String[] args) {
        
        PigGame game = new PigGame();

        game.start();

    }
}
