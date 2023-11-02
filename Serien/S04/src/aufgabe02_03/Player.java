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

public class Player {

    private int pointsThisRound;
    private int pointsTotal;
    private String name;
    private boolean isComputer;

    public Player(String name) {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
        this.name = name;
        this.isComputer = false;
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

    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * setters
     */

    public void setPointsThisRound(int points) {
        this.pointsThisRound = points;
    }

    public void setPointsTotal(int points) {
        this.pointsTotal = points;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }

    /**
     * other methods
     */

    public void addPointsThisRound(int points) {
        this.pointsThisRound += points;
    }

    public void removePointsThisRound() {
        this.pointsThisRound = 0;
    }

    public void addPointsTotal(int points) {
        this.pointsTotal += points;
    }

    public void removePointsTotal() {
        this.pointsTotal = 0;
    }

    public String toString() {
        return this.name + " has " + this.pointsTotal + " points.";
    }

    public void printPoints() {
        System.out.println(this.toString());
    }

    public boolean hasWon(int pointsToWin) {
        return (this.pointsTotal + this.pointsThisRound) >= pointsToWin;
    }

    public void resetPoints() {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
    }


}
