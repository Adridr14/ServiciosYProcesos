package com.example.ejemplo_cine.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo", nullable = false)
    private Integer id;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Presupuesto")
    private Integer presupuesto;

    @OneToMany(mappedBy = "departamento")
    private Set<Empleado> empleados = new LinkedHashSet<>();

}