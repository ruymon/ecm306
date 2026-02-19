/**
 * Exercicio 9:
 * Determinar se uma matriz é identidade (ou unidade), através de um programa em
 * linguagem Java. A matriz deverá ser global e todos os seus elementos digitados. Uma
 * matriz é dita identidade (ou unidade) quando ela for quadrada (no. de linhas iguais ao
 * no. de colunas), tiver todos os elementos de sua diagonal principal (no. da linha igual ao
 * no. da coluna) iguais a 1 (um) e todos os demais elementos iguais a 0 (zero).
 */

import java.util.Scanner;

public class ex9 {
    static final int MATRIX_SIZE = 3;

    static int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        if (isIdentityMatrix()) {
            System.out.println("A matriz é identidade.");
        } else {
            System.out.println("A matriz não é identidade.");
        }
        scanner.close();
    }

    static boolean isIdentityMatrix() {
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                if (row == col) {
                    if (matrix[row][col] != 1) {
                        return false;
                    }
                } else {
                    if (matrix[row][col] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
