/**
 * Book.java
 * 
 * @author	Lukas Batschelet (16-499-733)
 * @date	2023-10-13
 * @version	1.0
 * @serie	3
 * @aufgabe 4
 * 
 * Auf ILIAS (Übungen → Serie 3) finden Sie eine Datei `Book.java`. Ihre Aufgabe ist es die darin implementierte 
 * Klasse `Book` wie folgt zu erweitern:
 * 	 1. Schreiben Sie einen Konstruktor sowie Getter und Setter für alle Instanzvariablen.
 * 	 2. Implementieren Sie die Methode `age`, welche das Alter eines Buches (Anzahl Tage seit Erscheinungsdatum)
 * 		berechnet und zurückgibt.
 * 	 3. Implementieren Sie die Methode `toString`, die alle Informationen eines Book-Objekts als String zurückgibt.
 * 		Beispiel:
 * 			123, Die Blechtrommel, Günter Grass, 1.1.1959
 * 	 4. Vervollständigen Sie die Methode `input`, welche die Werte für `id`, `title`, `author` und `dateOfPublication`
 * 		von der Kommandozeile vom Benutzer einliest und im jeweiligen Book-Objekt abspeichert. Ungültige Eingaben
 * 		müssen Sie nicht abfangen.
 * Testen Sie sämtliche Methoden der Klasse `Book` in einer zusätzlichen Klasse `BookShelf`.
 * 
 * **Hinweise:**
 * 	  -	Zur Konvertierung zwischen Date- und String-Objekten verwenden Sie bitte die in `Book` vorhandenen Methoden
 * 		`dateToString``
 * 		und `stringToDate`
 * 	  -	Objekte der Klasse `java.util.Date` bestehen im Wesentlichen aus einem `long`-Wert, der die Anzahl Millisekunden
 * 		seit 00:00:00 GMT
 * 		am 1.1.1970 angibt. Verwenden Sie diesen Wert in Ihrer Implementation der Methode `age`. Siehe auch Java API 
 * 		Dokumentation.
 * 	  -	Beachten Sie, dass die Anzahl Millisekunden eines Jahres den Wertebereich von `int` übersteigt.
 */


package aufgabe04;

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	public Book(int id, String title, String author, String dateOfPublication) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.dateOfPublication = stringToDate(dateOfPublication);
	}

	public Book() {
		
	}

	/** Returns the age of the book in days since publication */
	public int age() {
		return (int) ((new Date().getTime() - dateOfPublication.getTime()) / (1000 * 60 * 60 * 24));
	}

	/** Returns a String representation of the book */
	public String toString() {
		return id + ", " + title + ", " + author + ", " + dateToString(dateOfPublication);
	}

	/** Reads all book data from user input */
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID: ");
		id = scanner.nextInt();
		scanner.nextLine(); // consume newline
		System.out.print("Title: ");
		title = scanner.nextLine();
		System.out.print("Author: ");
		author = scanner.nextLine();
		System.out.print("Date of publication: ");
		dateOfPublication = stringToDate(scanner.nextLine());
		scanner.close();
	}
	

	//--- Get-/Set-methods ---

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() { 
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() { 
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateOfPublication() { 
		return dateOfPublication;
	}

	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = stringToDate(dateOfPublication);
	}
	

	//--- helper methods -- DO NOT CHANGE ------------------------------------
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
