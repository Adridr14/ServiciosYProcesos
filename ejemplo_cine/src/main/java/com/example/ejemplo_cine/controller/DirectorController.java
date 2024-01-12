package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/")
    public String iniciar(){
        return "Bienvenido a la API del cine";
    }

    @GetMapping("/director")
    public List<Director> getDirector(){
        return directorService.findAllDirector();
    }

    @GetMapping("director/{id}")
    public Optional<Director> getDirectorById(@PathVariable Long id){
        return directorService.findDirectorById(id);
    }
}
