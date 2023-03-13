import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numero;

        Scanner input = new Scanner(System.in);
        System.out.println("Informe um número: ");
        numero = input.nextInt();

        if(numero%2 == 0){
            System.out.println("O número é par!");
        } else{
            System.out.println("O número é ímpar!");
        }
    }
}