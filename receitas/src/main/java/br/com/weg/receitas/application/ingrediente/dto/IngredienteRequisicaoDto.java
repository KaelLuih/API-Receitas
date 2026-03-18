package br.com.weg.receitas.application.ingrediente.dto;

import br.com.weg.receitas.domain.receita.Receita;

public record IngredienteRequisicaoDto(String nome,
                                       double quantidade,
                                       Receita receita) {
}
