import java.util.Locale;
import java.util.Scanner;

public class ManipStrings {

    public static int insereNomes(String[] vet, int qtdPreenchidas, String nome) {
        int pos, i, posicao = 0;
        if (qtdPreenchidas == 0) {
            vet[0] = nome;
            qtdPreenchidas++;
            return qtdPreenchidas;
        } else if (qtdPreenchidas == vet.length) {
            return -1;
        } else {
            qtdPreenchidas++;

            for (pos = 0; pos <= qtdPreenchidas - 1; pos++) {
                if (vet[pos].compareToIgnoreCase(nome) == 0) {
                    return -2;
                } else if (vet[pos].compareToIgnoreCase(nome) > 0) {
                    posicao = pos;
                    break;
                } else {
//                    carlos
//                    [alana][dudu][0]
                    vet[] = vet[pos]
                    vet[pos + 1] = nome;
                    return qtdPreenchidas;
                }
            }
            for (i = qtdPreenchidas - 1; i >= posicao; i--) {
                vet[posicao + 1] = vet[posicao];
                vet[posicao] = nome;
            }
            return qtdPreenchidas;
        }
    }

    public static void exibeNomes(String[] vet, int qtdPreenchidas) {
        for (int i = 0; i < qtdPreenchidas; i++) {
            System.out.println("[" + i + "] = " + vet[i]);
        }
    }

    public static int busca(String[] vet, int qtdPreenchidas, String nome) {
        int i;
        boolean encontrado = false;
        if (qtdPreenchidas == 0) {
            return -2;
        } else {
            for (i = 0; i < qtdPreenchidas; i++) {
                if (vet[i].compareToIgnoreCase(nome) == 0) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                return -1;
            }
        }
        return i;
    }

    public static int removeValor(String[] vet, int qtdPreenchidas, String nome) {
        int resultado = busca(vet, qtdPreenchidas, nome);
        if (resultado == -1) {
            return -1;
        } else if (resultado == -2) {
            return -2;
        } else {
            for (int i = resultado; i < qtdPreenchidas; i++) {
                vet[i] = vet[i + 1];

            }
            qtdPreenchidas--;
            return qtdPreenchidas;
        }
    }

    public static void main(String[] args) {
        String[] nomes = new String[3];
        int preenchidos = 0;
        String nomePreenche;
        String nomeBusca;
        String nomeRemove;
        int resultadoBusca;
        int resultadoRemove;
        char S;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Informe um nome: ");
            nomePreenche = input.next();
            preenchidos = insereNomes(nomes, preenchidos, nomePreenche);

            if (preenchidos == -1) {
                System.out.println("O vetor já está totalmente preenchido!");
                break;
            } else if (preenchidos == -2) {
                System.out.println("O nome informado já foi inserido anteriormente.");
            } else {
                System.out.println("O nome foi inserido com sucesso!");
            }
            System.out.println("Deseja inserir um novo nome? [S / N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
        } while (S == 's');

        exibeNomes(nomes, preenchidos);

        do {

            System.out.println("Informe um nome a ser buscado: ");
            nomeBusca = input.next();
            resultadoBusca = busca(nomes, preenchidos, nomeBusca);
            if (resultadoBusca == -1) {
                System.out.println("O nome não foi encontrado");
            } else if (resultadoBusca == -2) {
                System.out.println("O vetor está vazio");
            } else {
                System.out.println("A posição do nome " + nomeBusca + " no vetor é " + resultadoBusca);

            }
            System.out.println("Deseja encontrar um novo nome? [S / N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
        } while (S == 's');

        do {
            System.out.println("Informe um nome a ser removido: ");
            nomeRemove = input.next();
            resultadoRemove = removeValor(nomes, preenchidos, nomeRemove);
            if (resultadoRemove == -1) {
                System.out.println("O nome não foi encontrado");
            } else if (resultadoRemove == -2) {
                System.out.println("O vetor está vazio");
            } else {
                System.out.println("O nome foi removido com sucesso!");
            }
            System.out.println("Deseja remover outro nome novamente? [S / N]");
            S = input.next().toLowerCase(Locale.ROOT).trim().charAt(0);
        } while (S == 's');
        System.out.println("Novo vetor: ");

        exibeNomes(nomes, preenchidos);
    }
}