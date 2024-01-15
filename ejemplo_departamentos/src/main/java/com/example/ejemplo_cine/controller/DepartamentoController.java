package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Departamento;
import com.example.ejemplo_cine.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/")
    public String iniciar() {return "Bienvenido a la base de datos";}

    @GetMapping("/departamento")
    public List<Departamento> getDepartamento(){return departamentoService.findAllDepartamento();}

    @GetMapping("/departamento/{id}")
    public Optional<Departamento> getDepartamentoById(@PathVariable Long id){
    return  departamentoService.findDepartamentoById(id);
    }

    @PostMapping("/departamento")
    public Departamento addDepartamento(@RequestBody Departamento departamento){
        return departamentoService.saveDepartamento(departamento);
    }

    @DeleteMapping("/director/{id}")
    public String deleteDepartamento(@PathVariable Long id){
        return departamentoService.deleteDepartamento(id);
    }

    @PutMapping("/director")
    public  Departamento updateDepartamento(@RequestBody Departamento departamento){
        return  departamentoService.updateDepartamento(departamento);
    }
}
