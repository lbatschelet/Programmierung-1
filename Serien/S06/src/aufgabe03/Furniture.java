/**
 * Furniture.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-22
 * @version 1.0
 * @serie   6
 * @aufgabe 3
 * 
 * Sie sollen für eine Firma, welche Möbel herstellt, ein System entwickeln.
 * Die Firma will sehen, ob sich dieses System bewährt, deshalb soll zunächst
 * nur die Preisberechnung für die Tische implementiert werden. Falls die Firmenleitung
 * zufrieden ist, sollen mehr Möbelstücke und mehr Funktionalitäten integriert werden.
 * Implementieren Sie für dieses System Furniture.java, Material.java und Table.java
 * nach dem folgenden UML-Diagramm (FurnitureTest.java ist auf Ilias verfügbar):
 * 
 * Anweisungen:
 * (a) Die Klassen sollen nach diesem UML-Diagramm implementiert werden
 * ohne zusätzliche Variablen oder Methoden zu verwenden.
 * (b) Vergeben Sie jedem Objekt in der Aufzählung einen anderen Preis
 * pro Quadratmeter (speichern Sie diese Information in einer Instanzvariablen)
 * (c) Erstellen Sie einen passenden Konstruktor für Furniture und Table.
 * Der Konstruktor von Table soll dabei den Konstruktor von Furniture
 * verwenden.
 * (d) Die Variable pricePerHour gibt die Kosten pro Stunde an für die
 * Anfertigung des Möbelstückes. workedHours gibt die Anzahl Stunden
 * an, welche nötig waren, um das Möbelstück fertigzustellen. Die
 * Methode calculateEffort() soll nun den Aufwand für die Herstellung
 * eines Möbelstückes berechnen.
 * (e) Da in der Aufwandsberechnung noch nicht der Materialpreis inbegriffen
 * ist, soll in der Methode totalPrice() zunächst mithilfe der Methode
 * aus Furniture den Preis für den Aufwand berechnet werden.
 * Danach wird der Materialpreis berechnet (gegeben durch multipliziert
 * mit dem Quadratmeterpreis des Materials) und zum Aufwand
 * dazu addiert.
 */


 package aufgabe03;

public abstract class Furniture {
    public Material material;
    protected double pricePerHour;
    protected double workedHours;

    public Furniture(Material material, double pricePerHour, double workedHours) {
        this.material = material;
        this.pricePerHour = pricePerHour;
        this.workedHours = workedHours;
    }

    public double calculateEffort() {
        return this.workedHours * this.pricePerHour;
    }
}
