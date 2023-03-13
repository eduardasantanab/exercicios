import java.util.Locale;
import java.util.Scanner;


public class Lista06 {


    public static int insereValor(double[] vet, int qtdPreenchidas, double valor) {
        int i;
        int pos;

        if (qtdPreenchidas == 0) {
            vet[0] = valor;
            qtdPreenchidas++;
            return qtdPreenchidas;
        } else if (qtdPreenchidas == vet.length) {
            return -1;
        } else {
            for (pos = 0; pos <= qtdPreenchidas - 1; pos++) {
                if (vet[pos] == valor) {
                    return -2;
                } else if (vet[pos] < valor) {
                    break;
                }
            }
            for (i = qtdPreenchidas - 1; i >= pos; i--) {
                vet[i + 1] = vet[i];
            }
            vet[pos] = valor;
            qtdPreenchidas++;
            return qtdPreenchidas;
        }
    }


    public static int busca(double[] vet, int qtdPreenchidas, double valor) {
        int i;
        boolean encontrado = false;

        if (qtdPreenchidas == 0) {
            return -2;
        } else {
            for (i = 0; i < qtdPreenchidas; i++) {
                if (vet[i] == valor) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                return -1;
            }
        }
        return i;
    }

    public static int removeValor(double[] vet, int qtdPreenchidas, double valor) {

        int resultado = busca(vet, qtdPreenchidas, valor);

        if (resultado == -1) {
            return -1;
        } else if (resultado == -2) {
            return -2;
        } else {
            for (int i = resultado; i < qtdPreenchidas; i++) {
                vet[i] = vet[i + 1];
            }
            qtdPreenchidas--;
            return qtdPreenchidas;
        }
    }

    public static void exibeValores(double[] vet, int qtdPreenchidas) {

        for (int i = 0; i < qtdPreenchidas; i++) {
            System.out.println("[" + i + "] = " + vet[i]);
        }

    }

    public static void main(String[] args) {

        double[] numeros = new double[100];
        int preenchidos = 0;
        double valorPreenche;
        double valorBusca;
        double valorRemove;
        int resultadoBusca;
        int resultadoRemove;
        char S;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Informe um valor: ");
            valorPreenche = input.nextDouble();

            preenchidos = insereValor(numeros, preenchidos, valorPreenche);

            if (preenchidos == -1) {
                System.out.println("O vetor já está totalmente preenchido!");
                break;
            } else if (preenchidos == -2) {
                System.out.println("O valor informado já foi inserido anteriormente.");
            } else {
                System.out.println("O valor foi inserido com sucesso!");
            }

            System.out.println("Deseja inserir um novo valor? [S/N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);

        } while (S == 's');

        exibeValores(numeros, preenchidos);

        do {
            System.out.println("Informe um valor a ser buscado: ");
            valorBusca = input.nextDouble();

            resultadoBusca = busca(numeros, preenchidos, valorBusca);

            if (resultadoBusca == -1) {
                System.out.println("O valor não foi encontrado");
            } else if (resultadoBusca == -2) {
                System.out.println("O vetor está vazio");
            } else {
                System.out.println("A posição do valor " + valorBusca + " no vetor é " + resultadoBusca);
            }

            System.out.println("Deseja encontrar um novo valor? [S/N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);

        } while (S == 's');

        do {
            System.out.println("Informe um valor a ser removido: ");
            valorRemove = input.nextDouble();

            resultadoRemove = removeValor(numeros, preenchidos, valorRemove);

            if (resultadoRemove == -1) {
                System.out.println("O valor não foi encontrado");
            } else if (resultadoRemove == -2) {
                System.out.println("O vetor está vazio");
            } else {
                System.out.println("O valor foi removido com sucesso!");
            }

            System.out.println("Deseja remover outro valor novamente? [S/N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);

        } while (S == 's');


        System.out.println("Novo vetor: ");
        exibeValores(numeros, preenchidos);
    }
}
