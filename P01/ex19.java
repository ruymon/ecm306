/**
 * Exercicio 19:
 * Rescrever o exercício no. 13 desta lista, utilizando métodos com passagem de
 * parâmetros;
 */

import java.util.Scanner;

public class ex19 {
    static final int SAMPLE_COUNT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] lengths = new double[SAMPLE_COUNT];
        double[] diameters = new double[SAMPLE_COUNT];

        for (int index = 0; index < SAMPLE_COUNT; index++) {
            lengths[index] = scanner.nextDouble();
            diameters[index] = scanner.nextDouble();
        }

        double averageLength = calculateAverage(lengths);
        double averageDiameter = calculateAverage(diameters);
        System.out.println("Comprimento médio: " + averageLength);
        System.out.println("Diâmetro médio: " + averageDiameter);

        int longestSampleIndex = getLongestSampleIndex(lengths);
        System.out.println("Amostra mais longa: número " + (longestSampleIndex + 1) + ", comprimento " + lengths[longestSampleIndex]);

        int thinnestSampleIndex = getThinnestSampleIndex(diameters);
        System.out.println("Amostra mais fina: número " + (thinnestSampleIndex + 1) + ", diâmetro " + diameters[thinnestSampleIndex]);

        scanner.close();
    }

    static double calculateAverage(double[] values) {
        double sum = 0;
        for (int index = 0; index < values.length; index++) {
            sum += values[index];
        }
        return sum / values.length;
    }

    static int getLongestSampleIndex(double[] values) {
        int maxIndex = 0;
        for (int index = 1; index < values.length; index++) {
            if (values[index] > values[maxIndex]) {
                maxIndex = index;
            }
        }
        return maxIndex;
    }

    static int getThinnestSampleIndex(double[] values) {
        int minIndex = 0;
        for (int index = 1; index < values.length; index++) {
            if (values[index] < values[minIndex]) {
                minIndex = index;
            }
        }
        return minIndex;
    }
}
