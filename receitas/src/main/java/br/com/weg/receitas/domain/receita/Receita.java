package br.com.weg.receitas.domain.receita;

import br.com.weg.receitas.domain.ingrediente.Ingrediente;
import br.com.weg.receitas.domain.passo.Passo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "receita")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    private String tempoPreparo;

    private Double porcoes;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingrediente> ingredientes;

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passo> passos;
}
