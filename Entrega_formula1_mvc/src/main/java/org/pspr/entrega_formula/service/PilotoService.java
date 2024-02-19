package org.pspr.entrega_formula.service;

import org.pspr.entrega_formula.model.Piloto;

import java.util.List;
import java.util.Optional;

public interface PilotoService {

    List<Piloto> getPilotosRand();

    List<Piloto> findAllPiloto();

    Optional<Piloto>findPilotoById(Long id);

    Piloto updatePiloto(Piloto piloto);
}
