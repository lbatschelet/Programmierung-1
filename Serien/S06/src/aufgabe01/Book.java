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

