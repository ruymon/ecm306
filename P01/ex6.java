/**
 * Exercicio 6:
 * Elaborar um programa, em linguagem Java, capaz de limpar (colocar -1 em todas as suas posições) qualquer tipo de matriz, inteira e positiva e que seja declarada globalmente. O programador deverá definir o tamanho da matriz (linhas e colunas), antes de compilar o programa.
 */

public class ex6 {
    static final int MATRIX_ROWS = 4;
    static final int MATRIX_COLS = 5;
    static final int CLEAR_VALUE = -1;

    static int[][] matrix = new int[MATRIX_ROWS][MATRIX_COLS];

    public static void main(String[] args) {
        clearMatrix();
    }

    static void clearMatrix() {
        for (int row = 0; row < MATRIX_ROWS; row++) {
            for (int col = 0; col < MATRIX_COLS; col++) {
                matrix[row][col] = CLEAR_VALUE;
            }
        }
    }
}
