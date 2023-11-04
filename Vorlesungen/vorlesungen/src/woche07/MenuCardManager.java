package woche07;

import java.util.Scanner;

public class MenuCardManager {

    public static void main(String[] args) {
        
        System.out.println("Willkommen beim MenuCardManager 3000");
        MenuCard menuCard = new MenuCard();
        int decision;
        do {
            System.out.println("0=EXIT; 1=ADD; 2=PRINT");
            Scanner scan = new Scanner(System.in);
            decision = scan.nextInt();
            switch (decision) {
                case 1 :
                    menuCard.addMenu();
                    break;
                case 2 :
                    menuCard.printCard();
                    break;
                case 0 :
                    System.out.println("Tschüss!");
                    break;
            
                default:
                    System.out.println("Ungültige Wahl");
                    break;
            }
            scan.close();

        } while (decision != 0);
        
    }
    
}
