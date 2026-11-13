# Confere

**Conferência de mercadorias com Java.**

O Confere é um projeto de estudo que compara a quantidade recebida de um produto com a quantidade esperada e identifica faltas, sobras ou recebimentos corretos.

A ideia nasce da experiência de Jefferson Andrade Coelho em produção, conferência e logística. O objetivo é transformar uma situação dessa rotina em um programa simples, desenvolvido em etapas para praticar e compreender os fundamentos de Java.

## Estado atual

Primeira versão funcional, executada no IntelliJ IDEA. Nesta etapa, o programa trabalha com um produto e quantidades definidas diretamente no código.

- Exibe o produto e as quantidades esperada e recebida.
- Calcula a diferença entre as quantidades.
- Informa quantas unidades faltam ou sobram.
- Indica quando a quantidade recebida está correta.

A entrada pelo teclado, o cadastro de vários produtos e o histórico de conferências ainda não foram implementados.

## Exemplo de execução

```text
=== CONFERE ===
Produto: Fertilizante A
Quantidade esperada: 50
Quantidade recebida: 48
Diferença: -2
Resultado: faltam 2 unidades.
```

## Regra de comparação

```java
int diferenca = quantidadeRecebida - quantidadeEsperada;
```

| Diferença | Significado | Exemplo |
| --- | --- | --- |
| Menor que zero | Falta de mercadoria | 48 recebidas − 50 esperadas = −2 |
| Igual a zero | Quantidade correta | 50 recebidas − 50 esperadas = 0 |
| Maior que zero | Sobra de mercadoria | 53 recebidas − 50 esperadas = 3 |

O programa utiliza `if`, `else if` e `else` para escolher a mensagem correspondente ao resultado.

## Tecnologias e conceitos

- Java 21.
- IntelliJ IDEA.
- Git para versionamento.
- Variáveis `String` e `int`, subtração, comparações e condições.
- Saída no console com `System.out.println`.

Não há bibliotecas externas. Esta versão não precisa de Docker, Spring Boot ou banco de dados.

## Como executar no IntelliJ IDEA

**Requisito:** JDK 21 instalado.

1. Abra o IntelliJ IDEA e selecione **File → Open**.
2. Selecione a pasta `Confere`, que contém este README e a pasta `src`.
3. Confira em **File → Project Structure → Project** se o SDK é o JDK 21.
4. Abra [`src/Main.java`](src/Main.java).
5. Clique no triângulo verde ao lado do método `main` e selecione **Run**. Também é possível executar a configuração `Confere`.
6. Consulte o resultado na janela **Run**.

### Experimentar outros resultados

Altere somente o valor de `quantidadeRecebida` em `Main.java` e execute novamente:

| Quantidade esperada | Quantidade recebida | Resultado esperado |
| --- | --- | --- |
| 50 | 48 | Faltam 2 unidades |
| 50 | 50 | Quantidade correta |
| 50 | 53 | Sobram 3 unidades |

Esses três cenários foram verificados na primeira versão. Os valores desta etapa representam quantidades inteiras não negativas; ainda não há validação de entrada.

## Estrutura principal

| Arquivo | Responsabilidade |
| --- | --- |
| `src/Main.java` | Dados do exemplo, cálculo, condições e exibição do resultado |
| `README.md` | Objetivo, funcionamento e instruções de execução |
| `Confere.iml` e `.idea/` | Configuração do projeto e da execução no IntelliJ |
| `.gitignore` | Exclusão de arquivos compilados e configurações locais do versionamento |

## Próximas etapas

Evoluções planejadas, a serem desenvolvidas conforme o aprendizado:

- [ ] Receber o nome do produto e as quantidades pelo teclado com `Scanner`.
- [ ] Validar os dados informados.
- [ ] Permitir realizar uma nova conferência sem reiniciar o programa.
- [ ] Trabalhar com vários produtos.
- [ ] Registrar justificativas para divergências e controlar o encerramento da conferência.
- [ ] Estudar o armazenamento do histórico de conferências.

## Autor e aprendizado

**Jefferson Andrade Coelho** — estudante de Análise e Desenvolvimento de Sistemas, em transição para desenvolvimento Java.

Projeto desenvolvido com apoio de IA. O foco é estudar cada parte do código, compreender as regras e ganhar autonomia nas próximas implementações.
