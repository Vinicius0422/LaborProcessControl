package br.com.vinicius.LaborProcessControl.repositories;

import br.com.vinicius.LaborProcessControl.entities.Defendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefendantRepository extends JpaRepository<Defendant, Long> {
}
