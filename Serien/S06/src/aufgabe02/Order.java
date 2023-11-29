/**
 * Order.java
 * 
 * @autor   Lukas Batschelet (16-499-733)
 * @date    2023-11-22
 * @version 1.0
 * @serie   6
 * @aufgabe 2
 * 
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
