import java.security.SecureRandom;

public class Atividade01 {

    public static int sorteiaFace() {
        int num;
        SecureRandom random = new SecureRandom();
        num = random.nextInt(6) + 1;
        return num;
    }

    public static int[] realizaSimulacao() {

        int contadorFace1 = 0;
        int contadorFace2 = 0;
        int contadorFace3 = 0;
        int contadorFace5 = 0;
        int contadorFace4 = 0;
        int contadorFace6 = 0;
        int resultado;
        int[] quantidadeResultado = new int[6];

        for (int i = 0; i < 1000000; i++) {

            resultado = sorteiaFace();

            if (resultado == 1) {
                contadorFace1++;
                quantidadeResultado[0] = contadorFace1;
            } else if (resultado == 2) {
                contadorFace2++;
                quantidadeResultado[1] = contadorFace2;
            } else if (resultado == 3) {
                contadorFace3++;
                quantidadeResultado[2] = contadorFace3;
            } else if (resultado == 4) {
                contadorFace4++;
                quantidadeResultado[3] = contadorFace4;
            } else if (resultado == 5) {
                contadorFace5++;
                quantidadeResultado[4] = contadorFace5;
            } else if (resultado == 6) {
                contadorFace6++;
                quantidadeResultado[5] = contadorFace6;
            }
        }
        return quantidadeResultado;
    }

    public static int[] exibeResultado(int[] vetor) {

        for (int i = 0; i < 6; i++) {
            System.out.println("[" + (i + 1) + "] = " + vetor[i]);
        }
        return vetor;
    }

    public static void main(String[] args) {

        int[] resultadoFinal = realizaSimulacao();
        System.out.println("\nQuantas vezes cada face do dado foi lançada\n");
        System.out.println(exibeResultado(resultadoFinal));
    }

}
