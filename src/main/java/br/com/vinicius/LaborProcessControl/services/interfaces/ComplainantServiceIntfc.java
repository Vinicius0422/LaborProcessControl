package br.com.vinicius.LaborProcessControl.services.interfaces;

import br.com.vinicius.LaborProcessControl.dtos.ComplainantDto;
import br.com.vinicius.LaborProcessControl.responses.SaveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplainantServiceIntfc {

    ResponseEntity findAll();
    ResponseEntity<ComplainantDto> findById(Long id);
    ResponseEntity<List<ComplainantDto>> findByName(String name);
    ResponseEntity<List<ComplainantDto>> findByCpf(String cpf);
    ResponseEntity save(ComplainantDto complainantDto);
    ResponseEntity update(Long id, ComplainantDto complainantDto);

}
