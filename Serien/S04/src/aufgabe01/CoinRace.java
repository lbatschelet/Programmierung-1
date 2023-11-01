/**
 * CoinRace.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-30
 * @version 1.0
 * @serie   4
 * @aufgabe 1
 * 
 * Programmieren Sie eine Klasse `Coin`, die eine Münze repräsentieren soll. 
 * Eine Münze zeigt entweder Kopf oder Zahl an (speichern Sie diese Information als Variable vom Typ `boolean`).
 * 
 * Der Konstruktor der Klasse `Coin` soll eine Münze zufällig instanziieren – 
 * also mit 50% Wahrscheinlichkeit soll eine neu instanziierte Münze Kopf zeigen (und sonst Zahl). 
 * Programmieren Sie hierzu eine Methode `flip`, die den Münzwurf simuliert.
 * Ergänzen Sie Ihre Klasse mit einer Methode `equals` und einer Methode `toString`.
 * Zwei Münzen sind gleich, wenn beide die gleiche Seite anzeigen.
 * Die Methode `toString` soll Kopf oder Zahl zurückgeben – verwenden Sie hierzu einen Conditional Operator.
 *
 * Programmieren Sie ein Programm `CoinRace`: 
 * Dieses Programm soll zwei `Coin` Objekte solange werfen, bis einer der beiden Münzen dreimal hintereinander Kopf angezeigt hat 
 * (Zählen Sie die Runden mit). Diese Münze gewinnt das Spiel.
 * 
 * Geben Sie das Resultat aller Münzwürfe aus und am Schluss geben Sie an, welche der beiden Münzen gewonnen hat aus.
 * Also bspw:
 * 
 * Runde 1: Zahl Zahl
 * Runde 2: Kopf Zahl
 * Runde 3: Kopf Kopf
 * Runde 4: Kopf Kopf
 * Münze 1 gewinnt
 * 
 * Hinweis: Es kann auch Unentschieden geben!
 */package aufgabe01;

public class CoinRace {
    
    public static void main(String[] args) {
            
            Coin coin1 = new Coin();
            Coin coin2 = new Coin();
            int round = 1;
            int coin1Heads = 0;
            int coin2Heads = 0;
            
            while (coin1Heads < 3 && coin2Heads < 3) {
                coin1.flip();
                coin2.flip();
                System.out.println("Runde " + round + ": " + coin1 + " " + coin2);
                if (coin1.isHeads) {
                    coin1Heads++;
                } else {
                    coin1Heads = 0;
                }
                if (coin2.isHeads) {
                    coin2Heads++;
                } else {
                    coin2Heads = 0;
                }
                round++;
            }
            if (coin1Heads == 3) {
                System.out.println("\nMünze 1 gewinnt nach " + (round - 1) + " Runden");
            } else {
                System.out.println("\nMünze 2 gewinnt nach " + (round - 1) + " Runden");
            }
    }
}
