/**
 * Exercicio 20:
 * Rescrever o exercício no. 14 desta lista, utilizando métodos com passagem de
 * parâmetros;
 */

import java.util.Scanner;

public class ex20 {
    static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = populateArray(scanner);

        int currentIndex = 0;
        String choice;
        do {
            choice = scanner.next();
            if (choice.equals("+")) {
                currentIndex = showNextElement(values, currentIndex);
            } else if (choice.equals("-")) {
                currentIndex = showPreviousElement(values, currentIndex);
            }
        } while (!choice.equals("."));

        scanner.close();
    }

    static double[] populateArray(Scanner scanner) {
        double[] values = new double[ARRAY_SIZE];
        for (int index = 0; index < ARRAY_SIZE; index++) {
            values[index] = scanner.nextDouble();
        }
        return values;
    }

    static int showNextElement(double[] values, int currentIndex) {
        System.out.println(values[currentIndex]);
        return (currentIndex + 1) % ARRAY_SIZE;
    }

    static int showPreviousElement(double[] values, int currentIndex) {
        int previousIndex = (currentIndex - 1 + ARRAY_SIZE) % ARRAY_SIZE;
        System.out.println(values[previousIndex]);
        return previousIndex;
    }
}
