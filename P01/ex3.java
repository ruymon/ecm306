/**
 * Exercicio 3:
 * Elaborar um programa, em linguagem Java, capaz de carregar um vetor do tipo char
 * de 26 elementos com os caracteres de A até Z pelo próprio programa, sem que haja
 * digitação, utilizando malhas;
 */

public class ex3 {
    static final int ALPHABET_SIZE = 26;
    static final char FIRST_LETTER = 'A';

    public static void main(String[] args) {
        char[] letters = new char[ALPHABET_SIZE];

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            letters[i] = (char) (FIRST_LETTER + i);
        }
    }
}
