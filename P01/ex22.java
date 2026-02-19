/**
 * Exercicio 22:
 * Elaborar um programa, em linguagem Java, para calcular o N-ésimo elemento da
 * série de Fibonacci. O índice desse elemento deverá ser digitado para a realização do
 * cálculo. Criar um método que calcula o resultado da série, utilizando-se da
 * recursividade.
 * Série de Fibonacci: O próximo elemento tem o valor igual à soma dos dois elementos
 * anteriores da série: 1, 1, 2, 3, 5, 8, 13, 21, ..., ∞;
 */

import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int termIndex = scanner.nextInt();
        System.out.println(fibonacci(termIndex));
        scanner.close();
    }

    static int fibonacci(int termIndex) {
        if (termIndex <= 0) {
            return 0;
        }
        if (termIndex == 1 || termIndex == 2) {
            return 1;
        }
        return fibonacci(termIndex - 1) + fibonacci(termIndex - 2);
    }
}
