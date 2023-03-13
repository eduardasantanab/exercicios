import java.security.SecureRandom;
import java.util.Scanner;

public class Atvd {

    public static void exibeMenu() {
        System.out.println("""
                Informe a opção desejada:
                1 – Preencher
                2 – Buscar
                3 – Exibir
                Informe a opção desejada:""");
    }

    public static int sorteiaNumero() {
        int num;
        SecureRandom random = new SecureRandom();
        num = random.nextInt(10000) + 1;
        return num;
    }

    public static void preencheVetor(int[] vet){
        int resultado;

        for(int i = 0; i < vet.length; i++){ //preenche
            resultado = sorteiaNumero();
            vet[i] = resultado;
        }

        for (int i = 1; i < vet.length; i++){ //sem repetidos
            if(vet[i - 1] == vet[i]){
                for(int j = 1; j < vet.length; j++){
                    vet[j] = vet[j+1];
                }
            }
        }
    }

    public static void ordenaVetor(int[] vet){
        int aux;

        for(int i = 0; i < vet.length; i++){ //100x
            for(int j = 0; j < vet.length - 1; j++){ //compara e troca
                if(vet[j] < vet[j + 1]){
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
        }
    }

    public static int buscaVetor(int[] vetor, int valor) {
        int inicio = 0, fim = vetor.length - 1;
        int meio;
        if (vetor[0] == 0) {
            return -2;
        }
        else {
            do {
                meio = (inicio + fim) / 2;
                if (valor == vetor[meio]) {
                    return meio;
                } else if (valor > vetor[meio]) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            } while (inicio <= fim);
            return -1;
        }
    }

    public static void exibeVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.println("[" + i + "] = " + vet[i]);
        }
    }

    public static void main(String[] args) {
        int numero;
        int opcao;
        int resultado;
        char S;
        int[] numeros = new int[100];


        Scanner input = new Scanner(System.in);
        do {
            exibeMenu();
            opcao = input.nextInt();
            input.nextLine();
            if (opcao == 1) {
                preencheVetor(numeros);
                ordenaVetor(numeros);
                System.out.println("Os números foram preenchidos com sucesso!");
            } else if (opcao == 2) {
                System.out.println("Digite um número: ");
                numero = input.nextInt();
                resultado = buscaVetor(numeros, numero);
                if (resultado == -1) {
                    System.out.println("O número não foi encontrado.");
                }
                else if(resultado == -2){
                    System.out.println("O vetor está vazio!");
                } else {
                    System.out.println("O número " + numeros[resultado] + " foi encontrado na posição " + resultado);
                }
            } else if (opcao == 3) {
                exibeVetor(numeros);
            } else {
                System.out.println("A opção informada é inválida!");
            }
            System.out.println("Deseja consultar novamente? [S / N]");
            S = input.next().toLowerCase().trim().charAt(0);
        } while (S == 's');
    }
}
