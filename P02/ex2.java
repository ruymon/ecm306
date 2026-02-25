public class ex2 {
    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000};
        int repeats = 5;

        System.out.println("Exercicio 2: Copiar vetor int de N elementos para outro vetor");
        System.out.println();
        System.out.printf("%-10s %-20s %-25s %-20s%n", "N", "Tempo Medio (ns)", "Op. Aritmeticas (med)", "Comparacoes (med)");
        System.out.println("-".repeat(75));

        for (int N : sizes) {
            long totalTime = 0;
            long totalArith = 0;
            long totalComp = 0;

            for (int r = 0; r < repeats; r++) {
                long arith = 0;
                long comp = 0;

                int[] origem = new int[N];
                int[] destino = new int[N];

                for (int i = 0; i < N; i++) {
                    origem[i] = i + 1;
                }

                long start = System.nanoTime();

                arith++; // i = 0
                for (int i = 0; i < N; i++) {
                    comp++;  // i < N (true)
                    destino[i] = origem[i];
                    arith++; // destino[i] = origem[i]
                    arith++; // i++
                }
                comp++; // i < N (false, saida do laco)

                long end = System.nanoTime();

                totalTime += (end - start);
                totalArith += arith;
                totalComp += comp;
            }

            System.out.printf("%-10d %-20d %-25d %-20d%n",
                    N, totalTime / repeats, totalArith / repeats, totalComp / repeats);
        }
    }
}
