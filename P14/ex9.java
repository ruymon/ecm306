public class ex9 {

    static class No {
        int valor;
        No esquerda, direita;
        No(int valor) { this.valor = valor; }
    }

    static No inserir(No no, int valor) {
        if (no == null) return new No(valor);
        if (valor < no.valor) no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor) no.direita = inserir(no.direita, valor);
        return no;
    }

    static No construirArvore() {
        int[] valores = {3, 7, 8, 9, 10, 5};
        No raiz = null;
        for (int valor : valores) raiz = inserir(raiz, valor);
        return raiz;
    }

    static int soma(No no) {
        if (no == null) return 0;
        return no.valor + soma(no.esquerda) + soma(no.direita);
    }

    static int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    static double media(No no) {
        int n = contarNos(no);
        if (n == 0) return 0.0;
        return (double) soma(no) / n;
    }

    public static void main(String[] args) {
        No raiz = construirArvore();
        System.out.printf("Media aritmetica: %.4f%n", media(raiz));
    }
}
