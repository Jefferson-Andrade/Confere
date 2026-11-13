# Confere

Projeto de estudo de Jefferson Andrade Coelho: conferência de mercadorias com Java 21.

## Primeira etapa

Compara a quantidade recebida de um produto com a quantidade esperada e informa falta, sobra ou quantidade correta. Os dados são fixos no código nesta etapa. Não há entrada pelo teclado, persistência, interface gráfica ou dependências externas.

## Executar no IntelliJ IDEA

1. Abra a pasta Confere como projeto.
2. Use um JDK 21 como SDK do projeto.
3. Abra src/Main.java.
4. Clique no triângulo verde ao lado do método main e escolha Run.

Não precisa abrir o Docker.

## Entender a conta

`diferença = quantidade recebida - quantidade esperada`

Com 50 esperadas e 48 recebidas, a diferença é -2: faltam 2 unidades.

Para explorar os resultados, altere apenas quantidadeRecebida:

| Recebida | Esperada | Resultado |
| --- | --- | --- |
| 48 | 50 | Faltam 2 |
| 50 | 50 | Quantidade correta |
| 53 | 50 | Sobram 3 |

## Próxima etapa

Entender as condições if/else e depois permitir digitar os dados com Scanner.

Projeto desenvolvido com apoio de IA como parte do aprendizado de Java.
