package br.com.vinicius.LaborProcessControl.controllers;

import br.com.vinicius.LaborProcessControl.dtos.DefendantDto;
import br.com.vinicius.LaborProcessControl.services.implementacoes.DefendantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/defendant")
public class DefendantController {

    @Autowired
    DefendantServiceImpl defendantService;

    @GetMapping
    public ResponseEntity findAll(){
        return defendantService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") Long id){
        return defendantService.findById(id);
    }

    @GetMapping(value = "/filtername/{name}")
    public ResponseEntity findByName(@PathVariable(value = "name") String name){
        return defendantService.findByName(name);
    }

    @GetMapping(value = "/filtercnpj/{cnpj}")
    public ResponseEntity findByCnpj(@PathVariable(value = "cnpj") String cnpj){
        return defendantService.findByCnpj(cnpj);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody DefendantDto defendantDto){
        return defendantService.save(defendantDto);
    }

    @PutMapping(value = "change/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody DefendantDto defendantDto){
        return defendantService.update(id, defendantDto);
    }
}
