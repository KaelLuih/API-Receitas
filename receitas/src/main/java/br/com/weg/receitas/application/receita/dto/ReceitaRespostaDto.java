package br.com.weg.receitas.application.receita.dto;

import br.com.weg.receitas.application.ingrediente.dto.IngredienteRespostaDto;
import br.com.weg.receitas.application.passo.dto.PassoRepostaDto;

import java.util.List;

public record ReceitaRespostaDto(
        Long id,
        String nome,
        String descricao,
        Double tempoPreparo,
        Double porcoes,
        String foto,
        List<IngredienteRespostaDto> ingredienteRespostaDtoList,
        List<PassoRepostaDto> PassoRepostaDto
) {
}
