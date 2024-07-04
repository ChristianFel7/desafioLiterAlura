package br.com.alura.literAlura.DTO;

import java.util.List;

public record LivroDTO(Long id,
                       String titulo,
                       Integer downloads,
                       List<String>idiomas) {
}
