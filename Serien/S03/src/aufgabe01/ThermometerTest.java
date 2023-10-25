/**
 * ThermometerTest.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2020-10-18
 * @version 1.0
 * @serie   3
 * @aufgabe 1
 * 
 * Programmieren Sie eine Klasse `Thermometer`, welche einen einfachen Fieberthermometer modelliert. 
 * Die Klasse soll eine Temperatur in Celsius als einzige Instanzvariable speichern. 
 * Der Konstruktor soll diese Instanzvariable standardmässig auf 37.0 Grad setzen.
 * Schreiben Sie eine Methode `increase`, welche die Temperatur um 0.1 Grad erhöht und einen Getter für die Temperatur.
 * Zudem definieren Sie eine Methode `reset`, welche die Temperatur wieder auf 37.0 zurücksetzt.
 * 
 * Schreiben Sie eine zweite Klasse `ThermometerTest`, in der Sie zwei Objekte vom Typ `Thermometer` instanziieren 
 * und deren Methoden ausführlich testen.
 */

package aufgabe01;

public class ThermometerTest {
        
        public static void main(String[] args) {
            Thermometer thermometer1 = new Thermometer();
            Thermometer thermometer2 = new Thermometer();
            System.out.println(thermometer1.getTemperature());
            System.out.println(thermometer2.getTemperature());
            thermometer1.increase();
            System.out.println(thermometer1.getTemperature());
            System.out.println(thermometer2.getTemperature());
            
            for (int i = 0; i < 10; i++) {
                thermometer2.increase();
            }
            System.out.println(thermometer1.getTemperature());
            System.out.println(thermometer2.getTemperature());
            thermometer1.reset();
            thermometer2.reset();
            System.out.println(thermometer1.getTemperature());
            System.out.println(thermometer2.getTemperature());
        }
}
