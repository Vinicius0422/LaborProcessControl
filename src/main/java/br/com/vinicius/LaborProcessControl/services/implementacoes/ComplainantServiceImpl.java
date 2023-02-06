package br.com.vinicius.LaborProcessControl.services.implementacoes;

import br.com.vinicius.LaborProcessControl.dtos.ComplainantDto;
import br.com.vinicius.LaborProcessControl.entities.Complainant;
import br.com.vinicius.LaborProcessControl.repositories.ComplainantRepository;
import br.com.vinicius.LaborProcessControl.responses.SaveResponse;
import br.com.vinicius.LaborProcessControl.services.interfaces.ComplainantServiceIntfc;
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
import java.util.Optional;

@Service
public class ComplainantServiceImpl implements ComplainantServiceIntfc {

    @Autowired
    ComplainantRepository complainantRepository;

    @Override
    public ResponseEntity findAll() {
        var complainants = complainantRepository.findAll();
        List<ComplainantDto> complainantDtoList = new ArrayList<>();
        complainants.stream().forEach(c -> {
            ComplainantDto complainantDto = new ComplainantDto();
            BeanUtils.copyProperties(c, complainantDto);
            complainantDtoList.add(complainantDto);
        });
        if(complainantDtoList.isEmpty()){
            return ResponseEntity.ok("No records found!");
        }
        return ResponseEntity.ok(complainantDtoList);
    }

    @Override
    public ResponseEntity findById(Long id) {
        var complainant = complainantRepository.findById(id);
        if(!complainant.isPresent()){
            return ResponseEntity.ok("No records found for this ID!");
        }
        ComplainantDto complainantDto = new ComplainantDto();
        BeanUtils.copyProperties(complainant.get(), complainantDto);
        return ResponseEntity.ok(complainantDto);
    }

    @Override
    public ResponseEntity findByName(String name) {
        var result = complainantRepository.findByNameContains(name);
        if(result.isEmpty()){
            return ResponseEntity.ok("No records found for this name!");
        }
        List<ComplainantDto> complainantsDto = new ArrayList<ComplainantDto>();
        result.stream().forEach(r -> {
            ComplainantDto complainantDto = new ComplainantDto();
            BeanUtils.copyProperties(r, complainantDto);
            complainantsDto.add(complainantDto);
        });
        return ResponseEntity.ok(complainantsDto);
    }

    @Override
    public ResponseEntity findByCpf(String cpf) {
        var result = complainantRepository.findByCpfContains(cpf);
        if(result.isEmpty()){
            return ResponseEntity.ok("No records found for this CPF!");
        }
        List<ComplainantDto> complainantsDto = new ArrayList<>();
        result.stream().forEach(r -> {
            ComplainantDto complainantDto = new ComplainantDto();
            BeanUtils.copyProperties(r, complainantDto);
            complainantsDto.add(complainantDto);
        });
        return ResponseEntity.ok(complainantsDto);
    }

    @Override
    public ResponseEntity save(ComplainantDto complainantDto) {
       var validation = complainantValidator(complainantDto);
       SaveResponse saveResponse = new SaveResponse();
       saveResponse.setErrors(validation);
       if(!saveResponse.getErrors().isEmpty()){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(saveResponse.getErrors());
       }
       saveResponse.setMessageSucess("Salvo com sucesso");
       Complainant complainant = new Complainant();
       BeanUtils.copyProperties(complainantDto, complainant);
       complainant.setRegistrationDate(LocalDateTime.now());
       complainantRepository.save(complainant);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveResponse.getMessageSucess());
    }

    @Override
    public ResponseEntity update(Long id, ComplainantDto complainantDto) {
        Optional<Complainant> complainantToUpdate = complainantRepository.findById(id);
        if(!complainantToUpdate.isPresent()){
            return ResponseEntity.ok("Complainant not found!");
        }
        if(!complainantValidatorUpdate(id, complainantDto).isEmpty()){
            SaveResponse response = new SaveResponse();
            response.setErrors(complainantValidatorUpdate(id, complainantDto));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        SaveResponse response = new SaveResponse();
        Complainant complainant = new Complainant();
        BeanUtils.copyProperties(complainantDto, complainant);
        complainant.setComplainantId(complainantToUpdate.get().getComplainantId());
        complainant.setRegistrationDate(complainantToUpdate.get().getRegistrationDate());
        complainant.setLogUpdate(Collections.singletonList(LocalDateTime.now(ZoneId.of("UTC"))));
        complainantRepository.save(complainant);
        response.setMessageSucess("Atualizado com Sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(response.getMessageSucess());
    }

    public List<String> complainantValidator(ComplainantDto complainantDto){
        List<String> list = new ArrayList<>();
        if(complainantRepository.existsByRgAndOrganRg(complainantDto.getRg(), complainantDto.getOrganRg())){
            list.add("This Rg is already registered!");
        }
        if(complainantRepository.existsByCpf(complainantDto.getCpf())){list.add("This CPF is already registered!");}
        if(complainantRepository.existsByBankAndAgencyAndAccount(complainantDto.getBank(),
                complainantDto.getAgency(), complainantDto.getAccount())){list.add("This account is already registered!");}
        return list;
    }

    public List<String> complainantValidatorUpdate(Long id, ComplainantDto complainantDto){
        List<String> errors = new ArrayList<>();
        var cpfCheck = complainantRepository.existsByCpf(complainantDto.getCpf());
        if(cpfCheck){
            var cpfId = complainantRepository.findByCpfEquals(complainantDto.getCpf()).getComplainantId();
            if(cpfCheck && cpfId != id){errors.add("This CPF is already registered");}
        }
        var rgCheck = complainantRepository
                .existsByRgAndOrganRg(complainantDto.getRg(), complainantDto.getOrganRg());
        if(rgCheck){
            var rgId = complainantRepository
                    .findByRgAndOrganRgEquals(complainantDto.getRg(), complainantDto.getOrganRg()).getComplainantId();
            if(rgCheck && rgId != id){errors.add("This RG is already registered!");}
        }
        var bankAgencyAccountCheck =
                complainantRepository.existsByBankAndAgencyAndAccount
                        (complainantDto.getBank(), complainantDto.getAgency(), complainantDto.getAccount());
        if(bankAgencyAccountCheck){
            var accountId =
                    complainantRepository.findByBankAndAgencyAndAccountEquals
                            (complainantDto.getBank(), complainantDto.getAgency(), complainantDto.getAccount())
                            .getComplainantId();
            if(bankAgencyAccountCheck && accountId != id){errors.add("This bank account is already registered!");}
        }
        return errors;
    }
}
