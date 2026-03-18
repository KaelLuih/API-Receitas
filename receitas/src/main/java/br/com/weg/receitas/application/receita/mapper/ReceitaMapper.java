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
                .porcoes(Double.valueOf(requisicao.porcoes()))
                .ingredientes(requisicao.ingredienteRespostaDtoList().stream()
                        .map(ingDto -> ingredienteMapper.toEntity(ingDto))
                        .toList())
                .passos(requisicao.PassoRepostaDto().stream()
                        .map(passoDto -> passoMapper.toEntity(passoDto))
                        .toList())
                .build();
    }
    public ReceitaRespostaDto toDto(Receita receita) {
        return new ReceitaRespostaDto(
                receita.getId(),
                receita.getNome(),
                receita.getDescricao(),
                receita.getTempoPreparo(),
                String.valueOf(receita.getPorcoes()),

                receita.getIngredientes().stream()
                        .map(ingredienteMapper::toDTO)
                        .toList(),

                receita.getPassos().stream()
                        .map(passoMapper::toDTO)
                        .toList()
        );
    }
    public List<ReceitaRespostaDto> toList(List<Receita> receitas){
        return receitas.stream().map(this::toDto).toList();
    }
}