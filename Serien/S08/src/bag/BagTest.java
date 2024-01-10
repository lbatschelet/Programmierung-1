package bag;

public class BagTest {

    public static void main(String[] args) {
        Bag b1 = new Bag();
        System.out.println(b1);

        Bag b2 = new Bag(1);
        System.out.println(b2);

        Bag b3 = new Bag(1);
        b3.addValue(2);
        b3.addValue(3);
        b3.addValue(4);
        System.out.println(b3);
    }

}
