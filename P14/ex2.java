public class ex2 {

    static class No {
        int valor;
        No esquerda, direita;
        No(int valor) { this.valor = valor; }
    }

    static No inserir(No no, int k) {
        if (no == null) return new No(k);
        if (k < no.valor) no.esquerda = inserir(no.esquerda, k);
        else if (k > no.valor) no.direita = inserir(no.direita, k);
        return no;
    }

    static No construirArvore() {
        int[] valores = {3, 7, 8, 9, 10, 5};
        No raiz = null;
        for (int valor : valores) raiz = inserir(raiz, valor);
        return raiz;
    }

    static void inOrder(No no) {
        if (no == null) return;
        inOrder(no.esquerda);
        System.out.print(no.valor + " ");
        inOrder(no.direita);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();

        System.out.print("InOrder antes: ");
        inOrder(raiz);
        System.out.println();

        int k = 6;
        raiz = inserir(raiz, k);

        System.out.print("InOrder depois de inserir " + k + ": ");
        inOrder(raiz);
        System.out.println();
    }
}
