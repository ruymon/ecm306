/**
 * Exercicio 4:
 * Dado o vetor gerado pelo exercício 3 ( [ 'A', 'B', 'C', 'D', ... , 'W', 'X', 'Y', 'Z' ] ),
 * elaborar um programa em linguagem Java capaz de trocar a ordem de seus elementos, de dois em dois,
 * até o final do mesmo ( [ 'B', 'A', 'D', 'C', ... , 'X', 'W', 'Z', 'Y' ] ), utilizando malhas;
 */

public class ex4 {
    static final int ALPHABET_SIZE = 26;
    static final char FIRST_LETTER = 'A';

    public static void main(String[] args) {
        char[] letters = new char[ALPHABET_SIZE];
        for (int index = 0; index < ALPHABET_SIZE; index++) {
            letters[index] = (char) (FIRST_LETTER + index);
        }

        for (int index = 0; index < ALPHABET_SIZE - 1; index += 2) {
            char temp = letters[index];
            letters[index] = letters[index + 1];
            letters[index + 1] = temp;
        }
    }
}
