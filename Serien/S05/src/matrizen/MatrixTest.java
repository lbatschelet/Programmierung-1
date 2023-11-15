package matrizen;

import java.io.FileNotFoundException;

public class MatrixTest {

    private final static String FILE_PATH_NAME = "/Users/lukasbatschelet/Library/CloudStorage/OneDrive-UniversitaetBern/Studium/HS23/Programmierung_1/Serien/S05/src/matrizen/matrix.txt";

    public static void main(String[] args) throws FileNotFoundException {
        
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrix2 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        int[][] matrix3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix 1:");
        MatrixOperations.printMatrix(matrix1);

        System.out.println("Matrix 2:");
        MatrixOperations.printMatrix(matrix2);

        System.out.println("Matrix 3:");
        MatrixOperations.printMatrix(matrix3);

        System.out.println("Transpose Matrix 1:");
        MatrixOperations.printMatrix(MatrixOperations.transpose(matrix1));

        System.out.println("Transpose Matrix 2:");
        MatrixOperations.printMatrix(MatrixOperations.transpose(matrix2));

        System.out.println("Transpose Matrix 3:");
        MatrixOperations.printMatrix(MatrixOperations.transpose(matrix3));


        System.out.println("Product Matrix 1 x 2:");
        MatrixOperations.printMatrix(MatrixOperations.product(matrix1, matrix2));

        System.out.println("Product Matrix 2 x 1:");
        MatrixOperations.printMatrix(MatrixOperations.product(matrix2, matrix1));

        System.out.println("Read matrix:");
        MatrixOperations.printMatrix(MatrixOperations.readMatrix(FILE_PATH_NAME));

        System.out.println("Transpose read matrix:");
        MatrixOperations.printMatrix(MatrixOperations.transpose(MatrixOperations.readMatrix(FILE_PATH_NAME)));


    }
    
}
