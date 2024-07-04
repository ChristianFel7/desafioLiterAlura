package br.com.alura.literAlura.repository;

import br.com.alura.literAlura.model.Author;
import br.com.alura.literAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Author, Long> {


}
