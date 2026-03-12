/*
Exercício 1 - Cálculo do Fatorial de n

Modelo de Knuth Simplificado:

Algoritmo (iterativo):
1) fat <- 1
2) para i de 1 até n faça
3)     fat <- fat * i
4) fim-para

Contagem de operações (simplificada):
- Inicialização: c1
- Teste do laço: c2 * (n + 1)
- Incremento/controle do laço: c3 * n
- Multiplicação + atribuição no corpo: c4 * n

Função de complexidade:
T(n) = c1 + c2*(n + 1) + c3*n + c4*n
T(n) = (c1 + c2) + (c2 + c3 + c4)*n

Logo:
T(n) = a + b*n  ->  O(n)
*/
public class ex1 {

    static long fatorial(int n) {
        long fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

    public static void main(String[] args) {
        int[] sizes = {1, 2, 3, 5, 10, 20};

        for (int n : sizes) {
            long fn = fatorial(n);
            System.out.printf("%-10d %-22s %-20d%n", n, "a + b*" + n, fn);
        }
    }
}
