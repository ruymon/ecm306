/**
 * Exercicio 14:
 * Utilizando programação por chamadas de métodos, elaborar um programa, em
 * linguagem Java, capaz de carregar, via teclado, os 10 elementos de um vetor do tipo
 * double. Após isto, apresentar ao operador um menu contendo 3 opções e aguardar a
 * digitação da opção por ele escolhida: Digitar '+' para apresentar o próximo elemento do
 * vetor; Digitar '-' para apresentar o elemento anterior do vetor; Digitar '. ' para sair.
 * Dependendo da opção digitada, apresentar o respectivo elemento do vetor carregado.
 * Obs.: O 1º elemento a ser apontado é o de índice 0;
 */

import java.util.Scanner;

public class ex14 {
    static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[ARRAY_SIZE];

        for (int index = 0; index < ARRAY_SIZE; index++) {
            values[index] = scanner.nextDouble();
        }

        int currentIndex = 0;
        String choice;
        do {
            choice = scanner.next();
            if (choice.equals("+")) {
                System.out.println(values[currentIndex]);
                currentIndex = (currentIndex + 1) % ARRAY_SIZE;
            } else if (choice.equals("-")) {
                currentIndex = (currentIndex - 1 + ARRAY_SIZE) % ARRAY_SIZE;
                System.out.println(values[currentIndex]);
            }
        } while (!choice.equals("."));

        scanner.close();
    }
}
