/**
 * VierGewinnt.java
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

import java.util.Arrays;


public class VierGewinnt
{

	public static final int COLS = 7;
	public static final int ROWS = 6;

	private Token[][] board = new Token[ COLS ][ ROWS ]; // 7 columns with 6 fields each
	private Player[] players = new Player[ 2 ]; // two players

	/** initialize board and players and start the game */
	public void play()
	{
		// initialize the board
		for ( Token[] column : this.board ) {
			Arrays.fill( column, Token.empty );
		}

		/* initialize players */
		players[ 0 ] = new Player();
		players[ 1 ] = new Player();
		players[ 0 ].setToken( Token.player1 );
		players[ 1 ].setToken( Token.player2 );

		/* play... */
		boolean solved = false;
		int currentPlayer = ( new java.util.Random() ).nextInt( 2 );  //choose randomly who begins
		System.out.println( "current player: " + currentPlayer );
		
		while ( !solved && !this.isBoardFull() ) {
			// get player's next "move"
			// note that we pass only a copy of the board as an argument,
			// otherwise the player class would be able to manipulate the board and cheat!
			int insertCol = players[ currentPlayer ].getNextColumn( getCopyOfBoard() );
			// insert the token and get the row where it landed
			int insertRow = this.insertToken( insertCol, players[ currentPlayer ].getToken() );
			if ( insertRow == -1 ) {
				System.err.println( "Error. This column is full! The program will terminate" );
				System.exit( 1 );
			}
			// check if the game is over
			solved = this.checkVierGewinnt( insertCol, insertRow );
			//switch to other player
			if ( !solved )
				currentPlayer = ( currentPlayer + 1 ) % 2;
		}
		System.out.println( displayBoard( this.board ) );
		if ( solved )
			System.out.println( "Player " + players[ currentPlayer ].getToken() + ", " + players[currentPlayer].getPlayersName() + " wins!" );
		else
			System.out.println( "Draw! Game over." );
	}


	/**
	 * Inserts the token at the specified column (if possible)
	 * @param column the column to insert the token
	 * @param token the players token
	 * @return the row where the token landed 
	 */
	private int insertToken(int column, Token tok) {
		// check if the column exists
		// error handling seems unnecessary, but is asked for in the exercise
		// error handling is allready done in the provided getNextColumn() method of the Player class

		// check if the column exists
		if (column < 0 || column >= this.board.length) {
			System.err.println("Error. This column doesn't exist. The programm will terminate");
			System.exit(1);
		}

		for (int row = 0; row < this.board[column].length; row++ ) {
			if (this.board[column][row] == Token.empty ) {
				board[column][row] = tok;
				return row;
			}
		} return -1; // indicates that the column is full
		
	}


	/**
	 * Checks if every position is occupied 
	 * @returns true, iff the board is full.
	 */
	private boolean isBoardFull() {

		for (int col = 0; col < this.board.length; col++ ) {
			for (int row = 0; row < this.board[col].length; row++ ) {
				if (this.board[col][row] == Token.empty ) {
					return false;
				}
			}
		}
		return true;

	}


	/**
	 * Checks for at least four equal tokens in a row in
	 * either direction, starting from the given position. 
	 */
	private boolean checkVierGewinnt( int col, int row ) {
		if (!isOnBoard(col, row)) {
			System.out.println("The coordinate is not on the board");
			System.out.println("Check with coordinates " + col + row + " failed");
			return false;
		} else {
			return checkHorizontally(col, row) || checkVertically(col, row) || checkDiagonallyBottomLeftToTopRight(col, row) || checkDiagonallyBottomRightToTopLeft(col, row);
		}
	}


	/** Returns a (deep) copy of the board array */
	private Token[][] getCopyOfBoard()
	{
		Token[][] copiedBoard = new Token[ COLS ][ ROWS ];
		for ( int i = 0; i < copiedBoard.length; i++ ) {
			for ( int j = 0; j < copiedBoard[ i ].length; j++ ) {
				copiedBoard[ i ][ j ] = this.board[ i ][ j ];
			}
		}
		return copiedBoard;
	}


	/** returns a graphical representation of the board */
	public static String displayBoard( Token[][] myBoard )
	{
		String rowDelimiter = "+";
		String rowNumbering = " ";
		for ( int col = 0; col < myBoard.length; col++ ) {
			rowDelimiter += "---+";
			rowNumbering += " " + ( col + 1 ) + "  ";
		}
		rowDelimiter += "\n";

		String rowStr;
		String presentation = rowDelimiter;
		for ( int row = myBoard[ 0 ].length - 1; row >= 0; row-- ) {
			rowStr = "| ";
			for ( int col = 0; col < myBoard.length; col++ ) {
				rowStr += myBoard[ col ][ row ].toString() + " | ";
			}
			presentation += rowStr + "\n" + rowDelimiter;
		}
		presentation += rowNumbering;
		return presentation;
	}



	/** main method, starts the program */
	public static void main( String args[] )
	{
		VierGewinnt game = new VierGewinnt();
		game.play();
	}

	// Method to check if the coordinate is on the board
	private boolean isOnBoard(int col, int row) {
		return (col >= 0 && col < COLS && row >= 0 && row < ROWS);
	}


	private boolean checkHorizontally(int col, int row) {
		int count = 0;
		for (int i = 0; i < this.board.length; i++) {
			if (this.board[i][row] == this.board[col][row]) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
		} return false;
	}

	private boolean checkVertically(int col, int row) {
			
			// Check for four in a row vertically
			int count = 0;
			for (int i = 0; i < this.board[col].length; i++) {
				if (this.board[col][i] == this.board[col][row]) {
					count++;
					if (count == 4) {
						return true;
					}
				} else {
					count = 0;
				}
			}
			return false;
	}

	private boolean checkDiagonallyBottomLeftToTopRight(int col, int row) {

		// Check for four in a row diagonally (bottom left to top right)
		int count = 0;
		int colIndex = col;
		int rowIndex = row;

		// Move to the bottom-most position of the diagonal
		while (isOnBoard(colIndex - 1, rowIndex - 1)) {
			colIndex--;
			rowIndex--;
		}

		// Now check for four in a row
		while (isOnBoard(colIndex, rowIndex)) {
			if (this.board[colIndex][rowIndex] == this.board[col][row]) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
			colIndex++;
			rowIndex++;
		} return false;

	}

	private boolean checkDiagonallyBottomRightToTopLeft(int col, int row) {
	
		// Check for four in a row diagonally (bottom right to top left)
		int count = 0;
		int colIndex = col;
		int rowIndex = row;

		// Move to the bottom-most position of the diagonal
		while (isOnBoard(colIndex + 1, rowIndex - 1)) {
			colIndex++;
			rowIndex--;
		}

		// Now check for four in a row
		while (isOnBoard(colIndex, rowIndex)) {
			if (this.board[colIndex][rowIndex] == this.board[col][row]) {
				count++;
				if (count == 4) {
					return true;
				}
			} else {
				count = 0;
			}
			colIndex--;
			rowIndex++;
		} 

		return false; // No four in a row found
	}
}
