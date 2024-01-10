package fibonacci;

public class Fibonacci {

    static long fib(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fib(i - 1) + fib(i - 2);
        }
    }

    public static void main(String[] args) {
        
        for (int i = 0; i <= 50; i++) {
            System.out.println(fib(i));
        }

    }
}
