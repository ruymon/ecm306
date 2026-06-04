public class ex6 {

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

    static boolean contem(No no, int k) {
        if (no == null) return false;
        if (no.valor == k) return true;
        if (k < no.valor) return contem(no.esquerda, k);
        return contem(no.direita, k);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();

        int[] valores = {3, 5, 6, 10, 11};
        for (int k : valores) {
            System.out.println("contem(" + k + ") = " + contem(raiz, k));
        }
    }
}
