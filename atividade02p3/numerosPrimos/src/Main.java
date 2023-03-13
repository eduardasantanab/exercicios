import java.util.Scanner;
public class Main {
    public static boolean primo(int numero){
        int contador = 0;

        if(numero <= 1){ //números primos são acima de 1; testa negativos, 0 e 1.
            return false;
        } else{
            for (int i = numero/2; i >= 1; i--){ //confere quantidade de divisores  *só encontra divisores abaixo da metade do número
                if (numero%i == 0){
                    contador++;
                }
            }
        }

        if(contador > 2){ //se quantidade de divisores for maior que 2 é falso, pois primos só dividem por 1 e ele mesmo
            return false;
        } else { //divisores = 2, pois todo número divide por 1 e por ele mesmo
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Informe um número: ");
        numero = input.nextInt();

        System.out.println(primo(numero));

    }
}