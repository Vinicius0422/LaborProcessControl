package br.com.vinicius.LaborProcessControl.controllers;

import br.com.vinicius.LaborProcessControl.dtos.ComplainantDto;
import br.com.vinicius.LaborProcessControl.services.implementacoes.ComplainantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complainant")
public class ComplainantController {

    @Autowired
    ComplainantServiceImpl service;

    @GetMapping
    public ResponseEntity findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping(path = "/filterName/{name}")
    public ResponseEntity findByName(@PathVariable(value = "name") String name){
        return service.findByName(name);
    }

    @GetMapping(path = "/filterCpf/{cpf}")
    public ResponseEntity findByCpf(@PathVariable(value = "cpf") String cpf){
        return service.findByCpf(cpf);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ComplainantDto complainantDto){
        return service.save(complainantDto);
    }

    @PutMapping(path = "/change/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody ComplainantDto complainantDto){
        return service.update(id, complainantDto);
    }
}
