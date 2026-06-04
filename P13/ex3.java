public class ex3 {

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

    static boolean contem(No no, int k) {
        if (no == null) return false;
        if (no.valor == k) return true;
        return contem(no.esquerda, k) || contem(no.direita, k);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();

        int[] valores = {0, 4, 6, 7, 10, -1};
        for (int k : valores) {
            System.out.println("contem(" + k + ") = " + contem(raiz, k));
        }
    }
}
