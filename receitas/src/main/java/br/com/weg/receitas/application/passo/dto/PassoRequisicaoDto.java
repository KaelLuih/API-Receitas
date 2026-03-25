package br.com.weg.receitas.application.passo.dto;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PassoRequisicaoDto(
        @NotNull
        @Positive
        Integer ordem,
        @NotBlank
        String descricao
) {
}
