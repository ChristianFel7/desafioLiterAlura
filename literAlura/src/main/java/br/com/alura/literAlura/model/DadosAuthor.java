package br.com.alura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DadosAuthor(@JsonProperty("name") String nome,
                          @JsonProperty("birth_year") Integer nascimento,
                          @JsonProperty("death_year") Integer falecimento) {
    public Author toEntity() {
        return new Author(this);
    }

    @Override
    public String toString() {
        return "Autor: " + nome +
                ", Ano de Nascimento: " + (nascimento == null ? "Data não informada": nascimento)+
                ", Ano de Morte: " + (falecimento == null ?
                "Data não informada" : falecimento) ;
    }



}
