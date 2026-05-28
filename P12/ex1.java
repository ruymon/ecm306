public class ex1 {

    static class No {
        int valor;
        No pai;
        No primeiroFilho;
        No proximoIrmao;

        No(int valor) {
            this.valor = valor;
        }
    }

    static No adicionarFilho(No pai, int valor) {
        No novo = new No(valor);
        novo.pai = pai;
        if (pai.primeiroFilho == null) {
            pai.primeiroFilho = novo;
        } else {
            No irmao = pai.primeiroFilho;
            while (irmao.proximoIrmao != null) irmao = irmao.proximoIrmao;
            irmao.proximoIrmao = novo;
        }
        return novo;
    }

    static void imprimeFilhos(No no) {
        StringBuilder sb = new StringBuilder("[");
        for (No f = no.primeiroFilho; f != null; f = f.proximoIrmao) {
            sb.append(f.valor);
            if (f.proximoIrmao != null) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    static No pai(No no) {
        return no.pai;
    }

    static void imprimePai(No no) {
        if (no.pai == null) System.out.println("(raiz)");
        else System.out.println(no.pai.valor);
    }

    static boolean ehInterno(No no) {
        return no.primeiroFilho != null;
    }

    static void imprimeFilhosFolhas(No no) {
        StringBuilder sb = new StringBuilder("[");
        boolean primeiro = true;
        for (No f = no.primeiroFilho; f != null; f = f.proximoIrmao) {
            if (f.primeiroFilho == null) {
                if (!primeiro) sb.append(", ");
                sb.append(f.valor);
                primeiro = false;
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    static void preorder(No no) {
        if (no == null) return;
        System.out.print(no.valor + " ");
        for (No f = no.primeiroFilho; f != null; f = f.proximoIrmao) {
            preorder(f);
        }
    }

    static void posorder(No no) {
        if (no == null) return;
        for (No f = no.primeiroFilho; f != null; f = f.proximoIrmao) {
            posorder(f);
        }
        System.out.print(no.valor + " ");
    }

    public static void main(String[] args) {
        No raiz = new No(1);
        No n2 = adicionarFilho(raiz, 2);
        No n3 = adicionarFilho(raiz, 3);
        No n4 = adicionarFilho(raiz, 4);
        No n5 = adicionarFilho(n2, 5);
        adicionarFilho(n2, 6);
        adicionarFilho(n3, 7);
        adicionarFilho(n5, 8);

        System.out.print("imprimeFilhos(1): ");
        imprimeFilhos(raiz);

        System.out.print("pai(5).valor: ");
        System.out.println(pai(n5).valor);

        System.out.print("imprimePai(5): ");
        imprimePai(n5);

        System.out.print("ehInterno(2): ");
        System.out.println(ehInterno(n2));

        System.out.print("ehInterno(4): ");
        System.out.println(ehInterno(n4));

        System.out.print("imprimeFilhosFolhas(2): ");
        imprimeFilhosFolhas(n2);

        System.out.print("preorder(1): ");
        preorder(raiz);
        System.out.println();

        System.out.print("posorder(1): ");
        posorder(raiz);
        System.out.println();
    }
}
