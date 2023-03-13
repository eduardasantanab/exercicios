import java.util.Scanner;
public class Main {
    public static int fatorial (int num){
        int calcula = 1;

        if(num == 0 || num == 1){
            return 1;
        }else{
            do {
                calcula = calcula * num;
                num--;
            }while(num > 0);
        }
        return calcula;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;

        System.out.println("Digite um número: ");
        numero = input.nextInt();

        System.out.println(fatorial(numero));
    }
}