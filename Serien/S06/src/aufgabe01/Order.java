/**
 * Order.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-22
 * @version 1.0
 * @serie   6
 * @aufgabe 1
 * 
 * Laden Sie von ILIAS die Datei Book.java herunter (→ Serie 6 Vorlagen
 * → Aufgabe 1) (verwenden Sie nicht Ihre Datei aus Serie 3 ).
 * Schreiben Sie eine Klasse Order für Buchbestellungen. Ein Order-Objekt
 * soll aus einer id, einem Kundennamen customerName, einer Kundenadresse
 * customerAddress und beliebig vielen Book-Objekten bestehen. Zudem
 * soll die Klasse Order die Methoden toString() und addBook(...) enthalten.
 * 
 * Schreiben Sie zudem einen Konstruktor Order(), der die Instanzvariable
 * id automatisch so initialisiert, dass das erste Order-Objekt die id 1, das
 * zweite die id 2, das dritte die id 3 usw. erhält. Tipp: verwenden Sie eine
 * static-Variable.
 * 
 * Verwenden Sie anschliessend die gegebene Klasse Test (ILIAS: Übungen
 * → Serie 6 → Serie 6 Vorlagen → Aufgabe 1) um Ihre Klasse Order zu
 * testen. Die Ausgabe von Test soll exakt so aussehen:
 * 
 * 
 * Order id: 1, Customer: Sophie Muster, Mittelstrasse 10, 3011 Bern
 * 1, Homo Faber, Max Frisch, 01.01.1957
 * 2, Harry Potter, J.K. Rowling, 25.07.2000
 * 3, Krieg und Frieden, Leo Tolstoi, 24.01.1867
 * 4, Freedom, Jonathan Franzen, 08.06.2010
 * 4, Freedom, Jonathan Franzen, 08.06.2010
 * 1
 * 5, Goedel, Escher, Bach, Douglas Hofstadter, 05.11.1979 Order
 * id: 2, Customer: Woody Allen, 5th Avenue 7, 10001 New York
 * 5, Goedel, Escher, Bach, Douglas Hofstadter, 05.11.1979
 * 
 * 
 * Hinweise:
 * • Programmieren Sie nur Getter und Setter, die tatsächlich verwendet
 *   werden.
 * • Die Klasse Test darf nicht verändert werden.
 */


package aufgabe01;

import java.util.ArrayList;

public class Order {

    private static int globalIdCounter = 0;
    private String customerName;
    private String customerAdress;
    private ArrayList<Book> shoppingCart;
    private int localid;

    public Order() {
        globalIdCounter++;
        this.localid = globalIdCounter;
        this.shoppingCart = new ArrayList<Book>();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public void addBook(Book book) {
        shoppingCart.add(book);
    }

    public String toString() {
        String output = "Order id: " + localid + ", Customer: " + customerName + ", " + customerAdress + "\n";
        for (Book book : shoppingCart) {
            output += book.toString() + "\n";
        }
        return output;
    }

    
}
