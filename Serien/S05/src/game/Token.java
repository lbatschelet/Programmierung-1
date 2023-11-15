/**
 * Token.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-15
 * @version 1.0
 * @serie   5
 * @aufgabe 1
 * 
 * 1. Programmierung eines "Vier gewinnt" Spiels für die Konsole gegen eine zweite Person. 
 *    Die Dateien VierGewinnt.java, Player.java und Token.java sollen von ILIAS heruntergeladen werden. 
 *    In VierGewinnt.java sind bereits die Methoden play() (Spielablauf), main (Spielstart) und 
 *    displayField() (graphische Darstellung des Spielfelds) enthalten:
 *    
 *    Beispiel-Ausgabe:
 *    1
 *    Player X choose a column between 1 and 7: 2
 *    +---+---+---+---+---+---+---+
 *    |   |   |   |   |   |   |   |
 *    +---+---+---+---+---+---+---+
 *    |   |   |   |   |   |   |   |
 *    +---+---+---+---+---+---+---+
 *    | X |   |   |   |   |   |   |
 *    +---+---+---+---+---+---+---+
 *    | O | X | O |   |   |   |   |
 *    +---+---+---+---+---+---+---+
 *    | X | O | X |   |   |   | X |
 *    +---+---+---+---+---+---+---+
 *    | O | O | O | X | X |   | O |
 *    +---+---+---+---+---+---+---+
 *      1   2   3   4   5   6   7
 *    Player X wins!
 *
 * 2. Notwendige Methoden für die Implementierung in der Klasse VierGewinnt:
 * 	  1. insertToken: Fügt einen Stein (Token-Objekt) in die gewählte Spalte (column) des Spielfelds (Array[][] board) ein. 
 *         Bei einer nicht existierenden oder vollständig gefüllten Spalte soll das Programm mit einer Fehlermeldung enden (System.exit(1)).
 * 	  2. isBoardFull: Gibt true zurück, wenn alle Felder mit einem Stein besetzt sind.
 * 	  3. checkVierGewinnt: Überprüft, ob ab dem Feld, das durch col und row gegeben ist, in einer der vier Richtungen (–, |, /, \\) 
 *         mindestens vier gleiche Steine liegen. Bei Erfüllung dieser Bedingung wird true zurückgegeben, sonst false. 
 *         Tipp: Verwendung von Hilfsmethoden für jede Richtung wird empfohlen.
 */

package game;

/**
 * Basis enum to provide player tokens
 */
public enum Token {
       empty( " " ),
       player1( "O" ),
       player2( "X" );
       private String representation; // string representation of value
       Token( String s ) { this.representation = s; }
       public String toString() { return this.representation; }
}