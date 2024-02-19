package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PilotoRepository extends JpaRepository<Piloto, Long> {

    @Query("SELECT p from Piloto p order by rand() LIMIT 3")
    List<Piloto> getPilotosRand();


}
