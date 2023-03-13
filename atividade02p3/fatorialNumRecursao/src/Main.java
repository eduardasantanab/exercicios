import java.util.Scanner;
public class Main {
    public static int fatorial (int num){
        if(num == 0 || num == 1){
            return 1;
        }else{
            return num * fatorial(num - 1); //recursiva fatorial
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Digite um número: ");
        numero = input.nextInt();
        
        System.out.println(fatorial(numero));
    }
}