package br.com.weg.receitas.application.ingrediente.dto;

import br.com.weg.receitas.domain.receita.Receita;

public record IngredienteRespostaDto(
        Long id,
        String nome,
        Double quantidade,
        Receita receita
) {
}
