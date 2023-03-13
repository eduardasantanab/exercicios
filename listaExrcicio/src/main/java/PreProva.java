import java.util.Locale;
import java.util.Scanner;


public class PreProva {

    public static int preencheVetor(String[] vet1, String cod, int[] vet2, int quant, int cont) {

        if (cont == 0) {
            vet1[cont] = cod;
            vet2[cont] = quant;
            cont++;
            return cont;
        } else {
            for (int i = 0; i < cont; i++) {
                if (cod.equalsIgnoreCase(vet1[i])) {
                    System.out.println("O código informado já foi cadastrado.");
                    return cont;
                }
            }
            vet1[cont] = cod;
            vet2[cont] = quant;
            cont++;
            return cont;
        }
    }

    public static void exibeMenu() {
        System.out.println("""
                Informe a opção desejada:
                1 – Venda de produto
                2 – Consulta de estoque
                3 - Atualização de estoque
                4 – Encerrar programa
                Informe a opção desejada:""");
    }

    public static int buscaProduto(String[] vet1, String cod) {
        int pos = -1;

        for (int i = 0; i < vet1.length; i++) {
            if (cod.equals(vet1[i])) {
                pos = i;
            }
        }
        return pos;
    }

    public static void vendaProduto(String[] vet1, String cod, int[] vet2, int quant) {
        int resultado;
        int atualiza = 0;

        resultado = buscaProduto(vet1, cod);

        if (resultado == -1) {
            System.out.println("Código inexistente!");
        } else {
            if (quant <= vet2[resultado]) {
                atualiza = quant - vet2[resultado];
                System.out.println("Pedido atenddo!");
            }
        }

        if (atualiza == 0) {
            System.out.println("Estoque zerado. Favor, entrar em contato o fornecedor do produto.");
        }
    }

    public static void consultaEstoque(String[] vet1, String cod, int[] vet2) {
        int resultado;

        resultado = buscaProduto(vet1, cod);

        if (resultado == -1) {
            System.out.println("Código inexistente!");
        } else {
            System.out.println("A quantidade existente no estoque do produto [" + vet1[resultado] +
                    "] é: " + vet2[resultado]);
        }
    }

    public static void atualizaEstoque(String[] vet1, String cod, int[] vet2, int quant) {
        int resultado;

        resultado = buscaProduto(vet1, cod);

        if (resultado == -1) {
            System.out.println("Código inexistente!");
        } else {
            vet2[resultado] = vet2[resultado] + quant;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] codigoProdutos = new String[2];
        int[] quantidadeProdutos = new int[2];
        String codigo;
        int quantidade;
        int resultado;
        int tamanho;
        int opcao;
        char S = 0;
        int cont = 0;

        do {
            System.out.println("Informe o código do produto: ");
            codigo = input.next().toLowerCase(Locale.ROOT);
            tamanho = codigo.length();

            System.out.println("Informe a quantidade deste produto: ");
            quantidade = input.nextInt();

            resultado = preencheVetor(codigoProdutos, codigo, quantidadeProdutos, quantidade, cont);

            cont = resultado;

        } while (cont < codigoProdutos.length);

        exibeMenu();
        opcao = input.nextInt();

        do {
            if (opcao == 1) {
                System.out.println("Informe o código do produto pretendido: ");
                codigo = input.next();
                System.out.println("Informe a quantidade pretendida deste produto: ");
                quantidade = input.nextInt();
                vendaProduto(codigoProdutos, codigo, quantidadeProdutos, quantidade);
                System.out.println("Deseja consultar novamente? [S/N]");
                S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
                exibeMenu();
                opcao = input.nextInt();

            } else if (opcao == 2) {
                System.out.println("Informe o código do produto que deseja consultar: ");
                codigo = input.next();
                consultaEstoque(codigoProdutos, codigo, quantidadeProdutos);
                System.out.println("Deseja consultar novamente? [S/N]");
                S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
                exibeMenu();
                opcao = input.nextInt();
            } else if (opcao == 3) {
                System.out.println("Informe o código do produto cujo estoque será atualizado: ");
                codigo = input.next();

                System.out.println("Informe a quantidade a ser acrescida no estoque deste produto: ");
                quantidade = input.nextInt();

                atualizaEstoque(codigoProdutos, codigo, quantidadeProdutos, quantidade);

                System.out.println("Deseja consultar novamente? [S/N]");
                S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
                exibeMenu();
                opcao = input.nextInt();
            } else if (opcao == 4) {
                break;
            }
        } while (S == 's');

        for (int i = 0; i < codigoProdutos.length; i++) {
            System.out.println("Código [" + codigoProdutos[i] + "] " +
                    " Quantidade = " + quantidadeProdutos[i] +
                    "\n------------------------------------------------");
        }
    }
}
