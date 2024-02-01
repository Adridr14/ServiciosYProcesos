package org.pspr.ejemplo_cine.service;

import org.pspr.ejemplo_cine.model.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> findAllPelicula();

    Optional<Pelicula> findPeliculaById(Long id);

    List<Pelicula> findPeliculadByAnyo(int year);

    List<Pelicula> findPeliculasByIdDirector(Long id);

    Pelicula savePelicula(Pelicula pelicula);

    boolean deletePelicula(Long id);

    Pelicula updatePelicula(Pelicula pelicula);
}
