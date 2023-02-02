package br.com.vinicius.LaborProcessControl.repositories;

import br.com.vinicius.LaborProcessControl.entities.LawSuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawSuitRepository extends JpaRepository<LawSuit, Long> {
}
