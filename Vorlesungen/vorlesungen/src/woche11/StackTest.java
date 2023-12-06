package woche11;

public class StackTest {

    public static void main(String[] args) {
        OwnStack<String> stack = new OwnStack<String>();

        stack.push("Kreuz Bube");
        stack.push("Herz Dame");
        stack.push("Karo König");

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.push("Karo Ass");
        stack.push("Herz 10");

        while (!stack.isEmpty())
            System.out.println(stack.pop());




    }
}
