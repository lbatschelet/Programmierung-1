/**
 * Rectangle.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-10-11
 * @version 1.0
 * 
 * Schreiben Sie ein Programm, das nach der Länge und Breite eines Rechtecks fragt und danach die Fläche 
 * und den Umfang des Rechtecks berechnet und ausgibt. Zusätzlich soll Ihr Programm feststellen,ob es sich
 * beim definierten Rechteck um ein Quadrat handelt oder nicht und eine entsprechende Ausgabe erzeugen.
 */

package aufgabe01;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        
        System.out.println("Dieses Programm berechnet die Fläche und den Umfang eines Rechtecks.");
        System.out.println("Geben Sie die Länge des Rechtecks ein:");
        Scanner scan = new Scanner(System.in);
        double length = scan.nextDouble();
        System.out.println("Geben Sie die Breite des Rechtecks ein:");
        double width = scan.nextDouble();
        scan.close();

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("Die Fläche des Rechtecks beträgt: " + area);
        System.out.println("Der Umfang des Rechtecks beträgt: " + perimeter);
        if (length == width) {
            System.out.println("Das Rechteck ist ein Quadrat.");
        } else {
            System.out.println("Das Rechteck ist kein Quadrat.");
        }
        
    }
    
}
