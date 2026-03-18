package br.com.weg.receitas.application.ingrediente.mapper;

import br.com.weg.receitas.application.ingrediente.dto.IngredienteRespostaDto;
import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredienteMapper {

public Ingrediente toEntity(IngredienteRespostaDto requisicao){
    return Ingrediente.builder()
            .nome(requisicao.nome())
            .quantidade(requisicao.quantidade())
            .receita(requisicao.receita()).build();
}
public IngredienteRespostaDto toDTO(Ingrediente ingrediente){
    return new IngredienteRespostaDto(ingrediente.getId(),ingrediente.getNome(), ingrediente.getQuantidade(), ingrediente.getReceita());
}
public List<IngredienteRespostaDto> toList(List<Ingrediente> ingredientes){
    return ingredientes.stream().map(this::toDTO).toList();
}

}
