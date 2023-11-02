/**
 * PigGame.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-01
 * @version 2.0
 * @serie   4
 * @aufgabe 3
 * 
 * Class to represent a game of Pig.
 * @mainclass Pig.java
 */


package aufgabe02_03;

import java.util.Scanner;



public class PigGame {

    public static Player player1 = new Player("Player 1");
    public static Player player2 = new Player("Player 2");
    public static Player playerToPlay;

    public final int POINTS_TO_WIN = 100;
    public static PairOfDice pairOfDice = new PairOfDice();

    // Computer will roll until it has at least 20 points
    public final int MAX_COMPUTER_POINTS = 20;

    public PigGame() {
        PigGame.player1 = new Player("Player 1");
        PigGame.player2 = new Player("Player 2");
        PigGame.pairOfDice = new PairOfDice();
    }

    
    public void start() {

        printTitle();
        printRules();
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
                System.out.println("You are playing against the computer.");
                System.out.println("The computer will allways roll until it has at least " + MAX_COMPUTER_POINTS + " points.");
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

    /**
     * Main loop to controll the flow of the game
     * Starts rounds and checks if a player has won
     */

    public void play() {
        while (!player1.hasWon(POINTS_TO_WIN) && !player2.hasWon(POINTS_TO_WIN)) {
            player1.printPoints();
            player2.printPoints();
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

            turnOver = roll();

            if (playerToPlay.hasWon(POINTS_TO_WIN)) {
                turnOver = true;
            }

        

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

            turnOver = roll();

            if (playerToPlay.hasWon(POINTS_TO_WIN)) {
                turnOver = true;
            }

            if (!turnOver && !playerToPlay.hasWon(POINTS_TO_WIN)) {
                if (playerToPlay.getPointsThisRound() >= MAX_COMPUTER_POINTS) {
                    playerToPlay.addPointsTotal(playerToPlay.getPointsThisRound());
                    playerToPlay.removePointsThisRound();
                    turnOver = true;
                }
            }
        }
    }

    public boolean roll() {
        pairOfDice.rollThePair();
        pairOfDice.printDicePair();
        
        if (pairOfDice.isDouble1()) {
            System.out.println(playerToPlay.getName() + " lost all their points");
            playerToPlay.resetPoints();
            return true;
        } else if (pairOfDice.isSingle1()) {
            System.out.println(playerToPlay.getName() + " lost " + playerToPlay.getPointsThisRound() + " points they had this round");
            playerToPlay.removePointsThisRound();
            return true; 
        } else {
            playerToPlay.addPointsThisRound(pairOfDice.getSum());
            System.out.println(playerToPlay.getName() + " has " + playerToPlay.getPointsThisRound() + " points on the line.");
            if (playerToPlay.getPointsTotal() > 0) {
                System.out.println("That would be " + (playerToPlay.intermediatePoints()) + " points in total.");
            }
            return false;
        }
    }



    public void endOfGame() {
        System.out.println("\n");
        System.out.println("\n");
        if (player2.isComputer() && player2.hasWon(POINTS_TO_WIN)) {
            printGameOver();
        } else {
            printCongratulation();
        }
        System.out.println("----------");
        System.out.println(player1.getName() + " has " + player1.intermediatePoints() + " points.");
        System.out.println(player2.getName() + " has " + player2.intermediatePoints() + " points.");
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
            player1.reset("Player 1");
            player2.reset("Player 2");
            start();
        } else {
            System.exit(0);
        }
    }

    private void printTitle() {
        System.out.println("\n");
        System.out.println("######################################################");
        System.out.println("#                                                    #");
        System.out.println("#       ____  _          ______                      #");
        System.out.println("#      / __ \\(_)___ _   / ____/___ _____ ___  ___    #");
        System.out.println("#     / /_/ / / __ `/  / / __/ __ `/ __ `__ \\/ _ \\   #");
        System.out.println("#    / ____/ / /_/ /  / /_/ / /_/ / / / / / /  __/   #");
        System.out.println("#   /_/   /_/\\__, /   \\____/\\__,_/_/ /_/ /_/\\___/    #");
        System.out.println("#           /____/                                   #");
        System.out.println("#                                                    #");
        System.out.println("######################################################");
        System.out.println("\n");
    }

    public void printCongratulation() {
        System.out.println("\n");
        System.out.println("#############################################################################################");
        System.out.println("#                                                                                           #");
        System.out.println("#      ______                             __        __      __  _                  ______   #");
        System.out.println("#     / ____/___  ____  ____ __________ _/ /___  __/ /___ _/ /_(_)___  ____  _____/ / / /   #");
        System.out.println("#    / /   / __ \\/ __ \\/ __ `/ ___/ __ `/ __/ / / / / __ `/ __/ / __ \\/ __ \\/ ___/ / / /    #");
        System.out.println("#   / /___/ /_/ / / / / /_/ / /  / /_/ / /_/ /_/ / / /_/ / /_/ / /_/ / / / (__  )_/_/_/     #");
        System.out.println("#   \\____/\\____/_/ /_/\\__, /_/   \\__,_/\\__/\\__,_/_/\\__,_/\\__/_/\\____/_/ /_/____(_|_|_)      #");
        System.out.println("#                    /____/                                                                 #");
        System.out.println("#                                                                                           #");
        System.out.println("#############################################################################################");
        System.out.println("\n");
    }

    public void printGameOver() {
        System.out.println("\n");
        System.out.println("################################################################");
        System.out.println("#      ______                                             __   #");
        System.out.println("#     / ____/___ _____ ___  ___     ____ _   _____  _____/ /   #");
        System.out.println("#    / / __/ __ `/ __ `__ \\/ _ \\   / __ \\ | / / _ \\/ ___/ /    #");
        System.out.println("#   / /_/ / /_/ / / / / / /  __/  / /_/ / |/ /  __/ /  /_/     #");
        System.out.println("#   \\____/\\__,_/_/ /_/ /_/\\___/   \\____/|___/\\___/_/  (_)      #");
        System.out.println("#                                                              #");
        System.out.println("################################################################");
        System.out.println("\n");
    }

    public void printRules() {
        System.out.println("# This is a luck based game where you roll a pair of dice.");
        System.out.println("# The goal is to reach " + POINTS_TO_WIN + " points.");
        System.out.println("# If you roll a 1, you lose all points for this round, and your turn is over.                                         #");
        System.out.println("# If you roll two 1s, you lose all points you gathered so far, and your turn is over.");
        System.out.println("# After each roll you can decide to roll again or end your turn.");
        System.out.println("# If you end your turn, the points for this round are added to your total points.");
        System.out.println("# Good luck!");


    }


}

