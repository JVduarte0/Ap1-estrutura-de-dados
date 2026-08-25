import java.util.Random;
import java.util.Scanner;

public class Competicao {

    static final int NUM_JOGADORES = 5;
    static final int NUM_RODADAS = 4;


    public static void preencherDadosPadrao(
            String[] jogadores,
            int[][] pontuacoes
    ) {

        jogadores[0] = "Ana";
        jogadores[1] = "Bruno";
        jogadores[2] = "Carlos";
        jogadores[3] = "Diego";
        jogadores[4] = "Julia";

        int[][] dadosPadrao = {
                {80, 90, 70, 85},
                {70, 75, 80, 90},
                {95, 90, 85, 95},
                {60, 80, 70, 75},
                {85, 80, 90, 80}
        };

        for (int i = 0; i < NUM_JOGADORES; i++) {

            for (int j = 0; j < NUM_RODADAS; j++) {

                pontuacoes[i][j] =
                        dadosPadrao[i][j];
            }
        }
    }


    public static void cadastrarJogadores(
            Scanner scanner,
            String[] jogadores,
            int[][] pontuacoes
    ) {

        scanner.nextLine();

        for (int i = 0; i < NUM_JOGADORES; i++) {

            System.out.println(
                    "\n===== JOGADOR " +
                            (i + 1) +
                            " ====="
            );

            System.out.print("Nome: ");
            jogadores[i] = scanner.nextLine();

            for (int j = 0; j < NUM_RODADAS; j++) {

                System.out.print(
                        "Pontuação da rodada " +
                                (j + 1) +
                                ": "
                );

                pontuacoes[i][j] =
                        scanner.nextInt();
            }

            scanner.nextLine();
        }
    }


    public static void cadastrarNomes(
            Scanner scanner,
            String[] jogadores
    ) {

        scanner.nextLine();

        for (int i = 0; i < NUM_JOGADORES; i++) {

            System.out.print(
                    "Digite o nome do jogador " +
                            (i + 1) +
                            ": "
            );

            jogadores[i] =
                    scanner.nextLine();
        }
    }


    public static void gerarPontuacoesAleatorias(
            int[][] pontuacoes,
            int numeroRodadas
    ) {

        Random random = new Random();

        for (int i = 0; i < NUM_JOGADORES; i++) {

            for (int j = 0; j < numeroRodadas; j++) {

                pontuacoes[i][j] =
                        random.nextInt(101);
            }
        }
    }


    public static void mostrarPontuacoes(
            String[] jogadores,
            int[][] pontuacoes
    ) {

        for (int i = 0; i < NUM_JOGADORES; i++) {

            System.out.print(
                    jogadores[i] + ": "
            );

            for (int j = 0; j < NUM_RODADAS; j++) {

                System.out.print(
                        "R" +
                                (j + 1) +
                                "=" +
                                pontuacoes[i][j] +
                                " "
                );
            }

            System.out.println();
        }
    }


    public static int[] calcularPontuacaoTotal(
            int[][] pontuacoes
    ) {

        int[] totais =
                new int[NUM_JOGADORES];

        for (int i = 0; i < NUM_JOGADORES; i++) {

            int soma = 0;

            for (int j = 0; j < NUM_RODADAS; j++) {

                soma =
                        soma + pontuacoes[i][j];
            }

            totais[i] = soma;
        }

        return totais;
    }
}