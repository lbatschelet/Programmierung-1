# Serie 2

## Theorieaufgaben

### 1. `new`-Operator

> *Der* `new`*-Operator zusammen mit dem Konstruktor einer Klasse erledigt zwei Dinge. Was genau?*

<details>
    <summary>Lösung anzeigen</summary>

- Der new-Operator…
    - … erzeugt/instanziiert ein neues Objekt aus der Klasse
    - … erstellt eine Adresse für das Objekt und gibt diese zurück
- `Scanner scan = new Scanner(System.in);`
    - Objekt vom Typ Scanner ist instanziiert und die Adresse des Objektes ist der Variablen scan zugewiesen.

</details>

### 2. `ArrayList`in der Java API

> *Informieren Sie sich in der Java API Dokumentation über die Klasse* `ArrayList` *(welche eine Liste für Objekte repräsentiert).*

> - Wie instanziieren Sie eine solche Liste?
> - Wie fügen Sie ein Objekt zur Liste hinzu?
> - Wie greifen Sie auf ein Objekt an Position `i` zu?
> - Wie löschen Sie den gesamten Inhalt der Liste?
> - Wie können Sie überprüfen, ob ein bestimmtes Objekt in der Liste vorhanden ist?

<details>
    <summary>Lösung anzeigen</summary>

- Wie instanziieren Sie eine solche Liste?
	- `ArrayList list = new ArrayList();`
	- Oder mit einer Zuordnung des Typs (hier mit dem Beispiel `String`)
		- `ArrayList<String> list = new ArrayList<>();`
- Wie fügen Sie ein Objekt zur Liste hinzu?
	- mit der Methode `.add()` wird ein Objekt am Ende der Liste eingefügt
		- Möglicher Parameter ist der Index vom Typ `int`, welcher angibt an welcher Position das Objekt in die Liste eingefügt werden soll
- Wie greifen Sie auf ein Objekt an Position `i` zu?
	- mit der Methode `.get(i)`
- Wie löschen Sie den gesamten Inhalt der Liste?
	- mit der Methode `.clear()`
- Wie können Sie überprüfen, ob ein bestimmtes Objekt in der Liste vorhanden ist?
	- mit der Methode `.contains()` wird ein `boolean` Wert zurückgegeben, ob das Objekt welches als Parameter "mitgegeben wurde" in der Liste ist

</details>

### 3. Unterschied zwischen Klassen und Objekten

> *Erläutern Sie anhand der Klasse* `String`*und des Objektes* `"String"`*den Unterschied zwischen Klasse und Objekt.*

<details>
    <summary>Lösung anzeigen</summary>

- Die Klasse `String` gibt den «Bauplan» für alle verschiedenen Objekte der Klasse vor. Sie definiert das Verhalten und die Eigenschaften eines `String` (Methoden und Variablen).
- Das Objekt `"String"` ist eine konkrete «Realisierung» der Klasse `String`. Dieses Objekt besitzt die in der Klasse definierten Methoden und Variablen:
- es hat z.B. Länge 6 (Variable)
- wir können z.B. die Methode substring darauf aufrufen.
    - `"String".substring(3); // "ing"`

</details>

### 4. Ausgabe

> *Welche Ausgabe erzeugen folgende Anweisungen?*
> 
> ```java
> String testString = "Think different";
> System.out.println(testString.length());
> System.out.println(testString.substring(0, 4));
> System.out.println(testString.toUpperCase());
> System.out.println(testString.charAt(7));
> System.out.println(testString);
> ```

<details>
    <summary>Lösung anzeigen</summary>

```text
15
Thin
THINK DIFFERENT
i
Think different
```

</details>

### 5. Random

> *Gegeben sei eine Objektvariable vom Typ Random mit Bezeichner* `rand`*. In welchen Intervallen suchen die folgenden Anweisungen eine Zufallszahl?*
> 
> - `rand.nextInt(100) + 1;`
> - `rand.nextInt(51) + 100;`
> - `rand.nextInt(10) - 5;`
> - `rand.nextInt(3) - 3;`

<details>
    <summary>Lösung anzeigen</summary>

- `rand.nextInt(100) + 1;`
	- `[1, 100]`
- `rand.nextInt(51) + 100;`
	- `[100, 150]`
- `rand.nextInt(10) - 5;`
	- `[-5, 4]`
- `rand.nextInt(3) - 3;`
	- `[-3, -1]`

</details>

### 6. Aliase

> *Was sind Aliase und weshalb können Aliase problematisch sein?*

<details>
    <summary>Lösung anzeigen</summary>

- Aliase sind Variablen, die auf dasselbe Objekt zeigen. Bei primitiven Datentypen passiert das nicht, da der Wert kopiert wird.

```java
int num1 = 17;
int num2 = num1;
num2 = 99; System.out.println(num1); // 17
System.out.println(num2); // 99
```

Bei Objektvariablen sieht es anders aus:

```java
Integer num1 = new Integer(17); Integer num2 = num1; num2.setValue(99); System.out.println(num1); // 99 
System.out.println(num2); // 99 
```

Hier greifen beide Variablen auf das selbe Objekt zu. Das ist nicht immer wünschenswert, weil:

- Es ist unklar, welche Variable für was zuständig ist.
- Änderungen an einer Variable beeinflussen die andere.
- Der Code wird unübersichtlicher.
- Es kann sogenannter *garbage* und damit einhergehender Datenverlust entstehen.
	- Im obigen Beispiel aus der Vorlesung ist dem Objekt `num1` selber kein Wert mehr zugewiesen, sondern nur noch die Verweisung auf `num2`. Der Wert `17` wird damit zu *garbage*

</details>

## Implementationsaufgaben

### Rechteck

> Schreiben Sie ein Programm, das nach der Länge und Breite eines Rechtecks fragt und danach die Fläche und den Umfang des Rechtecks berechnet und ausgibt. Zusätzlich soll Ihr Programm feststellen, ob es sich beim definierten Rechteck um ein Quadrat handelt oder nicht und eine entsprechende Ausgabe erzeugen.

#### Quellcode

- [Rectangle.java](src/aufgabe01/Rectangle.java)

### Zufällige Addition

> Schreiben Sie ein Programm, das eine zufällige Additionsaufgabe mit zwei positiven Zahlen anzeigt. Die Summe der beiden Zahlen darf maximal 20 betragen. Der Benutzer soll dann ein Ergebnis eingeben können und das Programm soll überprüfen, ob die Eingabe korrekt war oder nicht und eine entsprechende Rückmeldung ausgeben.

#### Quellcode

- [RandomAddition.java](src/aufgabe02/RandomAddition.java)

### Username and Password

> Schreiben Sie ein Programm, das einen Benutzer separat nach seinem Vor- und Nachnamen fragt und diese einliest. Danach soll ein Benutzername nach folgendem Muster erzeugt werden:
> 
> *FL₁L₂L₃L₄L₅D₁D₂D₃*
> 
> wobei
> 
> - *F* dem ersten Buchstaben des Vornamens entspricht.
> - *Lᵢ* dem *i*-ten Buchstaben des Nachnamens entspricht.
> - *D₁D₂D₃* einer zufälligen Zahl zwischen 000 und 999 entspricht.
> 
> Falls der eingegebene Nachname kürzer als 5 Zeichen sein sollte, werden entsprechend weniger Zeichen verwendet.
> 
> Zusätzlich erzeugen Sie ein zufälliges Passwort für den Benutzer. Das Passwort soll mit einer 7 oder 8 oder 9 starten, gefolgt von 5 zufälligen ganzen Zahlen von 0 bis 9, gefolgt von einem Bindestrich -, gefolgt von drei zufälligen Grossbuchstaben.
> 
> Geben Sie Benutzernamen und Passwort aus.
> 
> Tipp: Die Zahlen 65 bis 90 repräsentieren die Grossbuchstaben A bis Z in Unicode und Sie können bspw. die ganze Zahl 77 folgendermassen in einen Buchstaben umwandeln:
> ```java
> char d1 = (char) 77;
> ```

#### Quellcode

- [UsernameAndPassword.java](src/aufgabe03/UsernameAndPassword.java)