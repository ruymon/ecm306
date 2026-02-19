/**
 * Exercicio 29:
 * Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
 * capaz de receber, via teclado, dois números inteiros e positivos, calculando a subtração
 * do segundo no primeiro, porém, não se utilizando da subtração para realizar o cálculo e
 * sim a operação de comparação sucessivamente.
 * Exemplo: 5 – 3 => 3+1 = 4; 3+2=5. Portanto 5 – 3 = 2.
 */

import java.util.Scanner;

public class ex29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valueToSubtractFrom = scanner.nextInt();
        int valueToSubtract = scanner.nextInt();
        System.out.println(subtractByComparison(valueToSubtractFrom, valueToSubtract));
        scanner.close();
    }

    static int subtractByComparison(int targetValue, int currentValue) {
        if (currentValue >= targetValue) {
            return 0;
        }
        return 1 + subtractByComparison(targetValue, currentValue + 1);
    }
}
