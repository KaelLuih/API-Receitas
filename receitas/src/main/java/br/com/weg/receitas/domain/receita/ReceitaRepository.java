package br.com.weg.receitas.domain.receita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByNome(String nome);

    List<Receita> findByTempoPreparoBetween(Double tempoMin,Double tempoMax);

    List<Receita> findByPorcoes(double porcao);

    List<Receita> findByIngredientes_Nome(@Param("nomeIngrediente") String nomeIngrediente);
}
