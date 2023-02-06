package br.com.vinicius.LaborProcessControl.repositories;

import br.com.vinicius.LaborProcessControl.entities.Complainant;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainantRepository extends JpaRepository<Complainant, Long> {

    boolean existsByRgAndOrganRg(String rg, String organRg);
    boolean existsByCpf(String cpf);
    boolean existsByBankAndAgencyAndAccount(String bank, String agency, String account);
    List<Complainant> findByNameContains(String name);
    List<Complainant> findByCpfContains(String cpf);
    Complainant findByRgAndOrganRgEquals(String rg, String organRg);
    Complainant findByCpfEquals(String cpf);
    Complainant findByBankAndAgencyAndAccountEquals(String bank, String agency, String account);
}
