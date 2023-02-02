package br.com.vinicius.LaborProcessControl.repositories;

import br.com.vinicius.LaborProcessControl.entities.Complainant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainantRepository extends JpaRepository<Complainant, Long> {
}
