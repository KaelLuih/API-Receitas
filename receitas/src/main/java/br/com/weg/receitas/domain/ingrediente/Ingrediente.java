package br.com.weg.receitas.domain.ingrediente;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingrediente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String quantidade;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

}
