package br.com.weg.receitas.application.receita.dto;

import br.com.weg.receitas.application.ingrediente.dto.IngredienteRequisicaoDto;
import br.com.weg.receitas.application.passo.dto.PassoRequisicaoDto;

import java.util.List;

public record ReceitaRequisicaoDto(
        String nome,
        String descricao,
        String tempoPreparo,
        Double porcoes,
        List<IngredienteRequisicaoDto> ingredientes,
        List<PassoRequisicaoDto> passos
) {
}
