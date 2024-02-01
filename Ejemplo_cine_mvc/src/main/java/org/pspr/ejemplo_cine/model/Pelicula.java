package org.pspr.ejemplo_cine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Pelicula")
//@Data
@Getter @Setter
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    private String titulo;

    private int anyo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idDirector", nullable = false)
    private Director director;

}
