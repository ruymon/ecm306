/**
 * Exercicio 11:
 * Utilizando programação por chamadas de métodos, elaborar um programa, em
 * linguagem Java, capaz de receber os valores de a, b e c de uma equação de 2º grau
 * qualquer ( a x2 + b x + c = 0 ), calcular e apresentar o valor de Δ (delta) e informar se suas
 * raízes são imaginárias, reais iguais ou reais diferentes, apresentando seus valores para
 * os casos quando foram reais. Dica: Criar um método para calcular a raiz 1 e outro
 * método para calcular a raiz 2;
 */

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double delta = calculateDelta(a, b, c);
        System.out.println("Delta: " + delta);

        if (delta < 0) {
            System.out.println("Raizes imaginarias.");
        } else if (delta == 0) {
            double root = calculateFirstRoot(a, b, delta);
            System.out.println("Raizes reais iguais: " + root);
        } else {
            double root1 = calculateFirstRoot(a, b, delta);
            double root2 = calculateSecondRoot(a, b, delta);
            System.out.println("Raizes reais diferentes: " + root1 + " e " + root2);
        }
        scanner.close();
    }

    static double calculateDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    static double calculateFirstRoot(double a, double b, double delta) {
        return (-b + Math.sqrt(delta)) / (2 * a);
    }

    static double calculateSecondRoot(double a, double b, double delta) {
        return (-b - Math.sqrt(delta)) / (2 * a);
    }
}
