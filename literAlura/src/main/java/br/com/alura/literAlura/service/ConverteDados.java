package br.com.alura.literAlura.service;
import br.com.alura.literAlura.model.DadosLivro;
import br.com.alura.literAlura.model.Livro;
import br.com.alura.literAlura.model.Livros;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConverteDados implements iConverteDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {

        
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> converteLivro (Livros livros) {
        return livros.livros().stream()
                .map(this::conversorParaLivro)
                .collect(Collectors.toList());
    }

    private Livro conversorParaLivro(DadosLivro dadosLivro) {

        return new Livro(dadosLivro);
    }

}