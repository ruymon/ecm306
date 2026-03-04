/**
 * Elaborar um programa, em linguagem Java, capaz inicializar com 0 (zero) um vetor
 * do tipo int de N elementos, utilizando laços, onde N deve ser: 10, 50, 100, 500, 1000,
 * 5000, 10000, 50000, 100000 e 500000.
 */
public class ex1 {

    static void inicializarVetor(int[] vetor, int N) {
        for (int i = 0; i < N; i++) {
            vetor[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000};

        System.out.println("Exercicio 1 - Modelo de Knuth");
        System.out.println("Detalhado: T(N) = 3N + 2");
        System.out.println("Simplificado: T(N) = O(N)");
        System.out.println();
        System.out.printf("%-10s %-20s %-15s%n", "N", "Detalhado T(N)", "Simplificado");
        System.out.println("-".repeat(45));

        for (int N : sizes) {
            long detalhado = 3L * N + 2;
            System.out.printf("%-10d %-20d %-15s%n", N, detalhado, N + " (N)");
        }
    }
}
