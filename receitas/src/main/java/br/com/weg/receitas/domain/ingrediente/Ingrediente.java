package br.com.weg.receitas.domain.ingrediente;

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


    public Ingrediente(String nome, double quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
