package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepo extends JpaRepository<Pelicula,Long> {

    List<Pelicula> findByAnyo(int year);
    List<Pelicula>findByDirectorIdDirector(Long id);
}
