# Exercícios da Aula 02 - Java Streams API

Este projeto contém exercícios práticos sobre Java Streams API, demonstrando operações funcionais em coleções de objetos.

## 📋 Descrição

O projeto implementa diversos exercícios utilizando Streams para manipular uma lista de produtos, explorando operações como filtros, mapeamentos e agregações.

## 🗂️ Estrutura do Projeto

```
exercicios_da_aula_02/
├── Main.java      # Classe principal com os exercícios
├── Produto.java   # Classe modelo Produto
└── README.md      # Este arquivo
```

## 🎯 Exercícios Implementados

### Exercício a) Filtrar produtos por categoria
- **Abordagem 1**: Loop tradicional com `forEach` e `if`
- **Abordagem 2**: Stream API com `filter()`
- Objetivo: Listar nomes dos produtos da categoria "Eletrônicos"

### Exercício b) Filtrar preços acima de um valor
- Utiliza `filter()` para produtos com preço > 500
- Utiliza `map()` para extrair apenas os preços
- Retorna uma lista de valores Double

### Exercício c) Calcular total do estoque por categoria
- Filtra produtos da categoria "Livros"
- Usa `mapToDouble()` e `sum()` para calcular o total
- Demonstra agregação de valores

### Exercício d) Buscar produto por nome
- Implementa método `buscarProdutoPorNome()`
- Retorna `Optional<Produto>`
- Demonstra tratamento de valores opcionais com `ifPresent()` e `orElseThrow()`

### Exercício f) Map com lambda vs referência de método
- **Lambda**: `.map(p -> p.getNome())`
- **Method Reference**: `.map(Produto::getNome)`
- Compara as duas sintaxes equivalentes

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- Compilador Java (javac)

### Compilação
```bash
javac Produto.java Main.java
```

### Execução
```bash
java Main
```

## 📊 Exemplo de Saída

```
=== Exercício a ===
Nomes dos produtos da categoria 'Eletrônicos' (forEach + if):
Notebook
Celular
Fone de Ouvido
Smart TV
Tablet

Nomes dos produtos da categoria 'Eletrônicos' (Stream + filter):
Notebook
Celular
Fone de Ouvido
Smart TV
Tablet

=== Exercício b ===
Preços dos produtos acima de 500: [3000.0, 2500.0, 4000.0, 1800.0]

=== Exercício c ===
Valor total do estoque de Livros: R$ 300.0

=== Exercício d ===
Produto encontrado: Produto{nome='Notebook', preco=3000.0, categoria='Eletrônicos'}
Exception in thread "main" java.lang.RuntimeException: Produto não encontrado!

=== Exercício f ===
Nomes com lambda: [Notebook, Celular, Fone de Ouvido, Smart TV, Livro Java, Livro Python, Livro Algoritmos, Tablet]
Nomes com referência de método: [Notebook, Celular, Fone de Ouvido, Smart TV, Livro Java, Livro Python, Livro Algoritmos, Tablet]
```

## 🔍 Conceitos Abordados

- **Streams API**: Pipeline de operações funcionais
- **Lambda Expressions**: Sintaxe concisa para funções anônimas
- **Method References**: Referência a métodos existentes
- **Optional**: Tratamento seguro de valores nulos
- **Operações Intermediárias**: `filter()`, `map()`, `mapToDouble()`
- **Operações Terminais**: `forEach()`, `collect()`, `sum()`, `findFirst()`
- **Collectors**: Transformação de streams em coleções

## 📚 Aprendizados

Este projeto demonstra como a programação funcional em Java pode:
- Tornar o código mais legível e expressivo
- Reduzir a necessidade de loops explícitos
- Facilitar operações complexas em coleções
- Melhorar a manutenibilidade do código

## 👨‍💻 Tecnologias

- Java 8+
- Streams API
- Lambda Expressions
- Collections Framework

---

**Nota**: O exercício d) lança uma exceção propositalmente quando o produto não é encontrado, demonstrando o uso de `orElseThrow()`.
