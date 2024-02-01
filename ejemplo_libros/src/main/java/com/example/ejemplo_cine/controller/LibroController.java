package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Libro;
import com.example.ejemplo_cine.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/api/libro")
    public List<Libro>getAllLibro(){
        return libroService.findAllLibro();
    }
    @GetMapping("/api/libro/{id}")
    public Optional<Libro> getLibroById(@PathVariable int id){
        return libroService.findLibroById(Long.valueOf(id));
    }
    @PostMapping("/api/libro")
    public Libro postLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }
    @PutMapping("/api/libro/{id}")
    public Libro updateLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }
    @DeleteMapping("/api/libro/{id}")
    public String deleteLibro(@PathVariable int id){
        if (libroService.deleteLibro(id)){
            return "Libro borrado con éxito";
        }
        return "No se encuentra el Libro a borrar";
    }
}
