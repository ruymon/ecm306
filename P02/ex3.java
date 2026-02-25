public class ex3 {
    public static void main(String[] args) {
        int[][] dims = {
            {10, 10}, {50, 75}, {100, 300}, {500, 200}, {1000, 1000},
            {5000, 7000}, {10000, 1}, {50000, 25000}, {100000, 100000}, {500000, 1000}
        };
        int repeats = 5;

        System.out.println("Exercicio 3: Limpar (colocar -1) matrizes double N x M");
        System.out.println();
        System.out.printf("%-12s %-20s %-25s %-20s%n", "N x M", "Tempo Medio (ns)", "Op. Aritmeticas (med)", "Comparacoes (med)");
        System.out.println("-".repeat(77));

        for (int[] dim : dims) {
            int N = dim[0];
            int M = dim[1];

            long totalTime = 0;
            long totalArith = 0;
            long totalComp = 0;
            boolean memError = false;

            for (int r = 0; r < repeats; r++) {
                long arith = 0;
                long comp = 0;

                try {
                    double[][] matriz = new double[N][M];

                    long start = System.nanoTime();

                    arith++; // i = 0
                    for (int i = 0; i < N; i++) {
                        comp++;  // i < N (true)
                        arith++; // j = 0
                        for (int j = 0; j < M; j++) {
                            comp++;  // j < M (true)
                            matriz[i][j] = -1;
                            arith++; // matriz[i][j] = -1
                            arith++; // j++
                        }
                        comp++; // j < M (false)
                        arith++; // i++
                    }
                    comp++; // i < N (false)

                    long end = System.nanoTime();

                    totalTime += (end - start);
                    totalArith += arith;
                    totalComp += comp;
                } catch (OutOfMemoryError e) {
                    memError = true;
                    break;
                }
            }

            String label = N + " x " + M;
            if (memError) {
                System.out.printf("%-12s %-20s %-25s %-20s%n", label, "MEMORIA INSUF.", "MEMORIA INSUF.", "MEMORIA INSUF.");
            } else {
                System.out.printf("%-12s %-20d %-25d %-20d%n",
                        label, totalTime / repeats, totalArith / repeats, totalComp / repeats);
            }
        }
    }
}
