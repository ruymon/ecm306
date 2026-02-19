/**
 * Exercicio 13:
 * Da linha de produção de uma metalúrgica serão pegos, aleatoriamente, no decorrer
 * de um dia, pelo controle de qualidade da empresa, 10 pregos sem cabeça para análise.
 * Para cada amostra de prego pego, serão medidos seu comprimento e diâmetro, ambos
 * em milímetros. Durante a medição, esses dados serão inseridos, um a um, em um
 * programa de computador desenvolvido especialmente para isso. Após a digitação dos
 * 10 pares de valores (comprimento e diâmetro), o programa deverá fornecer:
 * a) Comprimento e Diâmetro Médios das amostras verificadas;
 * b) O número e o comprimento da amostra mais longa (comprimento maior);
 * c) O número e o diâmetro da amostra mais fina (diâmetro menor).
 * Obs.: Valor médio do comprimento das amostras: Cmédio = (C1+C2+ ... + C9 + C10) / 10
 * Valor médio do diâmetro das amostras: Dmédio = (D1+D2+ ... + D9 + D10) / 10
 */

import java.util.Scanner;

public class ex13 {
    static final int SAMPLES = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] lengths = new double[SAMPLES];
        double[] diameters = new double[SAMPLES];

        for (int index = 0; index < SAMPLES; index++) {
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
