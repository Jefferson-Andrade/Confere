import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== CONFERE ===");

        String produto = "";
        while (produto.isEmpty()) {
            System.out.print("Nome do produto: ");
            if (!entrada.hasNextLine()) {
                entrada.close();
                return;
            }
            produto = entrada.nextLine().trim();
            if (produto.isEmpty()) {
                System.out.println("Informe o nome do produto.");
            }
        }

        int quantidadeEsperada = lerQuantidade(entrada, "Quantidade esperada: ");
        if (quantidadeEsperada < 0) {
            entrada.close();
            return;
        }

        int quantidadeRecebida = lerQuantidade(entrada, "Quantidade recebida: ");
        if (quantidadeRecebida < 0) {
            entrada.close();
            return;
        }

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

    private static int lerQuantidade(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            // -1 sinaliza o fim da entrada; nunca é uma quantidade válida.
            if (!entrada.hasNextLine()) {
                return -1;
            }

            String texto = entrada.nextLine().trim();
            try {
                int quantidade = Integer.parseInt(texto);
                if (quantidade >= 0) {
                    return quantidade;
                }
            } catch (NumberFormatException erro) {
                // Letras, decimais e números fora do limite de int são inválidos.
            }
            System.out.println("Informe um número inteiro entre 0 e 2147483647.");
        }
    }
}
