/*
Exercício 2 - Cálculo da Média Total de um vetor de tamanho n

Modelo de Knuth Simplificado:

Algoritmo:
1) soma <- 0
2) para i de 0 até n-1 faça
3)     soma <- soma + vetor[i]
4) fim-para
5) media <- soma / n

Contagem de operações (simplificada):
- Inicialização: c1
- Teste do laço: c2 * (n + 1)
- Incremento/controle do laço: c3 * n
- Soma + atribuição no corpo: c4 * n
- Divisão final: c5

Função de complexidade:
T(n) = c1 + c2*(n + 1) + c3*n + c4*n + c5
T(n) = (c1 + c2 + c5) + (c2 + c3 + c4)*n

Logo:
T(n) = a + b*n  ->  O(n)
*/
public class ex2 {

    static double mediaTotal(int[] vetor, int n) {
        long soma = 0;
        for (int i = 0; i < n; i++) {
            soma += vetor[i];
        }
        return (double) soma / n;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 500, 1000, 5000};

        for (int n : sizes) {
            int[] vetor = new int[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = i + 1;
            }

            double media = mediaTotal(vetor, n);
            System.out.printf("%-10d %-22s %-20.2f%n", n, "a + b*" + n, media);
        }
    }
}
