/**
 * Player.java
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

import java.util.Scanner;

/** A human player class */
public class Player
{
	private Scanner scan = new Scanner( System.in );
	private Token token;
	private String playersName;
	private static int humanCounts = 0;

	public Player()
	{
		humanCounts++;
		System.out.println( "Hi, what is your name, (" + humanCounts + ")-th human player?" );
		playersName = scan.nextLine();
		if ( 0 == playersName.length() ) {
			playersName = "Human Player No " + humanCounts;
		}
	}

	public int getNextColumn( Token[][] board )
	{
		System.out.println( "\n" + VierGewinnt.displayBoard( board ) );
		int column = -1;
		while ( column < 0 || column >= board.length ) {
			System.out.print( "Player " + this.token.toString()
			                  + " " + this.getPlayersName()
							  + " choose a column between 1 and " + board.length + ": " );
			try {
				column = Integer.parseInt( scan.nextLine() ) - 1;
			} catch ( NumberFormatException e ) {
				column = -1;
				System.out.println( "That is not even a number!" );
			}
			if ( column >= 0 && column < board.length ) {
				if ( isColFull( column, board ) ) {
					System.out.println( "This column is full!" );
					column = -1;
				}
			}
		}
		return column;
	}

	/** returns true if the column col is already full and false otherwise. */
	private boolean isColFull( int col, Token[][] board )
	{
		int topRow = board[ 0 ].length - 1;
		if ( board[ col ][ topRow ] != Token.empty ) {
			return true;
		} else {
			return false;
		}
	}

	public void setToken( Token token )
	{
		this.token = token;
	}
	public Token getToken()
	{
		return this.token;
	}

	public String getPlayersName()
	{
		return playersName;
	}
}
