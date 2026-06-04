public class ex1 {

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

    static void imprimir(No no, int nivel) {
        if (no == null) return;
        imprimir(no.direita, nivel + 1);
        for (int i = 0; i < nivel; i++) System.out.print("    ");
        System.out.println(no.valor);
        imprimir(no.esquerda, nivel + 1);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();
        System.out.println("Arvore binaria de busca:");
        imprimir(raiz, 0);
    }
}
