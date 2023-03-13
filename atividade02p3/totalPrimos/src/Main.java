import java.util.Scanner;
public class Main {
    public static boolean primos(int numero){
        int contador = 0;

        if(numero <= 1){ //números primos são acima de 1; testa negativos, 0 e 1.
            return false;
        } else{
            for (int i = numero; i >= 1; i--){ //confere quantidade de divisores
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

    public static void imprimePrimos (int minimo, int maximo){
        boolean resultado;
        for(int i = minimo; i <= maximo; i++){ //confere números primos no intervalo chamando a primeira função
            resultado = primos(i);
            if(resultado){ //imprime o número sempre que o retorno é verdadeiro
                System.out.print(i + "\t");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int minimo, maximo;

        System.out.println("Informe a partir de que número inicia o intervalo desejado: ");
        minimo = input.nextInt();
        System.out.println("Informe até que número o intervalo desejado encerra: ");
        maximo = input.nextInt();

        imprimePrimos(minimo, maximo);
    }
}