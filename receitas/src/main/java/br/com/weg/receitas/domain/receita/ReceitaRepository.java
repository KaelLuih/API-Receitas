package br.com.weg.receitas.domain.receita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByNomeContainingIgnoreCase(String nome);

    List<Receita> findByTempoPreparoBetween(Double tempoMin,Double tempoMax);

    List<Receita> findByPorcoesBetween(double min, double max);

    List<Receita> findByIngredientes_NomeContainingIgnoreCase(@Param("nomeIngrediente") String nomeIngrediente);



}
