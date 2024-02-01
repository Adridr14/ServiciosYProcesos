package com.example.ejemplo_cine.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name ="Pelicula" )
public class Pelicula {
    @Id
    @Column(name = "idPelicula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "anyo")
    private int anyo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDirector")
    private Director director;
}
