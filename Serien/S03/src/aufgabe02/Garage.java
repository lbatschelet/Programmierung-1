/**
 * Garage.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 2
 * 
 * Programmieren Sie eine Klasse `Car`, welche die Marke, das Modell und den Jahrgang des Fahrzeuges modelliert.
 * Der Konstruktor soll diese drei Instanzvariablen gemäss Parameterübergabe initialisieren – zudem schreiben
 * Sie Getter und Setter für alle Instanzvariablen und eine `toString` Methode für eine einzeilige Repräsentation
 * von `Car` Objekten. Schliesslich definieren Sie eine Methode isAntique, welche einen boolean zurückgibt,
 * der anzeigt ob das Auto aktuell älter ist als 45 Jahre (Durchsuchen Sie die
 * API Dokumentation nach Möglichkeiten, das aktuelle Jahr vom System
 * zu erfragen). In einer zweiten Klasse Garage instanziieren Sie drei Car
 * Objekte und testen alle programmierten Methoden.
 */

package aufgabe02;

public class Garage {
        
        public static void main(String[] args) {
            Car car1 = new Car("BMW", "M3", 1900);
            Car car2 = new Car("Mercedes", "C63", 2010);
            Car car3 = new Car("Audi", "RS6", 2015);
            System.out.println("Car1 " + car1);
            System.out.println("Car2 " + car2);
            System.out.println("Car3 " + car3);

            car1.setYear(2000);
            System.out.println("Set car1 year to 2000");
            System.out.println("Car1: " + car1);

            car2.setBrand("Mercedes-Benz");
            System.out.println("Set car2 brand to Mercedes-Benz");
            System.out.println("Car2: " + car2);

            car3.setModel("RS7");
            System.out.println("Set car3 model to RS7");
            System.out.println("Car3: " + car3);

            car1.setYear(1984);
            System.out.println("Set car1 year to 1984");
            System.out.println("Car1: " + car1.getYear());
            System.out.println("Car1: " + car1.isAntique());

            car2.setBrand("Mercedes");
            System.out.println("Set car2 brand to Mercedes");
            System.out.println("Car2: " + car2.getBrand());

            car3.setModel("RS5");
            System.out.println("Set car3 model to RS5");
            System.out.println("Car3: " + car3.getModel());

        }
}
