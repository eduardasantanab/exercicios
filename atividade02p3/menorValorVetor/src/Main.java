import java.util.Scanner;
public class Main {
    public static int menorValor(int[] vet){
        //ordena vetor - metodo bubblesort
        int fim, posicao, num;
        boolean troca;
        fim = vet.length - 2;
        posicao = 0;

        do {
            troca = false;
            for (int i = 0; i <= fim; i++) { //compara todos os números do vetor com cada número à frente
                if (vet[i] > vet[i+1]) { //troca e ordena
                    num = vet[i];
                    vet[i] = vet[i+1];
                    vet[i+1] = num;
                    posicao = i;
                    troca = true;
                }
            }
            fim = posicao - 1;
        } while (troca);
        return vet[0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero, resultado;
        int[] vetor = new int[5];

        for (int i = 0; i < vetor.length; i++){
            System.out.println("Informe um número: ");
            numero = input.nextInt();
            vetor[i] = numero;
        }

        resultado = menorValor(vetor);
        System.out.println(resultado);
    }
}