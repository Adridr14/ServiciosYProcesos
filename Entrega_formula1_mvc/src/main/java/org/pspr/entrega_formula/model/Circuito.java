package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "circuitos")
public class Circuito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitoId", nullable = false)
    private Long id;

    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Column(name = "numeroCurvas", nullable = false)
    private Integer numeroCurvas;

    @Column(name = "numeroVueltas", nullable = false)
    private Integer numeroVueltas;

    @Column(name = "foto")
    private String foto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "circuito")
    private Set<Resultado> resultados = new LinkedHashSet<>();

}