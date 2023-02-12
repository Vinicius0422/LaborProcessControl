package br.com.vinicius.LaborProcessControl.services.interfaces;

import br.com.vinicius.LaborProcessControl.dtos.DefendantDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DefendantServiceIntfc {

    ResponseEntity<List<DefendantDto>> findAll();
    ResponseEntity<DefendantDto> findById(Long id);
    ResponseEntity<List<DefendantDto>> findByName(String name);
    ResponseEntity<List<DefendantDto>> findByCnpj(String cnpj);
    ResponseEntity<DefendantDto> save(DefendantDto defendantDto);
    ResponseEntity<DefendantDto> update(Long id, DefendantDto defendantDto);
}
