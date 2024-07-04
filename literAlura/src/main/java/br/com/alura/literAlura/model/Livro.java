package br.com.alura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    private Long id;


    private String titulo;

    private Integer downloads;

    private List<String> idiomas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "livros_author",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "authors_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Livro(){};

    public Livro(DadosLivro dadosLivro){
        this.id = (long) dadosLivro.id();
        this.titulo = dadosLivro.titulo();
        this.downloads = dadosLivro.downloads();
        this.idiomas =dadosLivro.idiomas();
        for (DadosAuthor author : dadosLivro.authors()) {
            this.authors.add(new Author(author));
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", downloads=" + downloads +
                ", idiomas=" + idiomas +
                ", authors=" + authors +
                '}';
    }

}
