package br.com.vinicius.LaborProcessControl.services.implementacoes;

import br.com.vinicius.LaborProcessControl.dtos.DefendantDto;
import br.com.vinicius.LaborProcessControl.entities.Defendant;
import br.com.vinicius.LaborProcessControl.repositories.DefendantRepository;
import br.com.vinicius.LaborProcessControl.responses.SaveResponse;
import br.com.vinicius.LaborProcessControl.services.interfaces.DefendantServiceIntfc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DefendantServiceImpl implements DefendantServiceIntfc {

    @Autowired
    DefendantRepository defendantRepository;
    @Override
    public ResponseEntity findAll() {
        var defendants = defendantRepository.findAll();
        if(defendants.isEmpty()){
            return ResponseEntity.ok("No records found!");
        }
        List<DefendantDto> defendantDtos = new ArrayList<>();
        defendants.stream().forEach(d -> {
            DefendantDto defendantDto = new DefendantDto();
            BeanUtils.copyProperties(d, defendantDto);
            defendantDtos.add(defendantDto);
        });
        return ResponseEntity.ok(defendantDtos);
    }

    @Override
    public ResponseEntity findById(Long id) {
        var defendant = defendantRepository.findById(id);
        if(!defendant.isPresent()){
            return ResponseEntity.ok("No records found for this ID!");
        }
        DefendantDto defendantDto = new DefendantDto();
        BeanUtils.copyProperties(defendant.get(), defendantDto);
        return ResponseEntity.ok(defendantDto);
    }
    @Override
    public ResponseEntity findByName(String name) {
        var defendants = defendantRepository.findByNameContains(name);
        if(defendants.isEmpty()){
            return ResponseEntity.ok("No records found for this name");
        }
        List<DefendantDto> defendantDtos = new ArrayList<>();
        defendants.stream().forEach(d -> {
            DefendantDto defendantDto = new DefendantDto();
            BeanUtils.copyProperties(d, defendantDto);
            defendantDtos.add(defendantDto);
        });
        return ResponseEntity.ok(defendantDtos);
    }

    @Override
    public ResponseEntity findByCnpj(String cnpj) {
        var defendants = defendantRepository.findByCnpjContains(cnpj);
        if(defendants.isEmpty()){
            return ResponseEntity.ok("No records found for this CNPJ!");
        }
        List<DefendantDto> defendantDtos = new ArrayList<>();
        defendants.stream().forEach(d -> {
            DefendantDto defendantDto = new DefendantDto();
            BeanUtils.copyProperties(d, defendantDto);
            defendantDtos.add(defendantDto);
        });
        return ResponseEntity.ok(defendantDtos);
    }

    @Override
    public ResponseEntity save(DefendantDto defendantDto) {
        SaveResponse response = new SaveResponse();
        if(defendantRepository.existsByCnpj(defendantDto.getCnpj())){
            response.setErrors(Collections.singletonList("This CNPJ is already registered!"));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.getErrors());
        }
        Defendant defendant = new Defendant();
        BeanUtils.copyProperties(defendantDto, defendant);
        defendant.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        defendantRepository.save(defendant);
        response.setMessageSucess("Salvo com sucesso");
        return ResponseEntity.ok(response.getMessageSucess());
    }

    @Override
    public ResponseEntity update(Long id, DefendantDto defendantDto) {
        var defendantToChange = defendantRepository.findById(id);
        if(!defendantToChange.isPresent()){
            return ResponseEntity.ok("No records found for this ID!");
        }
        SaveResponse response = new SaveResponse();
        var validation = defendantRepository.existsByCnpj(defendantDto.getCnpj());
        if(validation){
            var cnpjCheckId = defendantRepository.findByCnpjEquals(defendantDto.getCnpj()).getDefendantId();
            if(validation && cnpjCheckId != id) {
                response.setErrors(Collections.singletonList("This CNPJ is already registered!"));
                return ResponseEntity.status(HttpStatus.CONFLICT).body(response.getErrors());
            }
        }
        Defendant defendant = new Defendant();
        BeanUtils.copyProperties(defendantDto, defendant);
        defendant.setDefendantId(defendantToChange.get().getDefendantId());
        defendant.setRegistrationDate(defendantToChange.get().getRegistrationDate());
        defendant.setLogUpdate(LocalDateTime.now(ZoneId.of("UTC")));
        defendantRepository.save(defendant);
        response.setMessageSucess("Atualizado com sucesso!");
        return ResponseEntity.ok(response.getMessageSucess());
    }
}
