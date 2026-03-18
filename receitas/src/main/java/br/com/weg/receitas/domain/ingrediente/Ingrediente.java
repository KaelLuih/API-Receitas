package br.com.weg.receitas.domain.ingrediente;

import br.com.weg.receitas.domain.receita.Receita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "ingrediente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    double quantidade;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

}
