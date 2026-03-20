package br.com.weg.receitas.domain.receita;

import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import br.com.weg.receitas.domain.passo.Passo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    private Double tempoPreparo;

    private Double porcoes;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passo> passos;


}
