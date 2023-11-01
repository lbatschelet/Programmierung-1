/**
 * PairOfDice.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-30
 * @version 1.0
 * @serie   4
 * @aufgabe 2
 * 
 * Übernehmen Sie die Klasse `Dice` aus dem Skript. 
 * Schreiben Sie dann eine Klasse `PairOfDice`, welche aus zwei `Dice` Objekten besteht.
 * Definieren Sie Methoden zum Setzen und Auslesen der Punkte der einzelnen Würfel,
 * eine Methode um beide Würfel zu werfen,
 * und eine Methode, welche die aktuelle Summe der Würfel zurückgibt.
 */

package aufgabe02_03;

public class PairOfDice {



    public Dice dice1;
    public Dice dice2;

    public PairOfDice() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    public void setDice1(int points) {
        this.dice1.setPoints(points);
    }

    public void setDice2(int points) {
        this.dice2.setPoints(points);
    }

    public int getDice1() {
        return this.dice1.getPoints();
    }

    public int getDice2() {
        return this.dice2.getPoints();
    }

    public int getSum() {
        return this.getDice1() + this.getDice2();
    }

    public int rollThePair() {
        this.dice1.roll();
        this.dice2.roll();
        return this.getSum();
    }
}
