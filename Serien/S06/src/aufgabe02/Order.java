/**
 * Order.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-22
 * @version 1.0
 * @serie   6
 * @aufgabe 2
 * 
 * Laden Sie von ILIAS die Datei Store.java und Book.java herunter (nicht dasselbe
 * Book.java wie in Teilaufgabe 1). Das Programm Store verfügt über ein Menü, anhand
 * dessen man neue Bestellung erfassen kann. Bestellungen bestehen aus (beliebig vielen)
 * Büchern, DVDs und CDs:
 * =============================================================
 * | 1. Create a new order 2. Show all registered articles    |
 * | 3. Show all orders 9. Exit                               |
 * =============================================================
 * What do you want to do? 1
 * 1 (Book) Die Blechtrommel, by Guenter Grass, 1959, 29 CHF
 * 3 (Book) L’Etranger, by Albert Camus, 1942, 25 CHF
 * 4 (DVD) Casablanca, 1942, 29 CHF
 * 6 (CD) Nirvana, Nevermind, 1991, 19 CHF
 * 8 (CD) Britney Spears, ...Baby One More Time, 1999, 50 CHF
 * Enter id of ordered article (press x when done): 6
 * Successfully added: 6 (CD) Nirvana, Nevermind, 1991, 19 CHF
 * Enter id of ordered article (press x when done): 4
 * Successfully added: 4 (DVD) Casablanca, 1942, 29 CHF
 * Enter id of ordered article (press x when done): x
 * Enter the customer’s name: Susi Meier
 * Enter the customer’s address: Mittelstrasse 10, 3011 Bern
 * 
 * Ihre Aufgabe ist es, dafür zu sorgen, dass das Programm Store einwandfrei
 * funktioniert. Store selbst darf nicht verändert werden.
 * Sie müssen also folgende Klassen und Schnittstellen programmieren:
 *   (a) Eine Schnittstelle IArticle, die die folgenden Methoden definiert:
 *       int getId(), int getPrice() und String getDescription(). Passen
 *       Sie die Klasse Book derart an, dass sie diese Schnittstelle implementiert.
 *   (b) Schreiben Sie Klassen DVD und CD, die beide das IArticle implementieren.
 *       CD soll einen Interpreten statt eines Autors und ansonsten
 *       die gleichen Attribute haben wie Book, wogegen DVD kein Feld author
 *       haben soll.
 *   (c) Passen Sie die Klasse aus Aufgabe 1 an. Welche Methoden die Klasse
 *       Order bereitstellen muss, können Sie der Klasse Store entnehmen.
 *       Insbesondere muss Order eine Methode getOrderedArticles() besitzen.
 *       Definieren sie dessen Rückgabetyp als Iterable<IArticle>.
 *   (d) Zeichnen Sie ein UML-Klassendiagramm aller involvierten Klassen
 *       und Schnittstellen.
 */


package aufgabe02;

import java.util.ArrayList;

public class Order {

    private static int globalIdCounter = 0;
    private String customerName;
    private String customerAdress;
    private ArrayList<IArticle> shoppingCart;
    private int localid;

    public Order() {
        globalIdCounter++;
        this.localid = globalIdCounter;
        this.shoppingCart = new ArrayList<IArticle>();
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAdress) {
        this.customerAdress = customerAdress;
    }


    public String toString() {
        String output = "Order id: " + localid + ", Customer: " + customerName + ", " + customerAdress + "\n";
        for (IArticle article : shoppingCart) {
            output += article.getDescription() + "\n";
        }
        return output;
    }

	public void add(IArticle a) {
        shoppingCart.add(a);
	}

    public int getId() {
        return this.localid;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getCustomerAddress() {
        return this.customerAdress;
    }

    public IArticle[] getOrderedArticles() {
        return shoppingCart.toArray(new IArticle[shoppingCart.size()]);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (IArticle article : shoppingCart) {
            totalPrice += article.getPrice();
        }
        return totalPrice;
    
    }
    
}
