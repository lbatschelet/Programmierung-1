package woche05;

import java.util.Random;

public class AdditionTask {
    
    private final int MAX = 100;
    private int op1, op2, result;
    private Random rand;

    public AdditionTask() {
        this.rand = new Random();
        this.op1 = this.rand.nextInt(this.MAX + 1);
        this.op2 = this.rand.nextInt(this.MAX - this.op1 + 1);
        this.result = this.op1 + this.op2;
    }

    public void displayTask() {
        System.out.println(this.op1 + " + " + this.op2 + " = ???");
    }

    public boolean isCorrect(int answer) {
        return this.result == answer;
    }

    public int getResult() {
        return this.result;
    }

    // For Tests only
    public static void main(String[] args) {
        AdditionTask t1 = new AdditionTask();
        t1.displayTask();
    }








    
}
