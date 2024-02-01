package org.pspr.ejemplo_cine.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="Director")
//@Data
@Getter @Setter
@NoArgsConstructor
public class Director
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirector;
    private String nombre;
    private int anyoNacimiento;

    @OneToMany
    @JoinColumn(name="idDirector")
    private Set<Pelicula> peliculas;
}

