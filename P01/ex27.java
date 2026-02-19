/**
 * Exercicio 27:
 * Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
 * capaz de receber, via teclado, dois números inteiros e positivos, calculando o primeiro
 * elevado ao segundo.
 */

import java.util.Scanner;

public class ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int exponent = scanner.nextInt();
        System.out.println(power(base, exponent));
        scanner.close();
    }

    static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
}
