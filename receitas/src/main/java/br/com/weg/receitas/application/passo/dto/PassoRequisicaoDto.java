package br.com.weg.receitas.application.passo.dto;

import br.com.weg.receitas.domain.receita.Receita;

public record PassoRequisicaoDto(
        Integer ordem,
        String descricao,
        Receita receita
) {
}
