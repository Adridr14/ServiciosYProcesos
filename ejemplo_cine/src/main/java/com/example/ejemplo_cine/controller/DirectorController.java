package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/director")
    public Director addDirector(@RequestBody Director director){
        return directorService.saveDirector(director);
    }
    @DeleteMapping("/director/{id}")
    public String deleteDirector(@PathVariable Long id){
        return directorService.deleteDirector(id);
    }
    @PutMapping("/director")
    public Director updateDirector(@RequestBody Director director){
        return directorService.updateDirector(director);
    }
    @GetMapping("/director/old")
    public List<Director>getDirectorOld(){
        return directorService.findOldDirector();
    }

    @GetMapping("/director/{year")
        public List<Director> getDirectorByYear(@PathVariable int year){
        return directorService.findDirectorByYear(year);
    }
    @GetMapping("/director/anyo/{yearFrom}/{yearTo}")
    public List<Director>getDirectorBetweenYears(@PathVariable int yearFrom,@PathVariable int yearTo){
        return directorService.findDirectorBetweeenYears(yearFrom,yearTo);
    }

}
