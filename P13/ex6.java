public class ex6 {

    static class No {
        int valor;
        No esquerda, direita;
        No(int valor) { this.valor = valor; }
    }

    static No construirArvore() {
        No raiz = new No(0);
        raiz.esquerda = new No(1);
        raiz.direita = new No(2);
        raiz.direita.esquerda = new No(3);
        raiz.direita.direita = new No(4);
        raiz.direita.esquerda.esquerda = new No(5);
        raiz.direita.esquerda.direita = new No(6);
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
