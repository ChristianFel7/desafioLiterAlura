package br.com.alura.literAlura.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private Integer nascimento;

    private Integer falecimento;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Livro> livros = new ArrayList<>();

    public Author(){}

    public Author (DadosAuthor dadosAuthor){
        this.nome = dadosAuthor.nome();

        this.nascimento = dadosAuthor.nascimento();

        this.falecimento = dadosAuthor.falecimento();

    }

    public Author(Author author) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNascimento() {
        return nascimento;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(Integer falecimento) {
        this.falecimento = falecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }


    @Override
    public String toString() {
        return "Autor: " + nome +
                ", Ano de Nascimento: " + (nascimento == null ? "Data não informada": nascimento)+
                ", Ano de Morte: " + (falecimento == null ?
                "Data não informada" : falecimento) ;
    }



}
