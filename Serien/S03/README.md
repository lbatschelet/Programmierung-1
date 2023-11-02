# Serie 3

## Implementationsaufgaben

### Aufgabe 1: `Thermometer`-Klasse


> Programmieren Sie eine Klasse `Thermometer`, welche einen einfachen Fieberthermometer modelliert. Die Klasse soll eine Temperatur in Celsius als einzige Instanzvariable speichern. Der Konstruktor soll diese Instanzvariable standardmässig auf 37.0 Grad setzen. Schreiben Sie eine Methode `increase`, welche die Temperatur um 0.1 Grad erhöht und einen Getter für die Temperatur. Zudem definieren Sie eine Methode `reset`, welche die Temperatur wieder auf 37.0 zurücksetzt.
> 
> Schreiben Sie eine zweite Klasse `ThermometerTest`, in der Sie zwei Objekte vom Typ `Thermometer` instanziieren und deren Methoden ausführlich testen.

#### Quellcode

- [Thermometer.java](src/aufgabe01/Thermometer.java)
- [ThermometerTest.java](src/aufgabe01/ThermometerTest.java)

### Aufgabe 2: `Car`-Klasse

> Programmieren Sie eine Klasse `Car`, welche die Marke, das Modell und den Jahrgang des Fahrzeuges modelliert. Der Konstruktor soll diese drei Instanzvariablen gemäss Parameterübergabe initialisieren – zudem schreiben Sie Getter und Setter für alle Instanzvariablen und eine `toString` Methode für eine einzeilige Repräsentation von `Car` Objekten. Schliesslich definieren Sie eine Methode `isAntique`, welche einen boolean zurückgibt, der anzeigt ob das Auto aktuell älter ist als 45 Jahre.
> 
> In einer zweiten Klasse `Garage` instanziieren Sie drei `Car` Objekte und testen alle programmierten Methoden.

#### Quellcode

- [Car.java](src/aufgabe02/Car.java)
- [Garage.java](src/aufgabe02/Garage.java)

### Aufgabe 3: `Cargo` und `Box`-Klassen

> Schreiben Sie eine Klasse `Cargo`, welche ein Stückgut mit Länge, Breite, Höhe und einem Namen modelliert (z.B. 30, 44, 65, "Kaffeemaschine"). Schreiben Sie einen Konstruktor, Getter und Setter für alle Instanzvariablen und eine Methode `toString`.
> 
> Schreiben Sie eine Klasse `Box`, die Instanzvariablen für die Länge, Breite und Höhe einer Box enthält. Zusätzlich enthält die Klasse `Box` eine Instanzvariable `full` vom Typ boolean, die angibt, ob die Box gefüllt ist oder nicht, sowie eine Instanzvariable `cargo` vom Typ `Cargo`. Der Konstruktor setzt die Länge, Breite und Höhe einer Box gemäss Parametern – neu instanziierte `Box` Objekte sollen standardmässig leer sein. Definieren Sie einen zweiten Konstruktor ohne Parameter, der eine Standard-Box mit Länge, Breite und Höhe 1 generiert. Zusätzlich definieren Sie eine Methode `getCapacity`, die das Volumen der Box berechnet und zurückgibt.
> 
> Schliesslich schreiben Sie eine Methode `addCargo`, welche ein Objekt vom Typ `Cargo` als Parameter entgegennimmt. Falls dieses Stückgut gemäss Länge, Breite und Höhe in die Box passt, passen Sie die Variable `full` und die Instanzvariable `cargo` an und geben `true` zurück (andernfalls `false`).
> 
> Testen Sie die Klasse `Box`, indem Sie in einer weiteren Klasse `BoxTest` drei `Box` Objekte instanziieren, manipulieren und ausgeben.

#### Quellcode

- [Cargo.java](src/aufgabe03/Cargo.java)
- [Box.java](src/aufgabe03/Box.java)
- [BoxTest.java](src/aufgabe03/BoxTest.java



### Aufgabe 4: `Book`-Klasse Erweiterung

> Auf ILIAS (Übungen → Serie 3) finden Sie eine Datei `Book.java`. Ihre Aufgabe ist es die darin implementierte Klasse `Book` wie folgt zu erweitern:
> 
> 1. Schreiben Sie einen Konstruktor sowie Getter und Setter für alle Instanzvariablen.
> 2. Implementieren Sie die Methode `age`, welche das Alter eines Buches (Anzahl Tage seit Erscheinungsdatum) berechnet und zurückgibt.
> 3.  Implementieren Sie die Methode `toString`, die alle Informationen eines `Book`-Objekts als String zurückgibt. Beispiel: 123, Die Blechtrommel, Günter Grass, 1.1.1959
> 4. Vervollständigen Sie die Methode `input`, welche die Werte für `id`, `title`, `author` und `dateOfPublication` von der Kommandozeile vom Benutzer einliest und im jeweiligen `Book`-Objekt abspeichert. Ungültige Eingaben müssen Sie nicht abfangen.
> 
> Testen Sie sämtliche Methoden der Klasse `Book` in einer zusätzlichen Klasse `BookShelf`.

#### Quellcode

- [Book.java](src/aufgabe04/Book.java)
- [BookShelf.java](src/aufgabe04/BookShelf.java)