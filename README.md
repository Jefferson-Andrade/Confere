# Confere

**Conferência de mercadorias com Java.**

O Confere é um projeto de estudo que compara a quantidade recebida de um produto com a quantidade esperada e identifica faltas, sobras ou recebimentos corretos.

A ideia nasce da experiência de Jefferson Andrade Coelho em produção, conferência e logística. O objetivo é transformar uma situação dessa rotina em um programa simples, desenvolvido em etapas para praticar e compreender os fundamentos de Java.

## Estado atual

Versão executada no IntelliJ IDEA. O programa recebe pelo teclado o nome de um produto e as quantidades esperada e recebida, utilizando `Scanner`.

- Recebe pelo teclado e exibe o produto e as quantidades esperada e recebida.
- Calcula a diferença entre as quantidades.
- Informa quantas unidades faltam ou sobram.
- Indica quando a quantidade recebida está correta.
- Impede nome de produto vazio ou composto apenas por espaços.
- Aceita somente quantidades inteiras entre 0 e 2147483647.
- Solicita novamente apenas o campo inválido, sem encerrar com erro.
- Permite conferir outro produto sem reiniciar o programa, com a opção `s/n`.

O cadastro de vários produtos e o histórico de conferências ainda não foram implementados.

## Exemplo de execução

```text
=== CONFERE ===
Nome do produto: Fertilizante A
Quantidade esperada: 50
Quantidade recebida: 48

Produto: Fertilizante A
Quantidade esperada: 50
Quantidade recebida: 48
Diferença: -2
Resultado: faltam 2 unidades.
Deseja conferir outro produto? (s/n): n
Programa encerrado.
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
- Entrada pelo teclado com `Scanner` e saída no console.
- Repetição com `while` e `do/while`, métodos `lerQuantidade` e `desejaContinuar` e conversão com `Integer.parseInt`.
- Tratamento de entrada inválida com `try/catch` e `NumberFormatException`.

Não há bibliotecas externas. Esta versão não precisa de Docker, Spring Boot ou banco de dados.

## Como executar no IntelliJ IDEA

**Requisito:** JDK 21 instalado.

1. Abra o IntelliJ IDEA e selecione **File → Open**.
2. Selecione a pasta `Confere`, que contém este README e a pasta `src`.
3. Confira em **File → Project Structure → Project** se o SDK é o JDK 21.
4. Abra [`src/Main.java`](src/Main.java).
5. Clique no triângulo verde ao lado do método `main` e selecione **Run**. Também é possível executar a configuração `Confere`.
6. Na janela **Run**, digite o nome do produto e pressione Enter. Depois, informe cada quantidade, pressionando Enter após cada uma.
7. Após o resultado, digite `s` para conferir outro produto ou `n` para sair. Letras maiúsculas e espaços nas extremidades também são aceitos; outras respostas fazem o programa repetir a pergunta.

### Experimentar outros resultados

Digite `s` após cada resultado e informe um novo produto e suas quantidades para experimentar:

| Quantidade esperada | Quantidade recebida | Resultado esperado |
| --- | --- | --- |
| 50 | 48 | Faltam 2 unidades |
| 50 | 50 | Quantidade correta |
| 50 | 53 | Sobram 3 unidades |

As quantidades devem ser números inteiros entre 0 e 2147483647, inclusive. Zero é permitido. Números negativos, letras, decimais, campos vazios e números acima desse limite são recusados; o programa pede novamente o mesmo campo. O nome do produto também não pode ficar vazio. Espaços no início e no fim dos campos são removidos.

Por exemplo, ao digitar `-2` ou `abc` em uma quantidade, aparece a mensagem `Informe um número inteiro entre 0 e 2147483647.`. Digite um valor válido para continuar. A conferência só é calculada depois que todos os campos forem aceitos. Se a entrada terminar antes disso, o programa encerra sem apresentar resultado parcial.

Cada nova conferência começa com os campos vazios e utiliza apenas os dados do novo produto. Os resultados aparecem no console, mas ainda não são armazenados em histórico. Se a entrada terminar na pergunta `s/n`, o programa encerra normalmente.

## Estrutura principal

| Arquivo | Responsabilidade |
| --- | --- |
| `src/Main.java` | Entrada pelo teclado, cálculo, condições e exibição do resultado |
| `README.md` | Objetivo, funcionamento e instruções de execução |
| `Confere.iml` e `.idea/` | Configuração do projeto e da execução no IntelliJ |
| `.gitignore` | Exclusão de arquivos compilados e configurações locais do versionamento |

## Próximas etapas

Evoluções planejadas, a serem desenvolvidas conforme o aprendizado:

- [x] Receber o nome do produto e as quantidades pelo teclado com `Scanner`.
- [x] Validar os dados informados.
- [x] Permitir realizar uma nova conferência sem reiniciar o programa.
- [ ] Trabalhar com vários produtos.
- [ ] Registrar justificativas para divergências e controlar o encerramento da conferência.
- [ ] Estudar o armazenamento do histórico de conferências.

## Autor e aprendizado

**Jefferson Andrade Coelho** — estudante de Análise e Desenvolvimento de Sistemas, em transição para desenvolvimento Java.

Projeto desenvolvido com apoio de IA. O foco é estudar cada parte do código, compreender as regras e ganhar autonomia nas próximas implementações.
