/**
 * Exercicio 7:
 * Determinar a matriz transposta de uma matriz global qualquer e digitada, através de um programa em linguagem Java. Uma matriz é dita transposta quando a matriz original tiver suas linhas transformadas em colunas e suas colunas transformadas em linhas.
 */

import java.util.Scanner;

public class ex7 {
    static final int ROWS = 2;
    static final int COLS = 3;

    static int[][] matrix = new int[ROWS][COLS];
    static int[][] transposed = new int[COLS][ROWS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                transposed[col][row] = matrix[row][col];
            }
        }

        for (int row = 0; row < COLS; row++) {
            for (int col = 0; col < ROWS; col++) {
                System.out.print(transposed[row][col] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
