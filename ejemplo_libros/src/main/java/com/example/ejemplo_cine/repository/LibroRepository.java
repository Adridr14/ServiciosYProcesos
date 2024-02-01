package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository<Libro,Long> {
}
