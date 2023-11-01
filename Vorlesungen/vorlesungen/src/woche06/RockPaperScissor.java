package woche06;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    
    public static void main(String[] args) {
        
        final int ROUNDS = 5;
        int won = 0, loss = 0, tie = 0;

        ArrayList<Symbol> symbols = new ArrayList<Symbol>();
        symbols.add(new Symbol("Schere"));
        symbols.add(new Symbol("Stein"));
        symbols.add(new Symbol("Papier"));

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 1; i <= ROUNDS; i++) {
            System.out.println("Runde " + i + ":");
            System.out.println("Wähle dein Symbol (1 = Schere, 2 = Stein, 3 = Papier):");
            Symbol userPick = symbols.get(scan.nextInt() - 1);
            Symbol computerPick = symbols.get(rand.nextInt(3));

            System.out.println("Du hast " + userPick + " gewählt.");
            System.out.println("Der Computer hat " + computerPick + " gewählt.");
            if (userPick.compareTo(computerPick) > 0) {
                System.out.println("Du hast gewonnen!");
                won++;
            } else
                if (userPick.compareTo(computerPick) < 0) {
                    System.out.println("Du hast verloren!");
                    loss++;
                } else {
                    System.out.println("Unentschieden!");
                    tie++;
            }
        }
        scan.close();
        System.out.println("Du hast " + won + " mal gewonnen, " + loss + " mal verloren und " + tie + " mal unentschieden gespielt.");

    }
}
