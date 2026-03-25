package br.com.weg.receitas.application.ingrediente;

import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredienteService{

    public void validarIngrediente(Ingrediente ingrediente) {
        if(ingrediente.getNome() == null || ingrediente.getNome().isBlank()){
            throw new RuntimeException("Ingrediente deve ter nome!");
        }
        if(ingrediente.getQuantidade() < 1){
            throw new RuntimeException("Quantidade inválida!");
        }
    }
}
