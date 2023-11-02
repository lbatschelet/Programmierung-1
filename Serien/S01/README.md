# Serie 01

Lukas Batschelet (16-499-733)

## Theorieaufgaben

### 1. Bezeichner

> Finden Sie passende Bezeichner für...
> - eine Java Klasse, die eine Prüfung repräsentieren soll.
> - die erreichten Punkte in einer Prüfung.
> - eine Methode, welche den Durchschnittswert aller Prüfungen berechnet.
> - die maximale Punktzahl, die in einer Prüfung erreicht werden kann.

<details>
    <summary>Lösung anzeigen</summary>

```java
1. public class Exam {}
2. int points
3. meanPoints()
4. final int MAX_POINTS
```

</details>
  
### 2. Variablen und Eigenschaften

> Finden Sie für die Klasse `Flight` mindestens drei Variablen (Eigenschaften) und drei Methoden (Verhalten/Funktionen), die in den Klassen modelliert werden könnten.

<details>
    <summary>Mögliche Lösung anzeigen</summary>

#### 2.1 Variablen

1. `altitude`
2. `cargoWeight`
3. `fuelRemaining`

#### 2.2 Methoden

1. `bookSeat()`
2. `cancelFlight()`
3. `readFuelLevel()`

</details>

### 3. Zitat

> Schreiben Sie eine einzige `println` Anweisung, die die folgende Zeichenkette als Ausgabe generiert:
>  
> ```
> "Mein Name ist Winston Wolfe.  
> Ich löse Probleme!", stellte er sich vor.
> ```

<details>
    <summary>Lösung anzeigen</summary>

```java
System.out.println("\"Mein Name ist Winston Wolfe. \n" +
	"Ich löse Probleme!\", stellte er sich vor.");
```

</details>

### 4. Rechnung

> Welchen Wert enthält die Variable `result`, nachdem folgende Anweisungen durchgeführt worden sind?
>
> ```java  
> int result = 25;  
> result = result + 5;  
> result = result / 7;  
> result = result * 3;  
> ```

<details>
    <summary>Lösung anzeigen</summary>

```java
int result = 25;
result = result + 5; //30
result = result / 7; //4
result = result * 3; //12
```

</details>

### 5. Rechnung

> Welchen Wert enthält die Variable `result`, nachdem folgende Anweisungen durchgeführt worden sind?
> 
> ```java  
> int result = 15, total = 100, min = 15, num = 10;  
> result /= (total - min) % num;  
> ```

<details>
    <summary>Lösung anzeigen</summary>

```java
int result = 15, total = 100, min = 15, num = 10;
result /= (total – min) % num;
result = result / ((total – min) % num;
3 = 15 / (( 100 - 15) % 10;
```

</details>

### 6. Operationen

> Gegeben seien folgende Deklarationen:
>
> ```java  
> int result1, num1 = 27, num2 = 5;  
> double result2, num3 = 12.0;  
> ```
>
> Welches Resultat wird jeweils durch folgende Anweisungen gespeichert?
>
> 1. `result1 = num1 / num2;`  
> 2. `result2 = num1 / num2;`  
> 3. `result2 = num3 / num2;`  
> 4. `result1 = (int) num3 / num2;`  
> 5. `result2 = (double) num1 / num2;`

<details>
    <summary>Lösung anzeigen</summary>

```java
int result1, num1 = 27, num2 =5;
double result2, num3 = 12.0;
a. result1 = num1 / num2; //5.0
b. result2 = num1 / num2; //5.4
c. result2 = num3 / num2; //2.4
d. result1 = (int) num3 / num2; //2
e. result2 = (double) num1 / num2; //5.4
```

</details>

### 7. Boolsche Operationen

> Gegeben seien folgende Deklarationen:
>
> ```java  
> int val1 = 15, val2 = 20;  
> boolean ok = false;  
> ```
>
> Was ist der Wert der folgenden Booleschen Ausdrücke?
>
> 1. `val1 <= val2`  
> 2. `(val1 + 5) >= val2`  
> 3. `val1 < val2 / 2`  
> 4. `val1 != val2`  
> 5. `!(val1 == val2)`  
> 6. `(val1 < val2) || ok`  
> 7. `(val1 > val2) || ok`  
> 8. `(val1 < val2) && !ok`  
> 9. `ok || !ok`

<details>
    <summary>Lösung anzeigen</summary>

```java
int val1 = 15, val2 = 20;
Boolean ok = false;
a. true
b. true
c. false
d. true
e. true
f. true
g. false
h. true
i. true
```

</details>

## Implementationsaufgaben

### 1. Einfache Ausgabe - `WinterIsComing.java`

> Schreiben Sie ein Programm, welches den Satz "Winter is coming" ausgibt (erste Version: auf einer Zeile; zweite Version: jedes Wort auf einer separaten Zeile).

#### Quellcode

- [WinterIsComing.java](src/aufgabe01/WinterIsComing.java)

### 2. Einfache Berechnungen - `Quotient.java`

> Schreiben Sie ein Programm, das vom Benutzer die Eingabe von zwei ganzzahligen Werten `a` und `b` fordert. Ihr Programm soll den Quotienten `a²/b` sowohl als Gleitkommazahl (d.h. ungerundet) als auch als ganze Zahl mit Rest berechnen und beide Ergebnisse am Bildschirm ausgeben. Testen Sie Ihr Programm mit beliebigen Zahlen.
> 
> Beobachten Sie insbesondere das Programmverhalten bei Eingabe der Zahl `0` als Divisor und versuchen Sie diesen Laufzeitfehler abzufangen.

#### Quellcode

- [Quotient.java](src/aufgabe02/Quotient.java)

### 3. Benutzerinteraktion - `HumanThermometer.java`

> Schreiben Sie ein Programm, das vom Benutzer die Eingabe einer Temperatur `t` fordert. Die Ausgabe Ihres Programmes definiert sich danach folgendermassen:  

![HumanThermometerCases.png](HumanThermometerCases.png)

> Hinweis: Verwenden Sie Konstanten für beide Temperaturgrenzen.

#### Quellcode

- [HumanThermometer.java](src/aufgabe03/HumanThermometer.java)