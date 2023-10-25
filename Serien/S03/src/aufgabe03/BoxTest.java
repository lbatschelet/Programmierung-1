/**
 * BoxTest.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 3
 * 
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

public class BoxTest {
    
    public static void main(String[] args) {
        
        Cargo cargo1 = new Cargo("Kaffeemaschine", 30, 44, 65);
        Cargo cargo2 = new Cargo("Kühlschrank", 60, 60, 180);
        Cargo cargo3 = new Cargo("Küchentisch", 80, 120, 75);
        Cargo cargo4 = new Cargo("Küchenstuhl", 40, 40, 90);

        System.out.println("Cargo1: " + cargo1);
        System.out.println("Cargo2: " + cargo2);
        System.out.println("Cargo3: " + cargo3);
        System.out.println("Cargo4: " + cargo4);

        cargo1.setName("Espressomaschine");
        System.out.println("Set cargo1 name to Espressomaschine");
        System.out.println("Cargo1: " + cargo1.getName());

        cargo2.setLength(70);
        System.out.println("Set cargo2 length to 70");
        System.out.println("Cargo2: " + cargo2.getName() + " Length: " + cargo2.getLength());

        cargo3.setWidth(100);
        System.out.println("Set cargo3 width to 100");
        System.out.println("Cargo3: " + cargo3.getName() + " Width: " + cargo3.getWidth());

        cargo4.setHeight(100);
        System.out.println("Set cargo4 height to 100");
        System.out.println("Cargo4: " + cargo4.getName() + " Height: " + cargo4.getHeight());

        Box box1 = new Box(50, 50, 50);
        Box box2 = new Box(100, 100, 100);
        Box box3 = new Box();

        System.out.println("Box1: " + box1);
        System.out.println("Box2: " + box2);
        System.out.println("Box3: " + box3);

        box1.setLength(100);
        System.out.println("Set box1 length to 100");
        System.out.println("Box1: " + box1.getLength());

        box2.setWidth(50);
        System.out.println("Set box2 width to 50");
        System.out.println("Box2: " + box2.getWidth());

        box3.setHeight(100);
        System.out.println("Set box3 height to 100");
        System.out.println("Box3: " + box3.getHeight());

        System.out.println("\n" + cargo1);
        System.out.println( box1);
        System.out.println("Placing cargo1 in box1 (NOTE: Dimensions don't match up, Box has to be turned)");
        box1.addCargo(cargo1);
        System.out.println("Box1: " + box1.getCargo());

        System.out.println("Trying to add another cargo into the same Box");
        box1.addCargo(cargo2);

        System.out.println("\nEmpty Box1");
        box1.removeCargo();
        System.out.println(box1);

        cargo1.setWidth(50);
        System.out.println(cargo1);

        System.out.println("\n" + cargo1);
        System.out.println( box1);
        System.out.println("Placing cargo1 in box1 (NOTE: Dimensions don't match up, Box has to be turned)");
        box1.addCargo(cargo1);
        System.out.println("Box1: " + box1.getCargo());

        System.out.println("\nEmpty Box1");
        box1.removeCargo();
        System.out.println(box1);

        cargo1.setWidth(100);
        System.out.println(cargo1);

        System.out.println("\n" + cargo1);
        System.out.println( box1);
        System.out.println("Placing cargo1 in box1 (NOTE: Dimensions don't match up! Cargo won't fit)");
        box1.addCargo(cargo1);
        System.out.println("Box1: " + box1);


    }
}
