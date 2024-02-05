package org.pspr.entrega_formula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resultados")
public class Resultado {
    @EmbeddedId
    private ResultadoId id;

    @MapsId("circuitoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "circuitoId", nullable = false)
    private Circuito circuito;

    @MapsId("pilotoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pilotoId", nullable = false)
    private Piloto piloto;

    @Column(name = "posicionLlegada", nullable = false)
    private Integer posicionLlegada;

    @Column(name = "posicionSalida", nullable = false)
    private Integer posicionSalida;

}