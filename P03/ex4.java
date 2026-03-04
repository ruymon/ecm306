/**
 * Elaborar um programa, em linguagem Java, capaz de informar quando uma matriz N
 * por N, do tipo int, é simétrica (quando a matriz analisada for igual à sua transposta),
 * onde N deve ser: 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000 e 500000.
 */
public class ex4 {

    static boolean ehSimetrica(int[][] matriz, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000};

        System.out.println("Exercicio 4 - Modelo de Knuth (pior caso: matriz simetrica)");
        System.out.println("Detalhado: T(N) = 3N^2/2 + 5N/2 + 2");
        System.out.println("Simplificado: T(N) = O(N^2)");
        System.out.println();
        System.out.printf("%-10s %-22s %-15s%n", "N", "Detalhado T(N)", "Simplificado");
        System.out.println("-".repeat(47));

        for (int N : sizes) {
            long n = N;
            long detalhado = (3 * n * n + 5 * n) / 2 + 2;
            long simplificado = n * n;
            System.out.printf("%-10d %-22d %-15s%n", N, detalhado, simplificado + " (N^2)");
        }
    }
}
