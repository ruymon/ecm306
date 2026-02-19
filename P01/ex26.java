/**
 * Exercicio 26:
 * Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
 * capaz de receber, via teclado, dois números inteiros e positivos, calculando o Máximo
 * Divisor Comum entre eles.
 */

import java.util.Scanner;

public class ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        System.out.println(gcd(first, second));
        scanner.close();
    }

    static int gcd(int first, int second) {
        if (second == 0) {
            return first;
        }
        return gcd(second, first % second);
    }
}
