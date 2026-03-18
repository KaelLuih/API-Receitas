package br.com.weg.receitas.application.passo.mapper;

import br.com.weg.receitas.application.passo.dto.PassoRepostaDto;
import br.com.weg.receitas.application.passo.dto.PassoRequisicaoDto;
import br.com.weg.receitas.domain.passo.Passo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassoMapper {
    public Passo toEntity(PassoRequisicaoDto requisicao){
        return Passo.builder()
                .ordem(requisicao.ordem())
                .descricao(requisicao.descricao())
                .build();
    }

    public PassoRepostaDto toDTO(Passo passo){
        return new PassoRepostaDto(
                passo.getId(),
                passo.getOrdem(),
                passo.getDescricao()
        );
    }

    public List<Passo> toEntityList(List<PassoRequisicaoDto> passos){
        return passos.stream()
                .map(this::toEntity)
                .toList();
    }
}

