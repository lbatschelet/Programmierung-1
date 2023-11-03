package woche07;

public class Table {
    /**
    * Demonstration eines 2D Arrays
    */
    public static void main (String[] args){
        // 2D Array der Grosse 10x10
        int[][] table = new int[10][10];
        
        // Fullen der Tabelle
        // table.length = Anzahl "Zeilen"
        // table[row].length = Anzahl Elemente in "Zeile" mit Index row
        for (int row = 0; row < table.length; row++)
            for (int col = 0; col < table[row].length; col++)
                table[row][col] = row * 10 + col;

        // Ausgeben der Tabelle
        for (int row = 0; row < table.length; row++){
            for (int col = 0; col < table[row].length; col++)
                System.out.print(table[row][col] + "\t");
            System.out.println();
        }
    }
}