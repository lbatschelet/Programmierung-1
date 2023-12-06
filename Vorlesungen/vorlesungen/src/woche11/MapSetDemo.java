package woche11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class MapSetDemo {

    public static void main(String[] args) {
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(123, "Wert für Schlüssel 123");
        map.put(456, "Wert für Schlüssel 456");
        map.put(123, "Wert für Schlüssel 123 (überschrieben)");

        System.out.println(map.get(123));
        System.out.println(map.get(456));
        System.out.println(map.get(789));

        if (map.containsKey(123)) {
            System.out.println("Schlüssel 123 ist vorhanden");
        }

        Iterator<Integer> keyIter = map.keySet().iterator();

        while (keyIter.hasNext()) {
            Integer key = keyIter.next();
            System.out.println(key + " -> " + map.get(key));
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }


        TreeSet<Double> tree = new TreeSet<Double>();

        tree.add(2.1);
        tree.add(1.1);
        tree.add(3.1);
        tree.add(12.9);
        tree.add(8.2);
        tree.add(2.5);
        tree.add(2.8);
        tree.add(2.5); // duplikat
        tree.add(8.6);

        System.out.println("First Element: \t" + tree.first());
        System.out.println("Last Element: \t" + tree.last());

        Iterator<Double> iter = tree.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


        


    }
}