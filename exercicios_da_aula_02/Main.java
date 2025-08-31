import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Criando uma lista com pelo menos 8 produtos
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 3000.0, "Eletrônicos"),
            new Produto("Celular", 2500.0, "Eletrônicos"),
            new Produto("Fone de Ouvido", 150.0, "Eletrônicos"),
            new Produto("Smart TV", 4000.0, "Eletrônicos"),
            new Produto("Livro Java", 100.0, "Livros"),
            new Produto("Livro Python", 80.0, "Livros"),
            new Produto("Livro Algoritmos", 120.0, "Livros"),
            new Produto("Tablet", 1800.0, "Eletrônicos")
        );

        System.out.println("=== Exercício a ===");
        // a. Usando forEach e if tradicional
        System.out.println("Nomes dos produtos da categoria 'Eletrônicos' (forEach + if):");
        for (Produto p : produtos) {
            if (p.getCategoria().equals("Eletrônicos")) {
                System.out.println(p.getNome());
            }
        }

        // a. Usando Stream e filter
        System.out.println("\nNomes dos produtos da categoria 'Eletrônicos' (Stream + filter):");
        produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .forEach(p -> System.out.println(p.getNome()));

        System.out.println("\n=== Exercício b ===");
        // b. Lista apenas com preços > 500
        List<Double> precosAltos = produtos.stream()
                .filter(p -> p.getPreco() > 500)
                .map(Produto::getPreco)
                .collect(Collectors.toList());
        System.out.println("Preços dos produtos acima de 500: " + precosAltos);

        System.out.println("\n=== Exercício c ===");
        // c. Valor total do estoque de 'Livros'
        double totalLivros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Livros"))
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Valor total do estoque de Livros: R$ " + totalLivros);

        System.out.println("\n=== Exercício d ===");
        // d. Método buscarProdutoPorNome
        Optional<Produto> produtoExistente = buscarProdutoPorNome(produtos, "Notebook");
        produtoExistente.ifPresent(p -> System.out.println("Produto encontrado: " + p));

        Optional<Produto> produtoInexistente = buscarProdutoPorNome(produtos, "Computador");
        produtoInexistente.orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        System.out.println("\n=== Exercício f ===");
        // f. Stream com map para obter nomes
        List<String> nomesLambda = produtos.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());
        System.out.println("Nomes com lambda: " + nomesLambda);

        List<String> nomesMetodoReferencia = produtos.stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());
        System.out.println("Nomes com referência de método: " + nomesMetodoReferencia);
    }

    // d. Método que busca produto por nome
    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst();
    }
}