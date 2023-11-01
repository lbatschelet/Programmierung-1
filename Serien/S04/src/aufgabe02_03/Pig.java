/**
 *  Pig.java
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
 */


package aufgabe02_03;

import java.util.Scanner;

public class Pig {

    public static void main(String[] args) {
        
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        PairOfDice pairOfDice = new PairOfDice();

        final int POINTS_TO_WIN = 100;
        int points = 0;
        int rounds = 1;
        int mode = 0;
        int playerToPlay = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Pig!");
        System.out.println("The first player to reach " + POINTS_TO_WIN + " points wins!");

        // Mode selection
        System.out.println("Enter 1 to play against the computer, or 2 to play against another player");
        mode = scan.nextInt();
        while (mode != 1 && mode != 2) {
            System.out.println("Invalid input. Enter 1 to play against the computer, or 2 to play against another player");
            mode = scan.nextInt();
        }
        
        // Player name selection
        System.out.println("Enter the name of player 1");
        player1.setName(scan.next());

        if (mode == 2) {
            System.out.println("Enter the name of player 2");
            player2.setName(scan.next());
        }

        // Game loop
        while (player1.getPointsTotal() < POINTS_TO_WIN && player2.getPointsTotal() < POINTS_TO_WIN) {




        }
        // After the game
        if (player1.getPoints() >= POINTS_TO_WIN) {
            System.out.println(player1.getName() + " won!");
        } else {
            System.out.println(player2.getName() + " won!");
        }

            


    }


}
