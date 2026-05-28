public class ex1 {

    static final int NIL = -1;
    static final int CAPACIDADE = 100;

    static int[] chave    = new int[CAPACIDADE];
    static int[] proximo  = new int[CAPACIDADE];
    static int[] anterior = new int[CAPACIDADE];

    static int L = NIL;
    static int proximoLivre = 0;

    static void criarLista(int[] valores) {
        L = NIL;
        proximoLivre = 0;
        for (int i = valores.length - 1; i >= 0; i--) {
            inserir(valores[i]);
        }
    }

    static void inserir(int valor) {
        int x = proximoLivre++;
        chave[x] = valor;
        proximo[x] = L;
        if (L != NIL) anterior[L] = x;
        anterior[x] = NIL;
        L = x;
    }

    static boolean deletar(int valor) {
        int x = buscar(valor);
        if (x == NIL) return false;
        if (anterior[x] != NIL) proximo[anterior[x]] = proximo[x];
        else L = proximo[x];
        if (proximo[x] != NIL) anterior[proximo[x]] = anterior[x];
        return true;
    }

    static int buscar(int valor) {
        int x = L;
        while (x != NIL && chave[x] != valor) x = proximo[x];
        return x;
    }

    static void imprimir() {
        StringBuilder sb = new StringBuilder("[");
        for (int x = L; x != NIL; x = proximo[x]) {
            sb.append(chave[x]);
            if (proximo[x] != NIL) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        criarLista(new int[]{9, 16, 4, 1});
        imprimir();

        inserir(25);
        inserir(7);
        imprimir();

        deletar(16);
        imprimir();

        deletar(999);
        imprimir();

        deletar(7);
        imprimir();
    }
}
