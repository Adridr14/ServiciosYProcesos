package org.pspr.entrega_formula.serviceImpl;

import lombok.Setter;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.repository.PilotoRepository;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;
    @Override
    public List<Piloto> getPilotosRand() {
        return pilotoRepository.getPilotosRand();
    }
}
