/**
 * Exercicio 15:
 * Utilizando programação por chamada de métodos, elaborar um programa em
 * linguagem Java, capaz de criar um menu em tela, com as seguintes opções:
 * A- Inserir número secreto;
 * B- Jogar;
 * C- Apresentar resultados;
 * D- Sair;
 * - Se a opção A for digitada, o programa deverá fornecer instruções ao operador e
 * receber, via teclado, um número inteiro e positivo, secreto, objetivo de adivinhação do
 * jogo. Após isto, o programa deverá voltar ao menu principal;
 * - Se a opção B for digitada, o jogo se iniciará e será colocado 0 no contador de palpites.
 * O programa fornecerá instruções ao operador e receberá, via teclado, um número
 * inteiro e positivo, a ser comparado com o número secreto. Se o número digitado for
 * maior que o secreto, o programa informará ao operador a palavra ALTO, incrementará
 * o contador de palpites e aguardará o próximo palpite; Se o número digitado for menor
 * que o secreto, o programa informará ao operador a palavra BAIXO, incrementará o
 * contador de palpites e aguardará o próximo palpite; Se o número digitado for igual ao
 * secreto, o programa informará ao operador a palavra ACERTOU e retornará ao menu
 * principal; Se o número digitado for negativo, o programa deverá retornar ao menu
 * principal.
 * - Se a opção C for digitada, o programa apresentará a quantidade de palpites que foram
 * necessários para acontecer último acerto. Após isto, o programa deverá retornar ao menu principal.
 * - Se a opção D for digitada, o programa deve encerrar-se.
 */

import java.util.Scanner;

public class ex15 {
    static final int NOT_SET = -1;

    static int secretNumber = NOT_SET;
    static int lastGuesses = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            showMenu();
            choice = scanner.next();

            if (choice.equalsIgnoreCase("A")) {
                insertSecretNumber(scanner);
            } else if (choice.equalsIgnoreCase("B")) {
                playGame(scanner);
            } else if (choice.equalsIgnoreCase("C")) {
                showLastResult();
            }
        } while (!choice.equalsIgnoreCase("D"));

        scanner.close();
    }

    static void showMenu() {
        System.out.println("A- Inserir número secreto; B- Jogar; C- Apresentar resultados; D- Sair");
    }

    static void insertSecretNumber(Scanner scanner) {
        System.out.println("Digite o número secreto (inteiro positivo):");
        secretNumber = scanner.nextInt();
    }

    static void playGame(Scanner scanner) {
        if (secretNumber == NOT_SET) {
            System.out.println("Insira o número secreto primeiro (opção A).");
            return;
        }

        int guessCount = 0;
        System.out.println("Digite um número (negativo para retornar ao menu):");

        int guess = scanner.nextInt();
        while (guess >= 0) {
            guessCount++;
            if (guess > secretNumber) {
                System.out.println("ALTO");
            } else if (guess < secretNumber) {
                System.out.println("BAIXO");
            } else {
                System.out.println("ACERTOU");
                lastGuesses = guessCount;
                return;
            }
            guess = scanner.nextInt();
        }
    }

    static void showLastResult() {
        if (lastGuesses == 0) {
            System.out.println("Nenhum palpite correto ainda.");
        } else {
            System.out.println("Palpites para a última resposta correta: " + lastGuesses);
        }
    }
}
