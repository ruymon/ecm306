public class ex4 {
    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000};
        int repeats = 5;

        System.out.println("Exercicio 4: Verificar se matriz int N x N eh simetrica");
        System.out.println();
        System.out.printf("%-10s %-12s %-20s %-25s %-20s%n", "N", "Simetrica?", "Tempo Medio (ns)", "Op. Aritmeticas (med)", "Comparacoes (med)");
        System.out.println("-".repeat(87));

        for (int N : sizes) {
            long totalTime = 0;
            long totalArith = 0;
            long totalComp = 0;
            boolean simetrica = false;
            boolean memError = false;

            for (int r = 0; r < repeats; r++) {
                long arith = 0;
                long comp = 0;

                try {
                    int[][] matriz = new int[N][N];

                    for (int i = 0; i < N; i++) {
                        for (int j = i; j < N; j++) {
                            int val = (i + j) % 100;
                            matriz[i][j] = val;
                            matriz[j][i] = val;
                        }
                    }

                    boolean resultado = true;

                    long start = System.nanoTime();

                    arith++; // i = 0
                    for (int i = 0; i < N; i++) {
                        comp++;  // i < N (true)
                        arith++; // j = i + 1
                        arith++; // calculo de i + 1
                        for (int j = i + 1; j < N; j++) {
                            comp++; // j < N (true)
                            comp++; // matriz[i][j] != matriz[j][i]
                            if (matriz[i][j] != matriz[j][i]) {
                                resultado = false;
                                break;
                            }
                            arith++; // j++
                        }
                        comp++; // j < N (false)
                        if (!resultado) break;
                        arith++; // i++
                    }
                    comp++; // i < N (false)

                    long end = System.nanoTime();

                    simetrica = resultado;
                    totalTime += (end - start);
                    totalArith += arith;
                    totalComp += comp;
                } catch (OutOfMemoryError e) {
                    memError = true;
                    break;
                }
            }

            if (memError) {
                System.out.printf("%-10d %-12s %-20s %-25s %-20s%n",
                        N, "---", "MEMORIA INSUF.", "MEMORIA INSUF.", "MEMORIA INSUF.");
            } else {
                System.out.printf("%-10d %-12s %-20d %-25d %-20d%n",
                        N, simetrica ? "Sim" : "Nao", totalTime / repeats, totalArith / repeats, totalComp / repeats);
            }
        }
    }
}
