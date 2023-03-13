import java.util.Scanner;

public class atvSalap2 {

    public static int verificaProduto(String cod) {

        int cont = 0;
////////////////////////////////////////////////////// verifica tamanho
        if (cod.length() == 9) {
////////////////////////////////////////////////////// verifica primeira letra e se 4p letras
            if (cod.charAt(0) == 'a') {
                for (int i = 0; i < 4; i++) {
                    if (Character.isLetter(cod.charAt(i))) {
                        cont++;
                    }
                }
////////////////////////////////////////////////////// verifica se 5 restantes são numeros
                if (cont == 4) {
                    for (int l = 4; l <= 8; l++) {
                        if (Character.isDigit(cod.charAt(l))) {
                            cont++;
                        } else {
                            return 3;
                        }
                    }
                }
                return 1;
            } else {
                return 3;
            }
        }
////////////////////////////////////////////////////////
        else {
            return 2;
        }
////////////////////////////////////////////////////////
    }

    public static void main(String[] args) {
        String codigo;
        int resultado;
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o código de um produto: ");
        codigo = input.nextLine().toLowerCase();

        resultado = verificaProduto(codigo);

        if (resultado == 1) {
            System.out.println("O código " + codigo + " é válido");
        } else if (resultado == 2) {
            System.out.println("O código " + codigo + " não é válido: quantidade inválida de caracteres");
        } else if (resultado == 3) {
            System.out.println("O código " + codigo + " não é válido: formato incorreto");
        }
    }
}
