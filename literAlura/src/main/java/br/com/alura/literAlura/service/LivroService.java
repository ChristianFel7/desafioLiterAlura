package br.com.alura.literAlura.service;


import br.com.alura.literAlura.model.Livro;
import br.com.alura.literAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LivroService {

    @Autowired
    private LivroRepository repositorio;




}
