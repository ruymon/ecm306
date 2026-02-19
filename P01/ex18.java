/**
 * Exercicio 18:
 * Rescrever o exercício no. 12 desta lista, utilizando métodos com passagem de
 * parâmetros;
 */

import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
