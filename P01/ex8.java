/**
 * Exercicio 8:
 * Elaborar um programa, em linguagem Java, capaz de informar quando uma matriz
 * qualquer é simétrica. Essa matriz deverá ser global e todos os seus elementos digitados.
 * Uma matriz é dita simétrica quando ela for igual à sua transposta.
 */

import java.util.Scanner;

public class ex8 {
    static final int MATRIX_SIZE = 3;

    static int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        if (isSymmetric()) {
            System.out.println("A matriz é simétrica.");
        } else {
            System.out.println("A matriz não é simétrica.");
        }
        scanner.close();
    }

    static boolean isSymmetric() {
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                if (matrix[row][col] != matrix[col][row]) {
                    return false;
                }
            }
        }
        return true;
    }
}
