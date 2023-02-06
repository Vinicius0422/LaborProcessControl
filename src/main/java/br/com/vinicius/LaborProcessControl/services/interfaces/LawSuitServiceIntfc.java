package br.com.vinicius.LaborProcessControl.services.interfaces;

import br.com.vinicius.LaborProcessControl.dtos.ComplainantDto;
import br.com.vinicius.LaborProcessControl.dtos.DefendantDto;
import br.com.vinicius.LaborProcessControl.dtos.LawSuitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LawSuitServiceIntfc {

    List<LawSuitDto> findAll();
    LawSuitDto findById(Long id);
    List<LawSuitDto> findByLawSuitNumber(String number);
    LawSuitDto saveLawSuit(LawSuitDto lawSuitDto);
    ResponseEntity saveAll(ComplainantDto complainantDto, DefendantDto defendantDto, LawSuitDto lawSuitDto);
    LawSuitDto update(LawSuitDto lawSuitDto);
}
