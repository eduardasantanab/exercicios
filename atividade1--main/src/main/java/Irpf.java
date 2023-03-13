import java.util.Objects;
import java.util.Scanner;

public class Irpf {

    public static void main(String[] args) {

        //tabela de alíquota mensal irpf valores de 2015 e tabela de alíquota anual irpf valores de 2017

        String tipoCalculo;
        float salario;
        float rendimentoAnual;
        float calculoBase;
        float faixaIsentaMensal = 1903.98f;
        float faixaIsentaAnual = 22847.76f;
        float porcentagemDaSegundaFaixa = 0.075f;
        float porcentagemDaTerceiraFaixa = 0.15f;
        float porcentagemDaQuartaFaixa = 0.225f;
        float porcentagemDaQuintaFaixa = 0.275f;
        float valorSegundaFaixaMensal = 922.66f;
        float valorCumulativoFaixasMensal = 1847.05f;
        float cumulativoFinalFaixasMensal = 2760.67f;
        float valorSegundaFaixaAnual = 11072.03f;
        float valorCumulativoFaixasAnual = 22164.82f;
        float cumulativoFinalFaixasAnual = 33128.37f;
        float valorDoImposto;

        Scanner input = new Scanner(System.in);
        System.out.print("Instruções:\n " +
                "Digite 'mensal' para cácular o imposto mensal.\n " +
                "Digite 'anual' para cálcular o imposto anual. \n " +
                "Após o primeiro cálculo, digite 'sair' quando desejar interromper o programa.\n" +
                "Informe sua opção: ");
        tipoCalculo = input.nextLine();

        while (Objects.equals(tipoCalculo.trim().toLowerCase(), "mensal")) {

            System.out.print("\nDigite o valor a ser calculado: ");
            salario = input.nextFloat();
            calculoBase = salario;

            if (salario <= faixaIsentaMensal) {
                System.out.println("Isento");
            } else {

                salario = calculoBase - faixaIsentaMensal;

                if (calculoBase > 1903.98 && calculoBase <= 2826.65) {
                    valorDoImposto = (salario * porcentagemDaSegundaFaixa);
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                } else {

                    if (calculoBase > 2826.65 && calculoBase <= 3751.05) {
                        valorDoImposto = ((salario - valorSegundaFaixaMensal) * porcentagemDaTerceiraFaixa) + 69.199f;
                        System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    } else if (calculoBase > 3751.06 && calculoBase <= 4664.68) {
                        valorDoImposto = ((salario - valorCumulativoFaixasMensal) * porcentagemDaQuartaFaixa) + 207.85f;
                        System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    } else if (calculoBase > 4664.68){
                        valorDoImposto = ((salario - cumulativoFinalFaixasMensal) * porcentagemDaQuintaFaixa) + 413.421f;
                        System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                    }
                    else {
                        break;
                    }
                }
            }
        }

        while (Objects.equals(tipoCalculo.trim().toLowerCase(), "anual")) {

            System.out.println("Digite o valor do calculo anual: ");
            rendimentoAnual = input.nextFloat();
            calculoBase = rendimentoAnual;

            if (rendimentoAnual <= faixaIsentaAnual) {
                System.out.println("Isento");
            } else {
                rendimentoAnual = calculoBase - faixaIsentaAnual;
            }
            if (calculoBase > 22847.76 && calculoBase <= 33919.80) {
                valorDoImposto = (rendimentoAnual * porcentagemDaSegundaFaixa);
                System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
            } else {
                if (calculoBase > 33919.80 && calculoBase <= 45012.60) {
                    valorDoImposto = ((rendimentoAnual - valorSegundaFaixaAnual) * porcentagemDaTerceiraFaixa) + 830.402f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                } else if (calculoBase > 45012.60 && calculoBase <= 55976.16) {
                    valorDoImposto = ((rendimentoAnual - valorCumulativoFaixasAnual) * porcentagemDaQuartaFaixa) + 2494.312f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                } else if (calculoBase > 55976.16){
                    valorDoImposto = ((rendimentoAnual - cumulativoFinalFaixasAnual) * porcentagemDaQuintaFaixa) + 4961.11f;
                    System.out.printf("Imposto devido: %.2f\n", valorDoImposto);
                }
                else {
                    break;
                }
            }
        }
    }
}





