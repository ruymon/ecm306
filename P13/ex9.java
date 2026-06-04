public class ex9 {

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

    static int contarFolhas(No no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }

    public static void main(String[] args) {
        No raiz = construirArvore();
        System.out.println("Quantidade de folhas: " + contarFolhas(raiz));
    }
}
