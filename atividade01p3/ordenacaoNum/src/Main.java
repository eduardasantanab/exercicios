import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int i, aux;
        int[] numeros = new int[3];
        Scanner input = new Scanner(System.in);

        for (i = 0; i < numeros.length; i++) {
            System.out.println("Informe um número: ");
            numeros[i] = input.nextInt();
        }

        for (i = 0; i < numeros.length - 1; i++) {
            if(numeros[i] > numeros[i+1]){
                aux = numeros[i];
                numeros[i] = numeros[i+1];
                numeros[i+1] = aux;
            } else if (numeros[i] > numeros[numeros.length - 1]){
                aux = numeros[i];
                numeros[i] = numeros[numeros.length - 1];
                numeros[numeros.length - 1] = aux;
            }
        }

        if (numeros[1] < numeros[0]){
            aux = numeros[1];
            numeros[1] = numeros[0];
            numeros[0] = aux;
        }

        for (i = 0; i < numeros.length; i++) {
            System.out.print("[" + numeros[i] + "]");
        }
    }
}