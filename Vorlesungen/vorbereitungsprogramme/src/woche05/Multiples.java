package woche05;

public class Multiples {

    public static void main(String[] args) {
        
        final int MAX1 = 5, MAX2 = 10;
        int val1 = 1, val2;

        while (val1 <= MAX1) {
            val2 = 1;
            while (val2 <= MAX2) {
                System.out.print(val1 * val2 + "\t");
                val2++;
            }
            val1++;
            System.out.println();
        }
    }
}
