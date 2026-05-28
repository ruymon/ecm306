public class ex2 {

    static void dobraFilhos(ex1.No no) {
        for (ex1.No f = no.primeiroFilho; f != null; f = f.proximoIrmao) {
            f.valor *= 2;
        }
    }

    static void dobraPai(ex1.No no) {
        if (no.pai != null) no.pai.valor *= 2;
    }

    public static void main(String[] args) {
        ex1.No raiz = new ex1.No(5);
        ex1.No n4 = ex1.adicionarFilho(raiz, 4);
        ex1.No n3 = ex1.adicionarFilho(raiz, 3);
        ex1.No n7 = ex1.adicionarFilho(raiz, 7);
        ex1.adicionarFilho(n4, 1);
        ex1.No n2 = ex1.adicionarFilho(n4, 2);
        ex1.No n8 = ex1.adicionarFilho(n3, 8);
        ex1.adicionarFilho(n7, 0);
        ex1.adicionarFilho(n7, 6);
        ex1.adicionarFilho(n8, 21);
        ex1.adicionarFilho(n8, 12);

        System.out.print("a) filhos de 5: ");
        ex1.imprimeFilhos(raiz);

        System.out.print("b) pai de 8: ");
        ex1.imprimePai(n8);

        System.out.print("c) filhos de 8 antes: ");
        ex1.imprimeFilhos(n8);
        dobraFilhos(n8);
        System.out.print("c) filhos de 8 depois: ");
        ex1.imprimeFilhos(n8);

        System.out.print("d) pai de 2 antes: ");
        ex1.imprimePai(n2);
        dobraPai(n2);
        System.out.print("d) pai de 2 depois: ");
        ex1.imprimePai(n2);
    }
}
