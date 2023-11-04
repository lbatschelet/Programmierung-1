package woche07;

import java.util.Scanner;

public class Menu {

    private String name;
    private double price;

    public Menu(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie den Namen des Artikels ein: ");
        this.name = scan.nextLine();
        System.out.println("Geben Sie den Preis des Artikels ein: ");
        this.price = scan.nextDouble();
        scan.close();
    }

    public String toString() {
        return this.name + " " + String.format("CHF %.2f", this.price);
    }


    
}
