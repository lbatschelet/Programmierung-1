/**
 * Cargo.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 3
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

public class Cargo {
    
    private String name;
    private int length;
    private int width;
    private int height;

    public Cargo(String name, int length, int width, int height) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return this.name;
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

    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return "Cargo: \tName: " + this.name + " Dimensions: " + this.length + "x" + this.width + "x" + this.height;
    }
}
