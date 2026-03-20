package br.com.weg.receitas.application.receita.mapper;

import br.com.weg.receitas.application.ingrediente.mapper.IngredienteMapper;
import br.com.weg.receitas.application.passo.mapper.PassoMapper;
import br.com.weg.receitas.application.receita.dto.ReceitaRequisicaoDto;
import br.com.weg.receitas.application.receita.dto.ReceitaRespostaDto;
import br.com.weg.receitas.domain.receita.Receita;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReceitaMapper {

    private final IngredienteMapper ingredienteMapper;
    private final PassoMapper passoMapper;

    public Receita toEntity(ReceitaRequisicaoDto requisicao) {
        return Receita.builder()
                .nome(requisicao.nome())
                .descricao(requisicao.descricao())
                .tempoPreparo(requisicao.tempoPreparo())
                .porcoes(requisicao.porcoes())
                .ingredientes(requisicao.ingredientes().stream()
                        .map(ingredienteMapper::toEntity)
                        .toList())
                .passos(requisicao.passos().stream()
                        .map(passoMapper::toEntity)
                        .toList())
                .build();
    }
    public ReceitaRespostaDto toDTO(Receita receita) {
        return new ReceitaRespostaDto(
                receita.getId(),
                receita.getNome(),
                receita.getDescricao(),
                receita.getTempoPreparo(),
                (receita.getPorcoes()),

                receita.getIngredientes().stream()
                        .map(ingredienteMapper::toDTO)
                        .toList(),

                receita.getPassos().stream()
                        .map(passoMapper::toDTO)
                        .toList()
        );
    }
    public List<ReceitaRespostaDto> toDTOList(List<Receita> receitas){
        return receitas.stream().map(this::toDTO).toList();
    }
}