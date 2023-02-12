package br.com.vinicius.LaborProcessControl.repositories;

import br.com.vinicius.LaborProcessControl.entities.Defendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefendantRepository extends JpaRepository<Defendant, Long> {
    List<Defendant> findByNameContains(String name);
    List<Defendant> findByCnpjContains(String cnpj);
    boolean existsByCnpj(String cnpj);
    Defendant findByCnpjEquals(String cnpj);
}
