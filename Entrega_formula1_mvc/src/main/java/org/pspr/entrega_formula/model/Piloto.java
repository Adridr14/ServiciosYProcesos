package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pilotos")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilotoId", nullable = false)
    private Long id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "equipo")
    private String equipo;

    @Column(name = "foto")
    private String foto;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "piloto")
    private Set<Resultado> resultados = new LinkedHashSet<>();

}