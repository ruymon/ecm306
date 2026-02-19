/**
 * Exercicio 21:
 * Elaborar um programa, em linguagem Java, para calcular o fatorial de um número
 * a ser digitado. Criar um método para cálculo do mesmo utilizando recursividade;
 */

import java.util.Scanner;

public class ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(factorial(number));
        scanner.close();
    }

    static int factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
