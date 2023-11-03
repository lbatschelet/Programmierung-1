package woche07;

import java.util.Scanner;

public class PlayerCardApp {

    public static void main(String[] args) {
        

        PlayerCardCollection myCards = new PlayerCardCollection();

        Scanner scan = new Scanner(System.in);

        int decision;

        do {
            System.out.println("1=Karte hinzufügen; 2=Karten ausgeben; 0=EXIT");
            decision = Integer.parseInt(scan.nextLine());
            switch (decision) {
                case 1:
                    System.out.println("Name:");
                    String name = scan.nextLine();
                    System.out.println("Number:");
                    int number = Integer.parseInt(scan.nextLine());
                    myCards.addPlayerCard(name, number);                
                    break;
                case 2:
                    System.out.println(myCards);
                    break;
                case 0:
                    System.out.println("Programm wird beendet...");
                    break;
                default:
                    System.out.println("ungültige Eingabe");
            } 
        } while (decision != 0);

    }
    
}
