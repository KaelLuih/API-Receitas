package br.com.weg.receitas.application.ingrediente.dto;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.persistence.*;

public record IngredienteRespostaDto(

                                     long id,
                                     String nome,
                                     double quantidade,
                                     Receita receita
) {
}
