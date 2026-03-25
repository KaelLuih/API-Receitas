package br.com.weg.receitas.application.ingrediente.dto;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record IngredienteRequisicaoDto(
        @NotBlank
        String nome,
        @NotNull
        @Positive
        String quantidade
) {
}
