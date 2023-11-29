/**
 * Store.java
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

import java.util.Scanner;
import java.util.*;


//***************************************************
//Datei fuer Serie 6, Teilaufgabe 2
//***************************************************


public class Store
{
	private ArrayList<IArticle> articles = new ArrayList<IArticle>();
	private ArrayList<Order> orders = new ArrayList<Order>();

	// I just made this static, to avoid error messages because of unclosed scanner objects.
	private static final Scanner scn = new Scanner(System.in);

	/** starts the menu */
	public void interactWithUser()
	{
		String answer = "";
		while ( !answer.equals( "9" ) ) {
			System.out.println( " =============================================================" );
			System.out.println( "|                                                             |" );
			System.out.println( "|  1. Create a new order     2. Show all registered articles  |" );
			System.out.println( "|  3. Show all orders        9. Exit                          |" );
			System.out.println( "|                                                             |" );
			System.out.println( " =============================================================" );
			System.out.print( "\nWhat do you want to do? " );
			answer = scn.nextLine();
			if ( answer.equals( "1" ) ) {
				this.newOrder();
			} else if ( answer.equals( "2" ) ) {
				this.listArticles();
				System.out.println( "" );
			} else if ( answer.equals( "3" ) ) {
				this.listOrders();
			}
		}
	}

	/** Add a new article to the store */
	public void addArticle( IArticle a )
	{
		articles.add( a );
	}

	/** Let's the user compose a new order */
	private void newOrder()
	{
		Order order = new Order();
		listArticles();
		System.out.print( "\nEnter id of ordered article (press x when done): " );
		String input = scn.nextLine();
		while ( !input.equalsIgnoreCase( "x" ) ) {
			int id = Integer.parseInt( input );
			if ( articleExists( id ) ) {
				// if it exists, then add it to the order
				for ( IArticle a : this.articles ) {
					if ( a.getId() == id ) {
						order.add( a );
						System.out.println( "Successfully added: " + a.getDescription() );
					}
				}
			} else {
				System.out.println( "A medium with this id does not exist!" );
			}
			System.out.print( "Enter id of ordered article (press x when done): " );
			input = scn.nextLine();
		}
		System.out.print( "Enter the customer's name: " );
		order.setCustomerName( scn.nextLine() );
		System.out.print( "Enter the customer's address: " );
		order.setCustomerAddress( scn.nextLine() );
		this.orders.add( order );
	}

	/** checks if an article with the given id exists */
	private boolean articleExists( int id )
	{
		for ( IArticle a : this.articles ) {
			if ( a.getId() == id )
				return true;
		}
		return false;
	}

	/** Output all registered media on the screen */
	private void listArticles()
	{
		System.out.println( "" );
		for ( IArticle a : this.articles ) {
			System.out.println( a.getDescription() );
		}
	}

	/** Output all orders on the screen */
	private void listOrders()
	{
		for ( Order o : this.orders ) {
			String order = "\nOrder No. " + o.getId() + " for: " + o.getCustomerName() + ", "
			               + o.getCustomerAddress() + "\n";
			for ( IArticle a : o.getOrderedArticles() ) {
				order += "* " + a.getDescription() + "\n";
			}
			order += "----------------------------------------------------\n";
			order += "Total price: " + o.getTotalPrice() + " CHF\n";
			order += "====================================================\n";
			System.out.println( order );
		}
	}


	/** Registers some objects and starts the program */
	public static void main( String[] args ) throws java.text.ParseException
	{
		Store store = new Store();
		store.addArticle( new Book( 1, "Die Blechtrommel", "Günter Grass", 1959, 29 ) );
		store.addArticle( new Book( 2, "Andorra", "Max Frisch", 1961, 39 ) );
		store.addArticle( new Book( 3, "L'Etranger", "Albert Camus", 1942, 25 ) );
		store.addArticle( new DVD( 4, "Casablanca", 1942, 29 ) );
		store.addArticle( new DVD( 5, "Into the wild", 2007, 38 ) );
		store.addArticle( new CD( 6, "Nevermind", "Nirvana", 1991, 19 ) );
		store.addArticle( new CD( 7, "Thriller", "Michael Jackson", 1982, 18 ) );
		store.addArticle( new CD( 8, "...Baby One More Time", "Britney Spears", 1999, 50 ) );

		store.interactWithUser();
	}
}
