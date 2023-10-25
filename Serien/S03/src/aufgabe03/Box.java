/**
 * Box.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 2
 * 
 * Serie 3
 * Schreiben Sie eine Klasse `Cargo`, welche ein Stückgut mit Länge, Breite, Höhe und einem Namen modelliert 
 * (z.B. 30, 44, 65, "Kaffeemaschine"). Schreiben Sie einen Konstruktor, Getter und Setter für alle 
 * Instanzvariablen und eine Methode `toString`. 
 * 
 * Schreiben Sie eine Klasse Box, die Instanzvariablen für die Länge, Breite und Höhe einer Box enthält.
 * Zusätzlich enthält die Klasse `Box` eine Instanzvariable `full` vom Typ `boolean`, die angibt, ob die Box gefüllt ist
 * oder nicht, sowie eine Instanzvariable `cargo` vom Typ `Cargo`. Der Konstruktor setzt die Länge, Breite und Höhe einer 
 * Box gemäss Parametern – neu instanziierte `Box` Objekte sollen standardmässig leer sein. Definieren Sie einen zweiten 
 * Konstruktor ohne Parameter, der eine Standard-Box mit Länge, Breite und Höhe *1* generiert. Zusätzlich definieren Sie 
 * eine Methode `getCapacity`, die das Volumen der Box berechnet und zurückgibt. Schliesslich schreiben Sie eine Methode 
 * `addCargo`, welche ein Objekt vom Typ `Cargo` als Parameter entgegennimmt. Falls dieses Stückgut gemäss Länge, Breite
 * und Höhe in die Box passt, passen Sie die Variable `full` und die Instanzvariable `cargo` an und geben `true` zurück 
 * (andernfalls `false`).
 * 
 * Testen Sie die Klasse `Box`, indem Sie in einer weiteren Klasse `BoxTest` drei `Box` Objekte instanziieren, manipulieren
 * und ausgeben (hierzu benötigen Sie noch eine geeignete Methode `toString` in der Klasse `Box`, welche Angaben zu allen
 * gespeicherten Daten zurückgibt).
 */

package aufgabe03;

import java.util.ArrayList;
import java.util.Collections;


public class Box {
    
    private Cargo cargo;
    private boolean isFull;
    private int length;
    private int width;
    private int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.isFull = false;
    }

    public Box() {
        this(1, 1, 1); // refers to the other constructor
    }

    public int getCapacity() {
        return this.length * this.width * this.height;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }   

    public int getHeight() {
        return this.height;
    }

    public boolean getIsFull() {
        return this.isFull;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        }
    }

    public boolean addCargo(Cargo cargo) {
        if (this.isFull) {
            System.out.println("Box already full");
            return false;

        /*
         * System welches sicherstellt, dass das Cargo schlau eingepackt wird. Box kann ja gedreht werden
         * ArrayList<Integer> erstellt einen Array
         */
        } else { 
            ArrayList<Integer> cargoDimensions = new ArrayList<>();
                cargoDimensions.add(cargo.getLength());
                cargoDimensions.add(cargo.getWidth());
                cargoDimensions.add(cargo.getHeight());
            ArrayList<Integer> boxDimensions = new ArrayList<>();
                boxDimensions.add(this.length);
                boxDimensions.add(this.width);
                boxDimensions.add(this.height);

            Collections.sort(cargoDimensions);
            Collections.sort(boxDimensions);
            
            boolean fits = true;
            for (int i = 0; i < 3; i++) {
                if (cargoDimensions.get(i) > boxDimensions.get(i)) {
                    fits = false;
                    break;
                }
            }

            if (fits) {
                this.cargo = cargo;
                this.isFull = true;
                System.out.println("Cargo placed in Box!");
                return true;
            } else {
                System.out.println("Box dimensions are too small for that cargo");
                return false;
            }

            
        }
    }

    public void removeCargo() {
        this.cargo = null;
        this.isFull = false;
    }

    public String toString() {
        return "Box: \tDimensions: " + this.length + "x" + this.width + "x" + this.height + " Capacity: " + this.getCapacity() + " " + this.cargo;
    }
}
