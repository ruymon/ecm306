/**
 * Exercicio 28:
 * Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
 * capaz de receber, via teclado, dois números inteiros e positivos, calculando a
 * multiplicação entre esses dois números, porém, não se utilizando a multiplicação para
 * realizar o cálculo e sim a operação de soma sucessiva.
 * Exemplo: 4 * 3 é igual a 3 + 3 + 3 + 3.
 */

import java.util.Scanner;

public class ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        System.out.println(multiplyByAddition(first, second));
        scanner.close();
    }

    static int multiplyByAddition(int first, int second) {
        if (first == 0 || second == 0) {
            return 0;
        }
        return second + multiplyByAddition(first - 1, second);
    }
}
