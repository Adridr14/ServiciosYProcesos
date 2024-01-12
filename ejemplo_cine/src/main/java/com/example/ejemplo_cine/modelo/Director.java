package com.example.ejemplo_cine.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "director")
@Data @NoArgsConstructor
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDirector")
    private Long idDirector;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="anyoNacimiento")
    private int anyoNacimiento;

}
