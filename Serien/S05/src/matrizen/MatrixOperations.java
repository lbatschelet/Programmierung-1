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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixOperations {

    public static int[][] readMatrix(String url) throws FileNotFoundException {

        // create scanner
        Scanner fileScanner = new Scanner(new File(url));
        Scanner lineScanner;

        // create matrix

        // get number of rows and columns
        int rows = 0;
        int columns = 0;

        // get number of rows
        while (fileScanner.hasNext()) {
            fileScanner.nextLine();
            rows++;
        }

        // reset scanner
        fileScanner = new Scanner(new File(url));

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");
            columns++;
        }

        // create matrix

        int[][] matrix = new int[rows][columns];

        // get matrix elements

        // reset scanner

        fileScanner = new Scanner(new File(url));

        for (int i = 0; i < rows; i++) {
            String line = fileScanner.nextLine();
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = lineScanner.nextInt();
            }
        }


        return matrix;
        
    }



    public static int[][] transpose(int[][] matrix) {

        // check if matrix is quadratic
        if (matrix.length != matrix[0].length) {
            System.out.println("Matrix is not quadratic!");
            return null;
        }

        // create new matrix
        int[][] transposedMatrix = new int[matrix.length][matrix[0].length];

        // transpose matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }


    public static int[][] product(int[][] matrixA, int[][] matrixB) {
        
        // check if matrixA and matrixB have the same number of columns
        if (matrixA[0].length != matrixB.length) {
            System.out.println("Number of columns of matrixA does not match number of rows of matrixB!");
            return null;
        }

        // create new matrix
        int[][] productMatrix = new int[matrixA.length][matrixB[0].length];

        // calculate product
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return productMatrix;
    }

    public static void printMatrix(int[][] matrix) {

        try {
            // get number of rows and columns
            int rows = matrix.length;
            int columns = matrix[0].length;

            // print matrix
            for (int i = 0; i < rows; i++) {
                System.out.print("| ");
                for (int j = 0; j < columns ; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println("|");
            }
        } catch (NullPointerException e) {
            System.out.println("Matrix is null! Cannot print matrix.");
        }
        
    }

    // helper method to input matrix from console (for testing purposes)
    public static int[][] inputMatrix() {

        // create scanner
        Scanner scan = new Scanner(System.in);

        // get number of rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scan.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scan.nextInt();

        // create matrix
        int[][] matrix = new int[rows][columns];

        // get matrix elements
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + ":");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();

        return matrix;

    }
    
}
