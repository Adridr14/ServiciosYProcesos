package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.modelo.Pelicula;
import com.example.ejemplo_cine.service.DirectorService;
import com.example.ejemplo_cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.MidiDevice;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas(){
        List<Pelicula>peliculas=peliculaService.findAllPeliculas();
        if (peliculas == null || peliculas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peliculas,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id){
        Optional<Pelicula> pelicula=peliculaService.findByIdPelicula(id);
        if (pelicula.isPresent()){
            return new ResponseEntity<>(pelicula.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/director/{idDirector}")
    public ResponseEntity<Pelicula> addPelicula(@RequestBody Pelicula pelicula, @PathVariable Long idDirector){
        Optional<Director> director=directorService.findDirectorById(idDirector);
        if (director.isPresent()){
            pelicula.setDirector(director.get());
            return new ResponseEntity<>(peliculaService.savePelicula(pelicula),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePelicula(@PathVariable Long id){
        if (peliculaService.deletePelicula(id)){
            return new ResponseEntity<>("Película eliminada correctamente",HttpStatus.OK);
        }
        return new ResponseEntity<>("La pelicula no se ha encontrado", HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Pelicula>updatePelicula(@RequestBody Pelicula pelicula){
        Pelicula peliculaUpdated=peliculaService.updatePelicula(pelicula);
        if (peliculaUpdated!=null){
            return new ResponseEntity<>(peliculaUpdated,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/anyo/{anyo}")
    public ResponseEntity<List<Pelicula>> getPeliculasByAnyo(@PathVariable int anyo){
        List<Pelicula>peliculas=peliculaService.findByAnyo(anyo);
        if (peliculas == null || peliculas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peliculas,HttpStatus.OK);
    }
    @GetMapping("/director/{idDirector}")
    public ResponseEntity<List<Pelicula>> getPeliculasByDirector(@PathVariable Long idDirector){
        List<Pelicula>peliculas=peliculaService.findByDirectorIdDirector(idDirector);
        if (peliculas == null || peliculas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(peliculas,HttpStatus.OK);
    }
}
