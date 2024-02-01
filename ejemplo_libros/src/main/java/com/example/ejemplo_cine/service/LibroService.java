package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    public List<Libro> findAllLibro();

    public Optional<Libro> findLibroById(Long id);

    public Libro saveLibro(Libro libro);

    public boolean deleteLibro(int id);

    public Libro updateLibro(Libro libro);
}
