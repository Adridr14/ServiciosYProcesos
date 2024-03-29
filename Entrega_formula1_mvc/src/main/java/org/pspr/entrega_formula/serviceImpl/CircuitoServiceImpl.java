package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.repository.CircuitoRepository;
import org.pspr.entrega_formula.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitoServiceImpl implements CircuitoService {
    @Autowired
    private CircuitoRepository circuitoRepository;
    @Override
    public List<Circuito> findAllCircuito() {
        return circuitoRepository.findAll();
    }

    @Override
    public Optional<Circuito> findCircuitoById(Long id) {
        return circuitoRepository.findById(id);
    }
}
