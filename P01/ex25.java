/**
 * Exercicio 25:
 * Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
 * capaz de receber, via teclado, 10 elementos tipo float, formando um vetor, e um outro
 * elemento tipo float, o qual deverá ser comparado à cada elemento do vetor. O programa
 * deverá informar o valor do primeiro índice do vetor, a partir do 0, que contém um
 * elemento igual ao valor digitado. Ex.:
 * Índice: 0 1 2 3 4 5 6 7 8 9
 * Elementos Digitados: 1 2 3 4 5 6 7 8 9 10
 * Número Digitado: 4 → Resposta: O número 4 está localizado no índice 3 do vetor.
 */

import java.util.Scanner;

public class ex25 {
    static final int SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] values = new float[SIZE];
        for (int index = 0; index < SIZE; index++) {
            values[index] = scanner.nextFloat();
        }
        float target = scanner.nextFloat();

        int foundIndex = indexOfRecursive(values, target, 0);
        if (foundIndex >= 0) {
            System.out.println("O número " + target + " está localizado no índice " + foundIndex + " do vetor.");
        } else {
            System.out.println("Não encontrado.");
        }
        scanner.close();
    }

    static int indexOfRecursive(float[] values, float target, int index) {
        if (index >= values.length) {
            return -1;
        }
        if (values[index] == target) {
            return index;
        }
        return indexOfRecursive(values, target, index + 1);
    }
}
