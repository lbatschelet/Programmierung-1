/**
 * BookShelf.java
 * 
 * @author	Lukas Batschelet (16-499-733)
 * @date	2023-10-13
 * @version	1.0
 * @serie   3
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

public class BookShelf {

    public static void main(String[] args) {
        
        Book book1 = new Book(123, "Die Blechtrommel", "Günter Grass", "01.01.1959");
        Book book2 = new Book(456, "Der Steppenwolf", "Hermann Hesse", "01.01.1927");
        Book book3 = new Book(789, "Der Zauberberg", "Thomas Mann", "01.01.1924");
        Book book4 = new Book(101, "Der Prozess", "Franz Kafka", "01.01.1925");
        Book book5 = new Book(112, "Der Fremde", "Albert Camus", "01.01.1942");
        Book book6 = new Book(131, "Der Fänger im Roggen", "J.D. Salinger", "01.01.1951");
        Book book7 = new Book(415, "Der kleine Prinz", "Antoine de Saint-Exupéry", "01.01.1943");
        Book book8 = new Book(161, "Der Name der Rose", "Umberto Eco", "01.01.1980");
        Book book9 = new Book(718, "Der Herr der Ringe", "J.R.R. Tolkien", "01.01.1954");
        Book book10 = new Book(192, "Der Hobbit", "J.R.R. Tolkien", "01.01.1937");

        System.out.println("\nBookshelf:\n");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());
        System.out.println(book6.toString());
        System.out.println(book7.toString());
        System.out.println(book8.toString());
        System.out.println(book9.toString());
        System.out.println(book10.toString());

        System.out.println("\nBookshelf name and age (in Days):\n");
        System.out.println(book1.getTitle() + "\t" + book1.age());
        System.out.println(book2.getTitle() + "\t" + book2.age());
        System.out.println(book3.getTitle() + "\t" + book3.age());
        System.out.println(book4.getTitle() + "\t" + book4.age());
        System.out.println(book5.getTitle() + "\t" + book5.age());
        System.out.println(book6.getTitle() + "\t" + book6.age());
        System.out.println(book7.getTitle() + "\t" + book7.age());
        System.out.println(book8.getTitle() + "\t" + book8.age());
        System.out.println(book9.getTitle() + "\t" + book9.age());
        System.out.println(book10.getTitle() + "\t" + book10.age());

        System.out.println("\nBookshelf ID, name, author and date of publication:\n");
        System.out.println(book1.getId() + "\t" + book1.getTitle() + "\t" + book1.getAuthor() + "\t" + book1.getDateOfPublication());
        System.out.println(book2.getId() + "\t" + book2.getTitle() + "\t" + book2.getAuthor() + "\t" + book2.getDateOfPublication());
        System.out.println(book3.getId() + "\t" + book3.getTitle() + "\t" + book3.getAuthor() + "\t" + book3.getDateOfPublication());
        System.out.println(book4.getId() + "\t" + book4.getTitle() + "\t" + book4.getAuthor() + "\t" + book4.getDateOfPublication());
        System.out.println(book5.getId() + "\t" + book5.getTitle() + "\t" + book5.getAuthor() + "\t" + book5.getDateOfPublication());
        System.out.println(book6.getId() + "\t" + book6.getTitle() + "\t" + book6.getAuthor() + "\t" + book6.getDateOfPublication());
        System.out.println(book7.getId() + "\t" + book7.getTitle() + "\t" + book7.getAuthor() + "\t" + book7.getDateOfPublication());
        System.out.println(book8.getId() + "\t" + book8.getTitle() + "\t" + book8.getAuthor() + "\t" + book8.getDateOfPublication());
        System.out.println(book9.getId() + "\t" + book9.getTitle() + "\t" + book9.getAuthor() + "\t" + book9.getDateOfPublication());
        System.out.println(book10.getId() + "\t" + book10.getTitle() + "\t" + book10.getAuthor() + "\t" + book10.getDateOfPublication());

        System.out.println("\nBookshelf: Setting new values for ID, name, author and date of publication:");
        book1.setId(1234); book1.setTitle("Die Stahltrommel"); book1.setAuthor("Günter Wiese"); book1.setDateOfPublication("01.01.1958");
        book2.setId(4567); book2.setTitle("Der Wüstenwolf"); book2.setAuthor("Hermann Hase"); book2.setDateOfPublication("01.01.1926");
        book3.setId(7891); book3.setTitle("Das Zaubertal"); book3.setAuthor("Thomas Junge"); book3.setDateOfPublication("01.01.1923");
        book4.setId(1011); book4.setTitle("Der Antizess"); book4.setAuthor("Franz Kaffee"); book4.setDateOfPublication("01.01.1924");
        book5.setId(1121); book5.setTitle("Der Freund"); book5.setAuthor("Albert Kamel"); book5.setDateOfPublication("01.01.1941");
        book6.setId(1311); book6.setTitle("Der Werfer im Roggen"); book6.setAuthor("J.D. Salzinger"); book6.setDateOfPublication("01.01.1950");
        book7.setId(4151); book7.setTitle("Der große Prinz"); book7.setAuthor("Antoinette de Saint-Exupéry"); book7.setDateOfPublication("01.01.1942");
        book8.setId(1611); book8.setTitle("Der Name der Tulpe"); book8.setAuthor("Umberto Öko"); book8.setDateOfPublication("01.01.1981");
        book9.setId(7181); book9.setTitle("Die Dame der Bänder"); book9.setAuthor("J.R.R. Blödkien"); book9.setDateOfPublication("01.01.1955");
        book10.setId(1921); book10.setTitle("Die Riesin"); book10.setAuthor("J.R.R. Blödkien"); book10.setDateOfPublication("01.01.1936");

        System.out.println("\nBookshelf ID, name, author and date of publication:\n");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());
        System.out.println(book6.toString());
        System.out.println(book7.toString());
        System.out.println(book8.toString());
        System.out.println(book9.toString());
        System.out.println(book10.toString());


        System.out.println("\nRegistration of a new book:\n");
        Book book11 = new Book();
        book11.input();

        System.out.println("\nNew book:\n");
        System.out.println(book11.toString());






        

    }
    
}
