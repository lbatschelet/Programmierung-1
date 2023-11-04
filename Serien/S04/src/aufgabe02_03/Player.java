/**
 * Player.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-01
 * @version 2.0
 * @serie   4
 * @aufgabe 3
 * 
 * Class to represent a player in the game Pig.
 * @mainclass Pig.java
 * 
 */

 package aufgabe02_03;

import java.util.Scanner;

public class Player {

    private static final Scanner scanner = new Scanner(System.in);

    private int pointsThisRound;
    private int pointsTotal;
    private String name;
    private boolean isComputer;
    private int diceRolls;

    public Player(String name) {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
        this.name = name;
        this.isComputer = false;
        this.diceRolls = 0;
    }

    /**
     * getters
     */

    public String getName() {
        return this.name;
    }

    public int getPointsThisRound() {
        return this.pointsThisRound;
    }

    public int getPointsTotal() {
        return this.pointsTotal;
    }

    public boolean isComputer() {
        return this.isComputer;
    }

    public int getDiceRolls() {
        return this.diceRolls;
    }

    /**
     * setters
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public void enterName() {
        System.out.print("Enter new name for " + getName() + ": ");
        String name = scanner.nextLine();
        setName(name);
        
    }

    public void setPointsThisRound(int points) {
        this.pointsThisRound = points;
    }

    public void setPointsTotal(int points) {
        this.pointsTotal = points;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }

    public void setDiceRolls(int diceRolls) {
        this.diceRolls = diceRolls;
    }
    
    /**
     * Adders and removers for points.
     */

    public void addPointsThisRound(int points) {
        this.pointsThisRound += points;
    }

    public void addPointsTotal(int points) {
        this.pointsTotal += points;
    }

    public void addDiceRoll() {
        this.diceRolls++;
    }

    public void removePointsThisRound() {
        this.pointsThisRound = 0;
    }

    public void removePointsTotal() {
        this.pointsTotal = 0;
    }

    public void resetPoints() {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
    }

    // Reset the player's points and name after a round, to start fresh into a new one.
    public void reset(String name) {
        this.resetPoints();
        this.name = name;
        this.isComputer = false;
        this.diceRolls = 0;
    }

    /**
     * other methods
     */
    public String toString() {
        return this.name + " has " + this.pointsTotal + " points.";
    }

    public void printPoints() {
        System.out.println(this.toString());
    }

    public int intermediatePoints() {
        return this.pointsTotal + this.pointsThisRound;
    }

    /**
     * Check if the player has won the game.
     * Intermediate points to safe a player from stupid decisions.
     * (i.e. if the player has 95 points and rolls a 6, they would have 101 Points,
     * if they would roll again they could loose all their points)
     * @param pointsToWin
     * @return
     */
    public boolean hasWon(int pointsToWin) {
        return (this.intermediatePoints()) >= pointsToWin;
    }






}
