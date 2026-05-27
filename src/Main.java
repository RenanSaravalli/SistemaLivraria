import autor.Autor;
import biblioteca.Biblioteca;
import cliente.Cliente;
import livro.Livro;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            Biblioteca biblioteca = new Biblioteca();

            System.out.println("--- Sistema Livraria ---");
            System.out.println("[1]  - Cadastrar Livro");
            System.out.println("[2]  - Cadastrar Autor");
            System.out.println("[3]  - Cadastrar Cliente");
            System.out.println("[4]  - Listar livros disponíveis");
            System.out.println("[5]  - Listar livros disponíveis por gênero");
            System.out.println("[6]  - Listar livros disponíveis por data Cadastro");
            System.out.println("[7]  - Realizar Empréstimo");
            System.out.println("[8]  - Realizar Devolução");
            System.out.println("[9]  - Buscar Livro por título");
            System.out.println("[10] - Buscar Livro por Autor");
            System.out.println("[0]  - Para sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println(">> Cadastrando Livro...");
                    String titulo;
                    String genero;
                    LocalDate dataCadastro;
                    String nomeAutor;
                    LocalDate dataNascimentoAutor;

                    System.out.print("Título: ");
                    scanner.nextLine();
                    titulo = scanner.nextLine();

                    System.out.print("Gênero: ");
                    genero = scanner.nextLine();

                    System.out.print("Data de cadastro (AAAA-MM-DD): ");
                    dataCadastro = LocalDate.parse(scanner.next());

                    System.out.println("Nome do autor:");
                    scanner.nextLine();
                    nomeAutor = scanner.nextLine();

                    System.out.println("Data nascimento autor (AAA-MM-DD): ");
                    dataNascimentoAutor = LocalDate.parse(scanner.next());

                    Autor novoAutor = new Autor(nomeAutor, dataNascimentoAutor);

                    Livro novoLivro = new Livro(titulo, novoAutor, genero, dataCadastro);
                    biblioteca.cadastrarLivro(novoLivro);
                    break;
                case 2:
                    String nomeCadastAutor;
                    LocalDate dataNascCadasAutor;
                    System.out.println(">> Cadastrando autor...");
                    System.out.println("Nome do autor:");
                    scanner.nextLine();
                    nomeCadastAutor = scanner.nextLine();

                    System.out.println("Data nascimento autor (AAA-MM-DD): ");
                    dataNascCadasAutor = LocalDate.parse(scanner.next());

                    biblioteca.cadastrarAutor(new Autor(nomeCadastAutor, dataNascCadasAutor));

                    break;

                case 3:
                    System.out.println(">> Cadastrando Cliente...");
                    String nomeCliente;
                    String emailCliente;
                    System.out.println("Nome cliente: ");
                    scanner.nextLine();
                    nomeCliente = scanner.nextLine();

                    System.out.println("Email cliente: ");
                    scanner.nextLine();
                    emailCliente = scanner.nextLine();

                    biblioteca.cadastrarCliente(new Cliente(nomeCliente, emailCliente));
                    break;

                case 4:
                    System.out.println(">> Listando Livros disponíveis...");
                    biblioteca.listarLivrosDisponiveis();
                    break;

                case 5:
                    String generoDeFiltro;
                    System.out.println(">> Listando Livros disponíveis por gênero...");
                    System.out.println("Digite o gênero que deseje listar: ");
                    scanner.nextLine();
                    generoDeFiltro = scanner.nextLine();
                    biblioteca.listarLivrosPorGenero(generoDeFiltro);
                    break;

                case 6:
                    LocalDate dataCadastroDeFiltro;
                    System.out.println(">> Listando Livros disponíveis por data cadastro...");
                    dataCadastroDeFiltro = LocalDate.parse(scanner.next());
                    biblioteca.listarLivrosPorDataCadastro(dataCadastroDeFiltro);
                    break;

                case 7:
                    UUID codigoLivroEmprestimo;
                    String nomeClienteEmprestimo;
                    System.out.println(">> Realizando Empréstimo...");
                    System.out.println("Digite o código do livro para realizar empréstimo");
                    scanner.nextLine();
                    codigoLivroEmprestimo = UUID.fromString(scanner.nextLine());
                    System.out.println("Digite o nome do cliente: ");
                    scanner.nextLine();
                    nomeClienteEmprestimo = scanner.nextLine();
                    biblioteca.realizarEmprestimo(codigoLivroEmprestimo, nomeClienteEmprestimo);
                    break;

                case 8:
                    UUID codigoLivroDevolucao;
                    String nomeClienteDevolucao;
                    System.out.println(">> Realizando devolução...");
                    System.out.println(">> Realizando Empréstimo...");
                    System.out.println("Digite o código do livro para realizar empréstimo");
                    scanner.nextLine();
                    codigoLivroDevolucao = UUID.fromString(scanner.nextLine());
                    System.out.println("Digite o nome do cliente: ");
                    scanner.nextLine();
                    nomeClienteDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(codigoLivroDevolucao, nomeClienteDevolucao);
                    break;

                case 9:
                    System.out.println(">> Buscando livro por título...");
                    break;

                case 10:
                    System.out.println(">> Buscando livro por autor...");
                    break;

                case 0:
                    System.out.println(">> Saindo...");
                    break;

                default:
                    System.out.println(">> Opção inválida!");
            }

        } while (opcao != 0);
    }
}