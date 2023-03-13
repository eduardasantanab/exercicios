import java.util.Scanner;

public class IRPF {

    public static void main(String[] args) {

        //tabela de alíquota anual irpf valores de 2017

        float rendimentoAnual;
        float despesasMedicas;
        float rendimentoDeduzido;
        float calculoBase;
        float faixaIsentaAnual = 22847.76f;
        float porcentagemDaSegundaFaixa = 0.075f;
        float porcentagemDaTerceiraFaixa = 0.15f;
        float porcentagemDaQuartaFaixa = 0.225f;
        float porcentagemDaQuintaFaixa = 0.275f;
        float valorSegundaFaixaAnual = 11072.03f;
        float valorCumulativoFaixasAnual = 22164.82f;
        float cumulativoFinalFaixasAnual = 33128.37f;
        float valorDoImposto;

        Scanner input = new Scanner(System.in);
        System.out.print("Informe o valor recebido por uma Pessoa Física em um ano: ");
        rendimentoAnual = input.nextFloat();
        calculoBase = rendimentoAnual;

        System.out.print("Informe o valor gasto com despesas médicas: ");
        despesasMedicas = input.nextFloat();

        rendimentoDeduzido = rendimentoAnual - despesasMedicas;


            if (rendimentoDeduzido <= faixaIsentaAnual) {
                System.out.println("Isento");
            } else {
                rendimentoAnual = calculoBase - despesasMedicas - faixaIsentaAnual;
            }
            if (rendimentoDeduzido > 22847.76 && rendimentoDeduzido <= 33919.80) {
                valorDoImposto = (rendimentoAnual * porcentagemDaSegundaFaixa);
                System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                System.out.printf("Alíquota efetiva: %.2f\n", (valorDoImposto / calculoBase) * 100);
            } else {
                if (rendimentoDeduzido > 33919.80 && rendimentoDeduzido <= 45012.60) {
                    valorDoImposto = ((rendimentoAnual - valorSegundaFaixaAnual) * porcentagemDaTerceiraFaixa) + 830.402f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    System.out.printf("Alíquota efetiva: %.2f\n", (valorDoImposto / calculoBase) * 100);
                } else if (rendimentoDeduzido > 45012.60 && rendimentoDeduzido <= 55976.16) {
                    valorDoImposto = ((rendimentoAnual - valorCumulativoFaixasAnual) * porcentagemDaQuartaFaixa) + 2494.312f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    System.out.printf("Alíquota efetiva: %.2f\n", (valorDoImposto / calculoBase) * 100);
                } else if (rendimentoDeduzido > 55976.16) {
                    valorDoImposto = ((rendimentoAnual - cumulativoFinalFaixasAnual) * porcentagemDaQuintaFaixa) + 4961.11f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    System.out.printf("Alíquota efetiva: %.2f\n", (valorDoImposto / calculoBase) * 100);
                } else {
                   System.out.println(" ");
                }
            }
        }
    }
