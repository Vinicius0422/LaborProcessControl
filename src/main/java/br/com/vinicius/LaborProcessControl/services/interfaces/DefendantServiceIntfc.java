package br.com.vinicius.LaborProcessControl.services.interfaces;

import br.com.vinicius.LaborProcessControl.dtos.DefendantDto;
import br.com.vinicius.LaborProcessControl.entities.Defendant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DefendantServiceIntfc {

    List<DefendantDto> findAll();
    DefendantDto findById(Long id);
    List<DefendantDto> findByName(String name);
    List<DefendantDto> findByCnpj(String cnpj);
    DefendantDto save(DefendantDto defendantDto);
    DefendantDto update(DefendantDto defendantDto);
}
