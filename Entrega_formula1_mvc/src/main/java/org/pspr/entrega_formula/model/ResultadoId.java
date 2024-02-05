package org.pspr.entrega_formula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ResultadoId implements Serializable {
    private static final long serialVersionUID = -8115218006815323276L;
    @Column(name = "circuitoId", nullable = false)
    private Long circuitoId;

    @Column(name = "pilotoId", nullable = false)
    private Long pilotoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResultadoId entity = (ResultadoId) o;
        return Objects.equals(this.circuitoId, entity.circuitoId) &&
                Objects.equals(this.pilotoId, entity.pilotoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(circuitoId, pilotoId);
    }

}