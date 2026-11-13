public class Main {
    public static void main(String[] args) {
        String produto = "Fertilizante A";
        int quantidadeEsperada = 50;
        int quantidadeRecebida = 48;

        // Valor negativo indica falta; positivo indica sobra.
        int diferenca = quantidadeRecebida - quantidadeEsperada;

        System.out.println("=== CONFERE ===");
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
    }
}
