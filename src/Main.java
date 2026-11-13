import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== CONFERE ===");
        System.out.print("Nome do produto: ");
        String produto = entrada.nextLine();

        System.out.print("Quantidade esperada: ");
        int quantidadeEsperada = entrada.nextInt();

        System.out.print("Quantidade recebida: ");
        int quantidadeRecebida = entrada.nextInt();

        // Valor negativo indica falta; positivo indica sobra.
        int diferenca = quantidadeRecebida - quantidadeEsperada;

        System.out.println();
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade esperada: " + quantidadeEsperada);
        System.out.println("Quantidade recebida: " + quantidadeRecebida);
        System.out.println("Diferença: " + diferenca);

        if (diferenca < 0) {
            System.out.println("Resultado: faltam " + (-diferenca) + " unidades.");
        } else if (diferenca > 0) {
            System.out.println("Resultado: sobram " + diferenca + " unidades.");
        } else {
            System.out.println("Resultado: quantidade correta.");
        }

        entrada.close();
    }
}
