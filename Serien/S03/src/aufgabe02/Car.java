/**
 * Car.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 2
 * 
 * Programmieren Sie eine Klasse `Car`, welche die Marke, das Modell und den Jahrgang des Fahrzeuges modelliert. 
 * Der Konstruktor soll diese drei Instanzvariablen gemäss Parameterübergabe initialisieren.
 * Schreiben Sie Getter und Setter für alle Instanzvariablen und eine `toString` Methode für eine einzeilige Repräsentation 
 * von `Car` Objekten. 
 * Schliesslich definieren Sie eine Methode `isAntique`, welche einen `boolean` zurückgibt, der anzeigt, 
 * ob das Auto aktuell älter ist als 45 Jahre. 
 * 
 * In einer zweiten Klasse `Garage` instanziieren Sie drei `Car` Objekte und testen alle programmierten Methoden.
 */


package aufgabe02;

import java.time.LocalDate;

public class Car {
    
    private String brand;
    private String model;
    private int year;
    private boolean isAntique;
    private final int ANTIQUE_AGE = 45;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isAntique = checkIfAntique();
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public boolean getIsAntique() {
        return this.isAntique;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model= model;
    }

    public void setYear(int year) {
        this.year = year;
        this.isAntique = checkIfAntique();
    }

    private boolean checkIfAntique() {
        int currentYear = LocalDate.now().getYear();
        if (currentYear - this.year > ANTIQUE_AGE) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAntique() {
        return this.isAntique;
    }

    public String toString() {
        return this.brand + " " + this.model + " " + this.year + " Is Antique: " + this.isAntique;
    }

}
