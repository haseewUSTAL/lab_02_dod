package ru.university.lab2;

/**
 * Задание № 6 — Многомерные массивы
 * (Табличный вывод, транспонирование и умножение матриц с проверкой согласованности размеров)
 */
public class Task06Matrices {

    public void run() {
        System.out.println("--- 1. Matrix Creation & Formatted Output ---");
        int[][] matrix = {
                {5, 12, 3},
                {8,  1, 9},
                {4,  7, 2}
        };
        printMatrix("Original Matrix:", matrix);

        System.out.println("\n--- 2. Matrix Transposition ---");
        int[][] transposed = transpose(matrix);
        printMatrix("Transposed Matrix:", transposed);

        System.out.println("\n--- 3. Matrix Multiplication ---");
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] b = {
                {7, 8},
                {9, 1},
                {2, 3}
        };
        printMatrix("Matrix A (2x3):", a);
        printMatrix("Matrix B (3x2):", b);

        int[][] product = multiply(a, b);
        if (product != null) {
            printMatrix("Product A * B (2x2):", product);
        }

        System.out.println("\nTesting incompatible dimensions check:");
        multiply(matrix, b);
    }

    // 1. Вывод матрицы в виде таблицы с выравниванием
    public void printMatrix(String label, int[][] matrix) {
        System.out.println(label);
        if (matrix == null) {
            System.out.println("null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println("]");
        }
    }

    // 2. Транспонирование матрицы
    public int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0][0];
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // 3. Умножение матриц с проверкой согласованности размеров
    public int[][] multiply(int[][] a, int[][] b) {
        if (a == null || b == null) {
            System.out.println("Error: One of the matrices is null.");
            return null;
        }

        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        // Число столбцов первой матрицы должно быть равно числу строк второй
        if (colsA != rowsB) {
            System.out.println("Error: Incompatible dimensions. Columns of A (" + colsA + ") != Rows of B (" + rowsB + ").");
            return null;
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}