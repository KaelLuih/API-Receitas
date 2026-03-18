package br.com.weg.receitas.application.passo.mapper;

import br.com.weg.receitas.application.passo.dto.PassoRepostaDto;
import br.com.weg.receitas.domain.passo.Passo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassoMapper {
    public Passo toEntity(PassoRepostaDto requisicao){
        return Passo.builder()
                .ordem(requisicao.ordem())
                .descricao(requisicao.descricao())
                .receita(requisicao.receita()).build();
    }

    public PassoRepostaDto toDTO(Passo passo){
        return new PassoRepostaDto(passo.getId(), passo.getOrdem(), passo.getDescricao(), passo.getReceita());
    }

    public List<PassoRepostaDto> toList(List<Passo> passos){
        return passos.stream().map(this::toDTO).toList();
    }
}

