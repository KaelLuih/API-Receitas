package br.com.weg.receitas.domain.passo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassoRepository extends JpaRepository<Passo, Long> {
}
