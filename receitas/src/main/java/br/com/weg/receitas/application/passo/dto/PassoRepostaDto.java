package br.com.weg.receitas.application.passo.dto;

import br.com.weg.receitas.domain.receita.Receita;

public record PassoRepostaDto(
        Long id,
        Integer ordem,
        String descricao
) {
}
