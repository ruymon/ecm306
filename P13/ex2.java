public class ex2 {

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

    static void preOrder(No no) {
        if (no == null) return;
        System.out.print(no.valor + " ");
        preOrder(no.esquerda);
        preOrder(no.direita);
    }

    static void inOrder(No no) {
        if (no == null) return;
        inOrder(no.esquerda);
        System.out.print(no.valor + " ");
        inOrder(no.direita);
    }

    static void postOrder(No no) {
        if (no == null) return;
        postOrder(no.esquerda);
        postOrder(no.direita);
        System.out.print(no.valor + " ");
    }

    public static void main(String[] args) {
        No raiz = construirArvore();

        System.out.print("preOrder:  ");
        preOrder(raiz);
        System.out.println();

        System.out.print("inOrder:   ");
        inOrder(raiz);
        System.out.println();

        System.out.print("postOrder: ");
        postOrder(raiz);
        System.out.println();
    }
}
