/**
 * Exercicio 23:
 * Utilizando recursividade, criar um programa, em linguagem Java, que calcule e
 * apresente a soma de todos os elementos de um vetor, inteiro, de tamanho 10, o qual
 * deverá ser preenchido, anteriormente ao cálculo, pelo operador;
 */

import java.util.Scanner;

public class ex23 {
    static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[ARRAY_SIZE];
        for (int index = 0; index < ARRAY_SIZE; index++) {
            values[index] = scanner.nextInt();
        }

        System.out.println(sumRecursive(values, 0));
        scanner.close();
    }

    static int sumRecursive(int[] values, int index) {
        if (index >= values.length) {
            return 0;
        }
        return values[index] + sumRecursive(values, index + 1);
    }
}
