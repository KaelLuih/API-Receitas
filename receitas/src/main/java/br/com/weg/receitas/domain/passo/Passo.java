package br.com.weg.receitas.domain.passo;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer ordem;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;
}
