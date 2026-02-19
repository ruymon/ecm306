/**
 * Exercicio 31:
 * Reescrever o exercício anterior, porém colocando mensagens dentro do método
 * recursivo, de valores de entrada e valores de retorno, afim de acompanhar-se a
 * evolução da execução do programa.
 */

import java.util.Scanner;

public class ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int termCount = scanner.nextInt();
        System.out.println(seriesSumRecursive(termCount));
        scanner.close();
    }

    static double seriesSumRecursive(int termCount) {
        System.out.println("Entrada: " + termCount);
        if (termCount <= 0) {
            System.out.println("Retorno: 0.0 (caso base)");
            return 0;
        }
        double term = 1.0 / Math.pow(2, termCount - 1);
        double recursiveSum = seriesSumRecursive(termCount - 1);
        double result = term + recursiveSum;
        System.out.println("Retorno: " + result);
        return result;
    }
}
