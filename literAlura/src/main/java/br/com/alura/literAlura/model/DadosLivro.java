package br.com.alura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (@JsonProperty("id") int id,
                          @JsonProperty("title") String titulo,
                          @JsonProperty("authors") List<DadosAuthor> authors,
                          @JsonProperty("languages") List<String> idiomas,
                          @JsonAlias("download_count") Integer downloads
                          ){

    @Override
    public String toString() {
        return "id:" + id + '\n' +
                "Título: " + titulo + '\n' +
                authors + '\n' +
                "Idiomas: " + idiomas + ", Quantidade de downloads: " + downloads + '\n';
    }
}
