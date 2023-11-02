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



public class PigGame {

    public static Player player1 = new Player("Player 1");
    public static Player player2 = new Player("Player 2");
    public static Player playerToPlay;

    public final int POINTS_TO_WIN = 100;
    public static PairOfDice pairOfDice = new PairOfDice();

    public final int MAX_COMPUTER_POINTS = 20;

    public PigGame() {
        PigGame.player1 = new Player("Player 1");
        PigGame.player2 = new Player("Player 2");
        PigGame.pairOfDice = new PairOfDice();
    }

    public void start() {
        System.out.println("Welcome to Pig!");
        System.out.println("---------------");
        System.out.println("This is a luck based game where you roll a pair of dice.");
        System.out.println("The goal is to reach 100 points.");
        System.out.println("If you roll a 1, you lose all points for this round, and your turn is over.");
        System.out.println("If you roll two 1s, you lose all points you gathered so far, and your turn is over.");
        System.out.println("After each roll you can decide to roll again or end your turn.");
        System.out.println("If you end your turn, the points for this round are added to your total points.");
        System.out.println("Good luck!");
        System.out.println("---------------");
        System.out.println("1. Singleplayer");
        System.out.println("2. Multiplayer");
        System.out.println("3. Exit");
        System.out.println("---------------");
        System.out.print("Choose mode: ");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        switch (mode) {
            case 1:
                enterName(player1);
                player2.setName("Computer");
                player2.setComputer(true);
                playerToPlay = player1;
                play();
                break;
            case 2:
                enterName(player1);
                enterName(player2);
                playerToPlay = player1;
                play();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                start();
                break;
        }
    }

    public void play() {
        while (!player1.hasWon(POINTS_TO_WIN) && !player2.hasWon(POINTS_TO_WIN)) {
            System.out.println(player1.getName() + " has " + player1.getPointsTotal() + " points.");
            System.out.println(player2.getName() + " has " + player2.getPointsTotal() + " points.");
            System.out.println(playerToPlay.getName() + " is playing.");
            System.out.println("Press enter to roll the dice.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            turn();
            changePlayerToPlay();
        }
        endOfGame();
    } 

    public void changePlayerToPlay() {
        if (playerToPlay == player1) {
            playerToPlay = player2;
        } else {
            playerToPlay = player1;
        }
    }

    public void enterName(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name for " + player.getName() + ": ");
        String name = scanner.nextLine();
        player.setName(name);
    }

    public void turn() {
        if (playerToPlay.isComputer()) {
            computerTurn();
        } else {
            playerTurn();
        }
    }

    public void playerTurn() {
        boolean turnOver = false;
        while (!turnOver) {
            turnOver = playerToPlay.rollTheDice(pairOfDice);

            if (!turnOver) {
                System.out.println("Do you want to roll the Dice again? (y/n): ");
                Scanner scanner = new Scanner(System.in);
                String another = scanner.next();
                if ("n".equalsIgnoreCase(another)) {
                    playerToPlay.addPointsTotal(playerToPlay.getPointsThisRound());
                    playerToPlay.removePointsThisRound();
                }
                turnOver = "n".equalsIgnoreCase(another);
                    
            }
        }
    }

    public void computerTurn() {
        boolean turnOver = false;
        while (!turnOver) {
            turnOver = playerToPlay.rollTheDice(pairOfDice);
            if (!turnOver) {
                if (playerToPlay.getPointsThisRound() >= MAX_COMPUTER_POINTS) {
                    playerToPlay.addPointsTotal(playerToPlay.getPointsThisRound());
                    playerToPlay.removePointsThisRound();
                    turnOver = true;
                }
            }
        }
    }



    public void endOfGame() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("                                       .'''.       ");
        System.out.println("        .'''.      .         *''*     :_\\/_:     . ");
        System.out.println("       :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'. ");
        System.out.println("  .'''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=- ");
        System.out.println(" :_\\/_:'.:::.    ' *''*    * '.\\'/.  _\\(/_'.':'.");
        System.out.println(" : /\\ : :::::    *_\\/_*     -= o =-  /)\\    '  *");
        System.out.println("  '..'  ':::'     * /\\ *     .'/\\.   '");
        System.out.println("      *            *..*         :");
        System.out.println("        *");
        System.out.println("        *");
        System.out.println("Game over!");
        System.out.println("----------");
        System.out.println(player1.getName() + " has " + player1.getPointsTotal() + " points.");
        System.out.println(player2.getName() + " has " + player2.getPointsTotal() + " points.");
        if (player1.hasWon(POINTS_TO_WIN)) {
            System.out.println(player1.getName() + " has won!");
        } else {
            System.out.println(player2.getName() + " has won!");
        }
        System.out.println("----------");
        System.out.println("Do you want to play again? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String another = scanner.next();
        if ("y".equalsIgnoreCase(another)) {
            start();
        } else {
            System.exit(0);
        }
    }


}

