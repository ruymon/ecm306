/*
* Exercicio 1:
* Elaborar um programa, em linguagem Java, capaz inicializar com 0 (zero) um vetor
* do tipo int de 100 elementos, utilizando-se das malhas (laços, loops, etc.) while, do-while
* e for;
*/


public class exercise1{
    static final int ARRAY_SIZE = 100;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
    
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = 0;
        }
    }
}