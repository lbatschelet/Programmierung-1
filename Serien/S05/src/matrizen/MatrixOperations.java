/**
 * 2. Rechnen mit Matrizen
 * Anmerkungen:
 * - Diese Aufgabe erfordert den Gebrauch statischer Methoden und der
 *   Klasse Scanner zum Einlesen von Daten aus einer Datei. Beides wird
 *   nächste Woche in der Vorlesung eingeführt. Wir empfehlen, die folgenden
 *   Teilaufgaben erst nach dem Studium von Kapitel 8 zu lösen!
 * - In den folgenden Teilaufgaben werden die Matrizen A, B, C als 2-
 *   dimensionale Arrays dargestellt (z.B. int[][] A = new int[m][n];).
 *
 * (a) Schreiben Sie in einer Klasse MatrixOperations eine statische Methode
 *     readMatrix, welche die Daten einer Matrix aus einer Datei einliest.
 *     Eine Matrix-Datei sei dabei folgendermassen formatiert:
 *     1 2 3
 *     4 5 6
 *     Speichern Sie die eingelesenen Daten in einem 2-dimensionalen Array.
 *
 * (b) Schreiben Sie in der Klasse MatrixOperations eine statische Methode
 *     transpose, welche eine n×n Matrix A als Parameter erhält und
 *     A^T (die transponierte Matrix A) zurückgibt. Falls die übergebene
 *     Matrix nicht quadratisch sein sollte, erzeugen Sie eine Fehlermeldung
 *     und geben null zurück. Beim Transponieren einer Matrix spiegelt
 *     man einen Matrixeintrag a_ij an der Diagonalen von A. Einfach gesagt,
 *     aus a_ij wird a_ji.
 *     A =                       A^T =
 *     | a00 a01 a02 |           | a00 a10 a20 |
 *     | a10 a11 a12 |           | a01 a11 a21 |
 *     | a20 a21 a22 |           | a02 a12 a22 |

 *     Ihre Methode sollte alle möglichen Werte von n berücksichtigen.
 *
 * (c) Schreiben Sie in der Klasse MatrixOperations eine statische Methode
 *     product, welche ein n × m Matrix A und eine m × l Matrix B
 *     als Parameter entgegennimmt und das Produkt C = AB zurückgibt.
 *     Die Dimension von C ist n×l und die Einträge c_ij berechnen sich wie folgt:
 *     c_ij = sum(a_ik * b_kj) für k von 0 bis n-1
 *     Ihre Methode sollte alle möglichen Werte von m, n und l berücksichtigen.
 *     Falls die Anzahl Spalten von A nicht mit der Anzahl Zeilen von B
 *     übereinstimmen sollte, erzeugen Sie eine Fehlermeldung und geben
 *     Sie null zurück.
 *     Beispielrechnung:
 *                      B = |  1  2  3 |
 *                          |  4  5  6 |
 *                             
 *     Input: A = | 1 2 |   |  9 12 15 | = C: Output
 *                | 3 4 |   | 19 26 33 |
 *                | 5 6 |   | 29 40 51 |
 *
 * (d) Erstellen Sie eine Klasse MatrixTest.java in der Sie die Methoden
 *     readMatrix, transpose und product mit geeigneten Beispielen testen.
 *     Achten Sie darauf bei der Methode transpose und product auch den
 *     Fehlerfall zu testen.
 */


package matrizen;

public class MatrixOperations {

    // TODO: implement readMatrix

    public static int[][] readMatrix(String filename) {
        return null;
    }


    // TODO: implement transpose

    public static int[][] transpose(int[][] matrix) {
        return null;
    }

    // TODO: implement product

    public static int[][] product(int[][] matrixA, int[][] matrixB) {
        return null;
    }
    
}
