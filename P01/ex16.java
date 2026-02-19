/**
 * Exercicio 16:
 * Elaborar um método, em linguagem Java, com passagem de parâmetros, dentro de
 * um programa teste, capaz de informar se o número digitado é par ou impar. A digitação
 * do valor e a apresentação do resultado deverá acontecer externamente a este método;
 */

import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean isEven = isEvenNumber(number);
        if (isEven) {
            System.out.println("Par.");
        } else {
            System.out.println("Ímpar.");
        }
        scanner.close();
    }

    static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
