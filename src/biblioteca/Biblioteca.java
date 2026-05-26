package biblioteca;

import autor.Autor;
import cliente.Cliente;
import emprestimo.Emprestimo;
import livro.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Biblioteca {
    private final List<Livro> livros;
    private final List<Autor> autores;
    private final List<Emprestimo> emprestimos;
    private final List<Cliente> clientes;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = livros.stream()
                .filter(Livro::isDisponivel)
                .toList();
        System.out.println(livrosDisponiveis);
    }

    public void realizarEmprestimo(UUID idLivro, String nomeCliente) {
        Livro livro = livros.stream()
                .filter(l -> l.getCodigo().equals(idLivro) && l.isDisponivel())
                .findFirst().orElse(null);

        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);

        if (livro == null) {
            System.out.println("Livro não encontrado ou não disponivel.");
            return;
        }

        if (cliente == null){
            System.out.println("Cliente não cadastrado!");
            return;
        }

        removeLivro(livro);
        livro.setDisponivel(false);
        cadastrarLivro(livro);
        Emprestimo emprestimo = new Emprestimo(livro, cliente, LocalDate.now());
        emprestimos.add(emprestimo);

    }

    public void devolverLivro(UUID idLivro, String nomeCliente) {
        Livro livro = livros.stream()
                .filter(l -> l.getCodigo().equals(idLivro) && (!l.isDisponivel()))
                .findFirst().orElse(null);

        Cliente cliente = clientes.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);

        if (livro == null) {
            System.out.println("Livro não encontrado ou já entregue.");
            return;
        }

        if (cliente == null){
            System.out.println("Cliente não cadastrado!");
            return;
        }

        removeLivro(livro);
        livro.setDisponivel(true);
        cadastrarLivro(livro);

    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {livros.remove(livro);}

    public void cadastrarAutor(Autor autor) {
        autores.add(autor);
    }

    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        Livro livro = livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

        return livro;
    }

    public Livro buscarLivroPorAutor(String nomeAutor) {
        Livro livro = livros.stream()
                .filter(l -> l.getAutor().getNome().equalsIgnoreCase(nomeAutor))
                .findFirst()
                .orElse(null);
        return livro;
    }

    public void listarLivrosPorGenero(String genero) {
        List<Livro> filterLivrosPorGenero = livros.stream()
                .filter(livro -> livro.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public void listarLivrosPorDataCadastro(LocalDate data) {
        List<Livro> filterLivrosPorDataCadastro = livros.stream()
                .filter(livro -> livro.getDataCadastro().isAfter(data) || livro.getDataCadastro().isEqual(data))
                .toList();
    }
}
