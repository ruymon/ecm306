/**
 * Elaborar um programa, em linguagem Java, capaz de limpar (colocar -1 em todas as
 * posições) matrizes de dimensões N por M, do tipo double, onde N e M devem ser,
 * respectivamente: 10 e 10; 50 e 75; 100 e 300; 500 e 200; 1000 e 1000; 5000 e 7000;
 * 10000 e 1; 50000 e 25000; 100000 e 100000; e 500000 e 1000.
 */
public class ex3 {

    static void limparMatriz(double[][] matriz, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] dims = {
            {10, 10}, {50, 75}, {100, 300}, {500, 200}, {1000, 1000},
            {5000, 7000}, {10000, 1}, {50000, 25000}, {100000, 100000}, {500000, 1000}
        };

        System.out.println("Exercicio 3 - Modelo de Knuth");
        System.out.println("Detalhado: T(N,M) = 3NM + 3N + 2");
        System.out.println("Simplificado: T(N,M) = O(NM)");
        System.out.println();
        System.out.printf("%-18s %-12s %-22s %-15s%n", "N x M", "N*M", "Detalhado T(N,M)", "Simplificado");
        System.out.println("-".repeat(67));

        for (int[] dim : dims) {
            int N = dim[0];
            int M = dim[1];
            long NM = (long) N * M;
            long detalhado = 3L * NM + 3L * N + 2;
            System.out.printf("%-18s %-12d %-22d %-15s%n",
                    N + " x " + M, NM, detalhado, NM + " (NM)");
        }
    }
}
