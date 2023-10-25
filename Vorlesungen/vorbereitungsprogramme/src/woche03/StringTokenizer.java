package woche03;

import java.util.Scanner;

public class StringTokenizer {
    
    /**
     * Zerlegt Eingaben getrennt durch Kommas
     */

    public static void main(String [] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie drei Namen getrennt durch Kommas ein: ");
        String names = scan.nextLine();

        Scanner lineScanner = new Scanner(names);
        lineScanner.useDelimiter(", ");

        String name1 = lineScanner.next();
        String name2 = lineScanner.next();
        String name3 = lineScanner.next();

        System.out.println("Name 1: " + name1);
        System.out.println("Name 2: " + name2);
        System.out.println("Name 3: " + name3);

        scan.close();
        lineScanner.close();

    }

}
