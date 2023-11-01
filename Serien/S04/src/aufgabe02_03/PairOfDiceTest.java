package aufgabe02_03;

public class PairOfDiceTest {

    public static void main(String[] args) {
        
        PairOfDice pairOfDice = new PairOfDice();
        
        pairOfDice.setDice1(3);
        pairOfDice.setDice2(4);
        
        System.out.println("Dice 1: " + pairOfDice.getDice1());
        System.out.println("Dice 2: " + pairOfDice.getDice2());
        System.out.println("Sum: " + pairOfDice.getSum());
        
        pairOfDice.rollThePair();
        
        System.out.println("Dice 1: " + pairOfDice.getDice1());
        System.out.println("Dice 2: " + pairOfDice.getDice2());
        System.out.println("Sum: " + pairOfDice.getSum());
    }
    
}
