/**
 * Exercicio 24:
 * Criar um método, em linguagem Java, que se utilize da recursividade, dentro de um
 * programa capaz de receber, via teclado, um número inteiro qualquer e informar se o
 * mesmo é ou não primo;
 */

import java.util.Scanner;

public class ex24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (isPrimeRecursive(number, 2)) {
            System.out.println("O número " + number + " é primo.");
        } else {
            System.out.println("O número " + number + " não é primo.");
        }
        scanner.close();
    }

    static boolean isPrimeRecursive(int number, int divisor) {
        if (number <= 1) {
            return false;
        }
        if (divisor > number / 2) {
            return true;
        }
        if (number % divisor == 0) {
            return false;
        }
        return isPrimeRecursive(number, divisor + 1);
    }
}
