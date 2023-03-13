import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int minimo, maximo;
        int contador = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Informe a partir de que número inicia o intervalo desejado: ");
        minimo = input.nextInt();
        System.out.println("Informe até que número o intervalo desejado encerra: ");
        maximo = input.nextInt();

        for(int i = minimo; i <= maximo; i++){
            if(i%3 == 0){
                contador++;
            }
        }

        System.out.println("Existem " + contador + " números divisíveis por 3 neste intervalo!");
    }
}