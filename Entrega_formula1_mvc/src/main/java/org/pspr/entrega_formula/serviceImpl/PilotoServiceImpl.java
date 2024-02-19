package org.pspr.entrega_formula.serviceImpl;

import lombok.Setter;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.repository.PilotoRepository;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServiceImpl implements PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;
    @Override
    public List<Piloto> getPilotosRand() {
        return pilotoRepository.getPilotosRand();
    }

    @Override
    public List<Piloto> findAllPiloto() {
        return pilotoRepository.findAll();
    }

    @Override
    public Optional<Piloto> findPilotoById(Long id) {
        return pilotoRepository.findById(id);
    }

    @Override
    public Piloto updatePiloto(Piloto piloto) {
        if (pilotoRepository.existsById(piloto.getId())){
        return pilotoRepository.save(piloto);
        }else {
            return null;
        }

    }
}
