/**
 * Exercicio 12:
 * Criar um método, que se utilize de malhas, capaz de informar se o número inteiro
 * e maior que zero digitado pelo operador é ou não primo. Este método deverá ser
 * utilizado por um programa em linguagem Java, que pedirá ao operador a digitação do
 * número, verificará se o mesmo é ou não primo e apresentará a conclusão em tela;
 */

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro maior que zero:");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println("O número " + number + " é primo.");
        } else {
            System.out.println("O número " + number + " não é primo.");
        }
        scanner.close();
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int divisor = 2;
        while (divisor <= number / 2) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}
