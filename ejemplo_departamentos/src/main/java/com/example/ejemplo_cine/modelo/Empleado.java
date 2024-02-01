package com.example.ejemplo_cine.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @Column(name = "DNI", nullable = false, length = 8)
    private String dni;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Departamento")
    private Departamento departamento;

}