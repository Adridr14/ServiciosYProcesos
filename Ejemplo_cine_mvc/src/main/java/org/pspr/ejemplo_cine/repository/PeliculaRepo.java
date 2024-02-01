package org.pspr.ejemplo_cine.repository;

import org.pspr.ejemplo_cine.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepo extends JpaRepository<Pelicula, Long> {

    //@Query("SELECT p FROM Pelicula p WHERE p.director.idDirector=?1")
    //List<Pelicula> findByDirectorId(Long Id);

    List<Pelicula> findByDirectorIdDirector(Long idDirector);

    //@Query("SELECT p FROM Pelicula p WHERE p.anyo=?1")
    //List<Pelicula> findPeliculaByYear(int anyo);

    List<Pelicula> findByAnyo(int year);

}
