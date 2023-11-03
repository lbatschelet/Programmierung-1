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

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");
    private Player playerToPlay;

    private final int POINTS_TO_WIN = 100;
    private PairOfDice pairOfDice = new PairOfDice();

    // Computer will roll until it has at least 20 points
    private final int MAX_COMPUTER_POINTS = 20;

    public PigGame() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.pairOfDice = new PairOfDice();
    }

    /**
     * Starts the game and asks for the game mode
     */
    public void start() {

        printTitle();
        printRules();
        System.out.println("---------------");
        System.out.println("1. Singleplayer");
        System.out.println("2. Multiplayer");
        System.out.println("3. Exit");
        System.out.println("---------------");

        // Ask for game mode
        System.out.print("Choose mode: ");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        switch (mode) {
            case 1:
                this.player1.enterName();
                this.player2.setName("Computer");
                this.player2.setComputer(true);
                this.playerToPlay = this.player1;
                System.out.println("You are playing against the computer.");
                System.out.println("The computer will allways roll until it has at least " + MAX_COMPUTER_POINTS + " points.");
                play();
                break;
            case 2:
                this.player1.enterName();
                this.player2.enterName();
                this.playerToPlay = this.player1;
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
    private void play() {
        while (!this.player1.hasWon(POINTS_TO_WIN) && !this.player2.hasWon(POINTS_TO_WIN)) {
            this.player1.printPoints();
            this.player2.printPoints();
            System.out.println(this.playerToPlay.getName() + " is playing.");
            System.out.println("Press enter to roll the dice.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            turn(playerToPlay.isComputer());
            changePlayerToPlay();
        }
        endOfGame();
    }

    private void turn(boolean isComputer) {
        boolean turnOver = false;
        while (!turnOver) {

            // rolls the dices and returns true if either the roll has a 1 in it or the player chooses to end their turn.
            turnOver = roll(); 
    
            if (this.playerToPlay.hasWon(POINTS_TO_WIN)) {
                turnOver = true;
            }
    
            if (!turnOver) {
                if (isComputer) {
                    // Logic for a computer player
                    if (this.playerToPlay.getPointsThisRound() >= MAX_COMPUTER_POINTS) {
                        this.playerToPlay.addPointsTotal(this.playerToPlay.getPointsThisRound());
                        this.playerToPlay.removePointsThisRound();
                        turnOver = true;
                    }
                } else {
                    // Logic for a human player
                    System.out.println("Do you want to roll the Dice again? (y/n): ");
                    Scanner scanner = new Scanner(System.in);
                    String another = scanner.next();
                    if ("n".equalsIgnoreCase(another)) {
                        this.playerToPlay.addPointsTotal(this.playerToPlay.getPointsThisRound());
                        this.playerToPlay.removePointsThisRound();
                    }
                    turnOver = "n".equalsIgnoreCase(another);
                }
            }
        }
    }
    
    private boolean roll() {
        this.pairOfDice.rollThePair();
        this.pairOfDice.printDicePair();
        playerToPlay.addDiceRoll();
        
        if (this.pairOfDice.isDouble1()) {
            System.out.println(this.playerToPlay.getName() + " lost all their points, because they rolled a double 1.");
            this.playerToPlay.resetPoints();
            return true;
        } else if (this.pairOfDice.isSingle1()) {
            System.out.println(this.playerToPlay.getName() + " lost " + this.playerToPlay.getPointsThisRound() + " points they had this round, because they rolled a 1.");
            this.playerToPlay.removePointsThisRound();
            return true; 
        } else {
            this.playerToPlay.addPointsThisRound(this.pairOfDice.getSum());
            System.out.println(this.playerToPlay.getName() + " has " + this.playerToPlay.getPointsThisRound() + " points on the line.");
            if (this.playerToPlay.getPointsTotal() > 0) {
                System.out.println("That would be " + (this.playerToPlay.intermediatePoints()) + " points in total.");
            }
            return false;
        }
    }

    private void changePlayerToPlay() {
        if (this.playerToPlay == this.player1) {
            this.playerToPlay = this.player2;
        } else {
            this.playerToPlay = this.player1;
        }
    }

    /**
     * End of game
     * Prints the winner and asks if the players want to play again
     */
    private void endOfGame() {
        System.out.println("\n");
        System.out.println("\n");
        if (this.player2.isComputer() && this.player2.hasWon(POINTS_TO_WIN)) {
            printGameOver();
        } else {
            printCongratulation();
        }
        System.out.println("----------");
        System.out.println(this.player1.getName() + " has " + this.player1.intermediatePoints() + " points.");
        System.out.println(this.player2.getName() + " has " + this.player2.intermediatePoints() + " points.");
        System.out.println((this.player1.hasWon(POINTS_TO_WIN) ? this.player1.getName() : this.player2.getName()) + " has won!");
        System.out.println("It took them " + (this.player1.hasWon(POINTS_TO_WIN) ? this.player1.getDiceRolls() : this.player2.getDiceRolls()) + " rolls.");
        System.out.println("----------");
        System.out.println("Do you want to play again? (y/n): ");
        Scanner scanner = new Scanner(System.in);
        String another = scanner.next();
        if ("y".equalsIgnoreCase(another)) {
            this.player1.reset("Player 1");
            this.player2.reset("Player 2");
            start();
        } else {
            System.exit(0);
        }
    }

    /**
     * Bigger blocks of text to print
     * Just to simplyfy the code
     */

    private void printRules() {
        System.out.println("# This is a luck based game where you roll a pair of dice.");
        System.out.println("# The goal is to reach " + POINTS_TO_WIN + " points.");
        System.out.println("# If you roll a 1, you lose all points for this round, and your turn is over.");
        System.out.println("# If you roll two 1s, you lose all points you gathered so far, and your turn is over.");
        System.out.println("# After each roll you can decide to roll again or end your turn.");
        System.out.println("# If you end your turn, the points for this round are added to your total points.");
        System.out.println("# Good luck!");
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

    private void printCongratulation() {
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

    private void printGameOver() {
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


}

