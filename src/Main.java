import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] jogadores = new String[5];
        int[][] pontuacoes = new int[5][4];

        System.out.println("===== SISTEMA DE RANKING =====");
        System.out.println("1 - Usar dados padrão");
        System.out.println("2 - Cadastrar manualmente");
        System.out.println("3 - Gerar pontuações aleatórias");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {

            Competicao.preencherDadosPadrao(jogadores, pontuacoes);
            System.out.println("\nDados padrão carregados!");

        } else if (opcao == 2) {

            Competicao.cadastrarJogadores(scanner, jogadores, pontuacoes);
            System.out.println("\nJogadores cadastrados com sucesso!");

        } else if (opcao == 3) {

            Competicao.cadastrarNomes(scanner, jogadores);
            Competicao.gerarPontuacoesAleatorias(pontuacoes, 4);
            System.out.println("\nPontuações aleatórias geradas!");

        } else {

            System.out.println("Opção inválida.");
            scanner.close();
            return;
        }

        System.out.println("\n===== PONTUAÇÕES =====");

        Competicao.mostrarPontuacoes(jogadores, pontuacoes);

        int[] totais =
                Competicao.calcularPontuacaoTotal(pontuacoes);

        // Cópias para o Bubble Sort
        String[] jogadoresBubble =
                Ordenacao.copiarVetor(jogadores);

        int[] totaisBubble =
                Ordenacao.copiarVetor(totais);

        // Cópias para o Merge Sort
        String[] jogadoresMerge =
                Ordenacao.copiarVetor(jogadores);

        int[] totaisMerge =
                Ordenacao.copiarVetor(totais);

        // Bubble Sort
        Ordenacao.bubbleSort(
                jogadoresBubble,
                totaisBubble
        );

        System.out.println(
                "\n===== RANKING - BUBBLE SORT ====="
        );

        Ordenacao.mostrarRanking(
                jogadoresBubble,
                totaisBubble
        );

        // Merge Sort
        Ordenacao.mergeSort(
                jogadoresMerge,
                totaisMerge,
                0,
                totaisMerge.length - 1
        );

        System.out.println(
                "\n===== RANKING - MERGE SORT ====="
        );

        Ordenacao.mostrarRanking(
                jogadoresMerge,
                totaisMerge
        );

        // Consulta de jogador
        scanner.nextLine();

        System.out.print(
                "\nDigite o nome do jogador que deseja consultar: "
        );

        String nome = scanner.nextLine();

        Consultas.consultarJogador(
                jogadoresMerge,
                totaisMerge,
                nome
        );

        // Consulta de rodada
        System.out.print(
                "\nDigite a rodada que deseja consultar (1 a 4): "
        );

        int rodada = scanner.nextInt();

        int totalRodada =
                Consultas.calcularTotalRodada(
                        pontuacoes,
                        rodada
                );

        if (totalRodada != -1) {

            System.out.println(
                    "Total de pontos da rodada " +
                            rodada +
                            ": " +
                            totalRodada
            );
        }

        scanner.close();
    }
}