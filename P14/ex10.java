public class ex10 {

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

    static int altura(No no) {
        if (no == null) return -1;
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    public static void main(String[] args) {
        No raiz = construirArvore();
        System.out.println("Altura da arvore: " + altura(raiz));
    }
}
