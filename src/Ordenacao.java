public class Ordenacao {

    // =========================
    // BUBBLE SORT
    // =========================

    public static void bubbleSort(
            String[] jogadores,
            int[] totais
    ) {

        for (int i = 0; i < totais.length - 1; i++) {

            for (int j = 0;
                 j < totais.length - 1 - i;
                 j++) {

                if (totais[j] < totais[j + 1]) {

                    int tempPontos =
                            totais[j];

                    totais[j] =
                            totais[j + 1];

                    totais[j + 1] =
                            tempPontos;


                    String tempNome =
                            jogadores[j];

                    jogadores[j] =
                            jogadores[j + 1];

                    jogadores[j + 1] =
                            tempNome;
                }
            }
        }
    }


    // =========================
    // MERGE SORT
    // =========================

    public static void mergeSort(
            String[] jogadores,
            int[] totais,
            int inicio,
            int fim
    ) {

        if (inicio < fim) {

            int meio =
                    (inicio + fim) / 2;

            mergeSort(
                    jogadores,
                    totais,
                    inicio,
                    meio
            );

            mergeSort(
                    jogadores,
                    totais,
                    meio + 1,
                    fim
            );

            merge(
                    jogadores,
                    totais,
                    inicio,
                    meio,
                    fim
            );
        }
    }


    // Método auxiliar do Merge Sort
    public static void merge(
            String[] jogadores,
            int[] totais,
            int inicio,
            int meio,
            int fim
    ) {

        int tamanhoEsquerda =
                meio - inicio + 1;

        int tamanhoDireita =
                fim - meio;


        int[] pontosEsquerda =
                new int[tamanhoEsquerda];

        int[] pontosDireita =
                new int[tamanhoDireita];


        String[] nomesEsquerda =
                new String[tamanhoEsquerda];

        String[] nomesDireita =
                new String[tamanhoDireita];


        for (int i = 0; i < tamanhoEsquerda; i++) {

            pontosEsquerda[i] =
                    totais[inicio + i];

            nomesEsquerda[i] =
                    jogadores[inicio + i];
        }


        for (int j = 0; j < tamanhoDireita; j++) {

            pontosDireita[j] =
                    totais[meio + 1 + j];

            nomesDireita[j] =
                    jogadores[meio + 1 + j];
        }


        int i = 0;
        int j = 0;
        int k = inicio;


        while (
                i < tamanhoEsquerda &&
                        j < tamanhoDireita
        ) {

            if (
                    pontosEsquerda[i] >=
                            pontosDireita[j]
            ) {

                totais[k] =
                        pontosEsquerda[i];

                jogadores[k] =
                        nomesEsquerda[i];

                i++;

            } else {

                totais[k] =
                        pontosDireita[j];

                jogadores[k] =
                        nomesDireita[j];

                j++;
            }

            k++;
        }


        while (i < tamanhoEsquerda) {

            totais[k] =
                    pontosEsquerda[i];

            jogadores[k] =
                    nomesEsquerda[i];

            i++;
            k++;
        }


        while (j < tamanhoDireita) {

            totais[k] =
                    pontosDireita[j];

            jogadores[k] =
                    nomesDireita[j];

            j++;
            k++;
        }
    }


    // =========================
    // MOSTRAR RANKING
    // =========================

    public static void mostrarRanking(
            String[] jogadores,
            int[] totais
    ) {

        for (int i = 0; i < jogadores.length; i++) {

            System.out.println(
                    (i + 1) +
                            "º " +
                            jogadores[i] +
                            " - " +
                            totais[i] +
                            " pontos"
            );
        }
    }


    // =========================
    // CÓPIAS DOS VETORES
    // =========================

    public static int[] copiarVetor(
            int[] original
    ) {

        int[] copia =
                new int[original.length];

        for (int i = 0; i < original.length; i++) {

            copia[i] =
                    original[i];
        }

        return copia;
    }


    public static String[] copiarVetor(
            String[] original
    ) {

        String[] copia =
                new String[original.length];

        for (int i = 0; i < original.length; i++) {

            copia[i] =
                    original[i];
        }

        return copia;
    }
}