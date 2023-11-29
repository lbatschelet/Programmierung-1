/**
 * Book.java
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


//***************************************************
//Datei fuer Serie 6, Teilaufgabe 1
//***************************************************
package aufgabe01;

import java.util.Date;
import java.text.*;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	//--- constructors ---
	public Book(int idName, String titleName, String authorName, Date dateOfPub){
		id = idName;
		title = titleName;
		author = authorName;
		dateOfPublication = dateOfPub;
	}


	/** Returns a String representation of the book */
	public String toString()
	{
		String result = Integer.toString(id) + ", " + title + ", " + author + ", " + dateToString(dateOfPublication); 
		return result;
	}


	/** Converts the Date object d into a String object */
	public static String dateToString( Date d )
	{
		SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
		return fmt.format( d );
	}

	/** Converts the String object s into a Date object */
	public static Date stringToDate( String s ) 
	{
		Date r = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
			r = fmt.parse( s );
		} catch ( ParseException e ){
			System.err.println( e );
			System.exit(1);
		}
		return r;
	}
}

