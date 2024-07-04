package br.com.alura.literAlura.principal;

import br.com.alura.literAlura.model.Author;
import br.com.alura.literAlura.model.DadosLivro;
import br.com.alura.literAlura.model.Livro;
import br.com.alura.literAlura.model.Livros;
import br.com.alura.literAlura.repository.AuthorsRepository;
import br.com.alura.literAlura.repository.LivroRepository;
import br.com.alura.literAlura.service.ConsumoAPI;
import br.com.alura.literAlura.service.ConverteDados;
import br.com.alura.literAlura.service.LivroService;

import java.util.*;


public class Principal {


    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://gutendex.com/books/?";

    private List<DadosLivro> dadosLivros = new ArrayList<>();

    private List<Livro> livroBusca = new ArrayList<>();
    private List<Author> authorBusca = new ArrayList<>();

    private LivroRepository repositorio;
    private final LivroService livroService;
    private AuthorsRepository authorsRepository;
    private Optional<Livro> livroBuscado;

    public Principal(LivroRepository repositorio, AuthorsRepository authorRepositorio, LivroService livroService1) {
        this.repositorio = repositorio;
        this.authorsRepository = authorRepositorio;
        this.livroService = livroService1;
    }




    public void exibeMenu() {

        var opcao = -1;
        while(opcao != 0) {
            var menu = """
                    ********************************
                    Bem vindo ao sistema de consulta de livros!
                    
                    Escolha uma opção:
                    
                    1 - Buscar livros pelo título ou autor
                    2 - Buscar livros pelo Id
                    3 - Listar livros salvos
                    4 - Listar autores salvos
                    5 - Listar autores vivos em determinado ano
                    6 - Listar livros em determinado idioma        
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarPorTituloOuAutor();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    listarLivrosBuscadas();
                    break;
                case 4:
                    listarAutoresBuscados();
                    break;
                case 5:
                    buscarPorAno();
                    break;
                case 6:
                    buscarPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarPorTituloOuAutor() {
        Livros dadosLivro = getDadosLivro();
        System.out.println(dadosLivro);
        if (dadosLivro.count() == 0){
            System.out.println("nrnhum livro encontrado");
            exibeMenu();
        }else {
            System.out.println("** Foram encontrados " + dadosLivro.count() + " livros ");
            dadosLivro.livros().forEach(System.out::println);
            buscarPorId();
        }
//        Livro livro = new Livro(dadosLivro.livros());
//        repositorio.save(livro);
//        System.out.println(livro);
    }

    private Livros getDadosLivro(){
        System.out.println("Digite o nome do livro ou do autor para busca");
        var nome = leitura.nextLine();
        System.out.println(ENDERECO + "search=" + nome.toLowerCase().replace(" ", "%20"));
        var json = consumo.obterDados(ENDERECO + "search=" + nome.toLowerCase().replace(" ", "%20"));
        Livros dadosLivro = conversor.obterDados(json, Livros.class);
        return dadosLivro;

    }

    private void buscarPorId() {
        System.out.println("Digite o ID do livro desejado: ");
        var id = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + "ids=" + id);

        Livros livros = conversor.obterDados(json, Livros.class);

        Livro livro = conversor.converteLivro(livros).get(0);
        System.out.println(livro);

        buscarLivroPorId(id).ifPresentOrElse(
                b -> {},
                () -> repositorio.save(livro)
        );

    }


    public Optional<Livro> buscarLivroPorId(String id) {
        return repositorio.findById(Long.parseLong(id));
    }

    private void listarLivrosBuscadas() {
        System.out.println("********************************");
        repositorio.findAll();
    }

    private void listarAutoresBuscados() {
        authorsRepository.findAll();

        livroBusca.stream()
                .forEach(System.out::println);

        
    }

    private void buscarPorAno() {
        
    }

    private void buscarPorIdioma() {
        
    }

    public void saveAuthor(Author author){
        authorsRepository.save(author);
    }


}

