package br.com.weg.receitas.application.receita.dto;

import br.com.weg.receitas.application.ingrediente.dto.IngredienteRequisicaoDto;
import br.com.weg.receitas.application.passo.dto.PassoRequisicaoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Arrays;
import java.util.List;

public record ReceitaRequisicaoDto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        @Positive
        Double tempoPreparo,
        @NotNull
        @Positive
        Double porcoes,
        @NotNull
        @Valid
        @NotEmpty
        List<IngredienteRequisicaoDto> ingredientes,
        @NotNull
        @Valid
        @NotEmpty
        List<PassoRequisicaoDto> passos
) {


}
