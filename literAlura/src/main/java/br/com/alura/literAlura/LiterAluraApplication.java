package br.com.alura.literAlura;

import br.com.alura.literAlura.principal.Principal;
import br.com.alura.literAlura.repository.AuthorsRepository;
import br.com.alura.literAlura.repository.LivroRepository;
import br.com.alura.literAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private LivroRepository repositorio;
	private AuthorsRepository authorsRepositorio;
	private LivroService livroService;


	public static void main(String[] args)
	{
		SpringApplication.run(LiterAluraApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repositorio, authorsRepositorio, livroService);

		principal.exibeMenu();
	}

}
