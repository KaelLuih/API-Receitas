package br.com.weg.receitas.application.receita.dto;

import br.com.weg.receitas.application.ingrediente.dto.IngredienteRespostaDto;
import br.com.weg.receitas.application.passo.dto.PassoRepostaDto;

import java.util.List;

public record ReceitaRequisicaoDto(String nome,
                                   String descricao,
                                   String tempoPreparo,
                                   String porcoes,
                                   List<IngredienteRespostaDto> ingredienteRespostaDtoList,
                                   List<br.com.weg.receitas.application.passo.dto.PassoRepostaDto> PassoRepostaDto) {
}
