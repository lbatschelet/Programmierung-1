package woche03;

public class StringOperations {
    public static void main(String[] args) {

        String original = "Impossible is temporary";
        System.out.println("Original" + original);

        String string1 = original.concat(", impossible is nothing.");
        String string2 = original.replace('e', 'X');
        String string3 = original.substring(3, 7);
        String string4 = original.toUpperCase();

        System.out.println("Veränderung 1: " + string1);
        System.out.println("Veränderung 2: " + string2);
        System.out.println("Veränderung 3: " + string3);
        System.out.println("Veränderung 4: " + string4);
        System.out.println("Länge der Veränderung 3: " + string3.length());

        if (original.equals("Impossible is temporary"))
            System.out.println("Original ist unverändert: " + original);
    }
}
