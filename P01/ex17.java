/**
 * Exercicio 17:
 * Rescrever o exercício no. 11 desta lista, utilizando métodos com passagem de
 * parâmetros;
 */

import java.util.Scanner;

public class ex17 {
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
