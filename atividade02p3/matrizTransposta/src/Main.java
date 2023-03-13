import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;
        int[][] matriz = new int[3][3];

//preenche a matriz
        for(int i = 0; i < matriz.length; i++){ //lê linhas
            for(int j = 0; j < matriz[i].length; j++){ //lê colunas
                System.out.println("Informe um número: ");
                numero = input.nextInt();
                matriz[i][j] = numero; //armazena valor na matriz
            }
        }

//imprime a matriz
        for(int i = 0; i < matriz.length; i++){
            System.out.println();
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print("[" + matriz[i][j] + "]");
            }
        }
    }
}