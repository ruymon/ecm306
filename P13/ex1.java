public class ex1 {

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

    static void imprimir(No no, int nivel) {
        if (no == null) return;
        imprimir(no.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("    ");
        System.out.println(no.valor);
        imprimir(no.esquerda, nivel + 1);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();
        System.out.println("Arvore binaria:");
        imprimir(raiz, 0);
    }
}
