package com.example.ejemplo_cine.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int ejemplares_vendidos;

    @Column
    private LocalDate fecha_publicacion;

    @Column
    private String isbn;
    @Column
    private String autor;
    @Column
    private String titulo;
}
