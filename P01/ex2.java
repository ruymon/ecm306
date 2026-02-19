/**
 * Exercicio 2:
 * Elaborar um programa, em linguagem Java, capaz de, em um vetor do tipo int de 100 elementos,
 * carregar seus índices pares com o número 0 (zero) e seus índices ímpares com o valor do próprio índice
 * (ex.: [ 0, 1, 0, 3, 0, 5, 0, 7, ..., 97, 0, 99 ] ).
 * utilizando-se de malhas (laços, loops, etc.) while, do-while e for;
 */

public class ex2 {
    static final int ARRAY_SIZE = 100;

    public static void main(String[] args) {
        int[] values = new int[ARRAY_SIZE];

        for (int index = 0; index < ARRAY_SIZE; index++) {
            if (index % 2 == 0) {
                values[index] = 0;
            } else {
                values[index] = index;
            }
        }
    }
}
