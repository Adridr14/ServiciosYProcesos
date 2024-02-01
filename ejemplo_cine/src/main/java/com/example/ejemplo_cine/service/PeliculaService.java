package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Pelicula;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PeliculaService {
    List<Pelicula> findAllPeliculas();

    Optional<Pelicula>findByIdPelicula(long id);

    Pelicula savePelicula(Pelicula pelicula);

    boolean deletePelicula(long id);

    Pelicula updatePelicula(Pelicula pelicula);

    List<Pelicula> findByAnyo(int year);

    List<Pelicula>findByDirectorIdDirector(Long id);
}
