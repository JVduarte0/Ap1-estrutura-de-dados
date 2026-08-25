public class Consultas {

    public static void consultarJogador(
            String[] jogadores,
            int[] totais,
            String nome
    ) {

        for (int i = 0; i < jogadores.length; i++) {

            if (jogadores[i].equalsIgnoreCase(nome)) {

                System.out.println(
                        jogadores[i] +
                                " possui " +
                                totais[i] +
                                " pontos e está em " +
                                (i + 1) +
                                "º lugar no ranking."
                );

                return;
            }
        }

        System.out.println(
                "Jogador não encontrado."
        );
    }


    public static int calcularTotalRodada(
            int[][] pontuacoes,
            int rodada
    ) {

        if (rodada < 1 || rodada > 4) {

            System.out.println(
                    "Rodada inválida!"
            );

            return -1;
        }

        int soma = 0;

        int coluna = rodada - 1;

        for (int i = 0; i < 5; i++) {

            soma =
                    soma +
                            pontuacoes[i][coluna];
        }

        return soma;
    }
}