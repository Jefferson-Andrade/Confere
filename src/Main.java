import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Conferencia> conferencias = new ArrayList<>();

        System.out.println("=== CONFERE ===");

        do {
            String produto = lerProduto(entrada);
            if (produto == null) {
                break;
            }

            int quantidadeEsperada = lerQuantidade(entrada, "Quantidade esperada: ");
            if (quantidadeEsperada < 0) {
                break;
            }

            int quantidadeRecebida = lerQuantidade(entrada, "Quantidade recebida: ");
            if (quantidadeRecebida < 0) {
                break;
            }

            Conferencia conferencia = new Conferencia(produto, quantidadeEsperada, quantidadeRecebida);
            conferencias.add(conferencia);

            System.out.println();
            System.out.println("Produto: " + produto);
            System.out.println("Quantidade esperada: " + quantidadeEsperada);
            System.out.println("Quantidade recebida: " + quantidadeRecebida);
            System.out.println("Diferença: " + conferencia.diferenca());
            System.out.println("Resultado: " + conferencia.resultado());

        } while (desejaContinuar(entrada));

        if (!conferencias.isEmpty()) {
            exibirResumo(conferencias);
            System.out.println("Programa encerrado.");
        }
        entrada.close();
    }

    private static String lerProduto(Scanner entrada) {
        while (true) {
            System.out.print("Nome do produto: ");
            if (!entrada.hasNextLine()) {
                return null;
            }
            String produto = entrada.nextLine().trim();
            if (!produto.isEmpty()) {
                return produto;
            }
            System.out.println("Informe o nome do produto.");
        }
    }

    private static void exibirResumo(List<Conferencia> conferencias) {
        System.out.println();
        System.out.println("=== RESUMO DA CONFERÊNCIA ===");
        System.out.println("Total de itens conferidos: " + conferencias.size());
        for (Conferencia conferencia : conferencias) {
            System.out.println(conferencia.produto()
                    + " | Esperada: " + conferencia.quantidadeEsperada()
                    + " | Recebida: " + conferencia.quantidadeRecebida()
                    + " | " + conferencia.resultado());
        }
    }

    private static boolean desejaContinuar(Scanner entrada) {
        while (true) {
            System.out.print("Deseja conferir outro produto? (s/n): ");
            if (!entrada.hasNextLine()) {
                return false;
            }

            String resposta = entrada.nextLine().trim();
            if (resposta.equalsIgnoreCase("s")) {
                System.out.println();
                return true;
            }
            if (resposta.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Opção inválida. Digite s para continuar ou n para sair.");
        }
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

    private record Conferencia(String produto, int quantidadeEsperada, int quantidadeRecebida) {
        int diferenca() {
            return quantidadeRecebida - quantidadeEsperada;
        }

        String resultado() {
            int diferenca = diferenca();
            if (diferenca < 0) {
                return "faltam " + (-diferenca) + " unidades.";
            }
            if (diferenca > 0) {
                return "sobram " + diferenca + " unidades.";
            }
            return "quantidade correta.";
        }
    }
}
