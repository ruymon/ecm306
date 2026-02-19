/**
 * Exercicio 5:
 * Dado um vetor do tipo int de 16 elementos, a serem digitados aleatoriamente, elaborar um programa, em linguagem Java,
 * capaz de apresentar a quantidade de capicuas de 4 elementos existentes ao longo desse vetor (capicua: número que representa o
 * mesmo valor quando lido da esquerda para a direita e vice-versa).
 *
 * Exemplo: Vetor digitado índices: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 elementos: 0 1 1 0 3 2 4 4 2 2 4 7 7 7 7 7; Total de Capicuas: 5
 * Obs.: Foram encontradas as seguintes capicuas: 0110 (índices 0, 1, 2 e 3), 2442 (índices 5, 6, 7 e 8), 4224 (índices 7, 8, 9 e 10), 7777 (índices 11, 12, 13 e 14) e 7777 (índices 12, 13, 14 e 15).
 */

import java.util.Scanner;

public class ex5 {
    static final int ARRAY_SIZE = 16;
    static final int CAPICUA_SIZE = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] digits = new int[ARRAY_SIZE];

        for (int index = 0; index < ARRAY_SIZE; index++) {
            digits[index] = scanner.nextInt();
        }

        int capicuaCount = 0;
        for (int start = 0; start <= ARRAY_SIZE - CAPICUA_SIZE; start++) {
            if (isCapicua(digits, start)) {
                capicuaCount++;
            }
        }

        System.out.println("Total de Capicuas: " + capicuaCount);
        scanner.close();
    }

    static boolean isCapicua(int[] values, int startIndex) {
        int first = values[startIndex];
        int second = values[startIndex + 1];
        int third = values[startIndex + 2];
        int fourth = values[startIndex + 3];
        return first == fourth && second == third;
    }
}
