/**
 *  Pig_DEPRECEATED.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-01
 * @version 1.0
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

public class Pig_DEPRECEATED {

    public static void main(String[] args) {
        
        PairOfDice pairOfDice = new PairOfDice();

        int pointsPlayer1 = 0;
        int pointsPlayer2 = 0;

        final int MAX_POINTS = 100;

        while (pointsPlayer1 < MAX_POINTS && pointsPlayer2 < MAX_POINTS) {
            System.out.println("Player 1: " + pointsPlayer1 + " points");
            System.out.println("Player 2: " + pointsPlayer2 + " points");
            System.out.println("Player 1's turn");
            int points = 0;
            boolean player1Turn = true;
            boolean player2Turn = false;
            while (player1Turn) {
                pairOfDice.rollThePair();
                System.out.println("Dice 1: " + pairOfDice.getDice1());
                System.out.println("Dice 2: " + pairOfDice.getDice2());
                if (pairOfDice.getDice1() == 1 && pairOfDice.getDice2() == 1) {
                    System.out.println("Player 1 lost all points");
                    System.out.println("\nIt's player 2's turn");
                    pointsPlayer1 = 0;
                    points = 0;
                    player1Turn = false;
                    player2Turn = true;
                } else if (pairOfDice.getDice1() == 1 || pairOfDice.getDice2() == 1) {
                    System.out.println("Player 1 lost " + points + " points");
                    System.out.println("\nIt's player 2's turn");
                    points = 0;
                    player1Turn = false;
                    player2Turn = true;
                } else {
                    points += pairOfDice.getSum();
                    System.out.println("Player 1 has " + points + " points on the line");
                    System.out.println("Do you want to roll again? (y/n)");
                    if (System.console().readLine().equals("n")) {
                        pointsPlayer1 += points;
                        points = 0;
                        System.out.println("\nIt's player 2's turn");
                        player1Turn = false;
                        player2Turn = true;
                    }
                }
            }

            while (player2Turn) {
                pairOfDice.rollThePair();
                System.out.println("Dice 1: " + pairOfDice.getDice1());
                System.out.println("Dice 2: " + pairOfDice.getDice2());
                if (pairOfDice.getDice1() == 1 && pairOfDice.getDice2() == 1) {
                    System.out.println("Player 2 lost all points");
                    System.out.println("\nIt's player 1's turn");
                    pointsPlayer2 = 0;
                    points = 0;
                    player2Turn = false;
                    player1Turn = true;
                } else if (pairOfDice.getDice1() == 1 || pairOfDice.getDice2() == 1) {
                    System.out.println("Player 2 lost " + points + " points");
                    System.out.println("\nIt's player 1's turn");
                    points = 0;
                    player2Turn = false;
                    player1Turn = true;
                } else {
                    points += pairOfDice.getSum();
                    System.out.println("Player 2 has " + points + " points on the line");
                    System.out.println("Do you want to roll again? (y/n)");
                    if (System.console().readLine().equals("n")) {
                        pointsPlayer2 += points;
                        points = 0;
                        System.out.println("\nIt's player 1's turn");
                        player2Turn = false;
                        player1Turn = true;
                    }
                }
            }
        }

        if (pointsPlayer1 >= MAX_POINTS) {
            System.out.println("Player 1 won!");
        } else {
            System.out.println("Player 2 won!");
        }

    }
    
}
