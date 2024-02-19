package org.pspr.entrega_formula.serviceImpl;

import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CircuitoServiceImpl implements CircuitoService {
    @Autowired
    private CircuitoService circuitoService;
    @Override
    public List<Circuito> findAllCircuito() {
        return circuitoService.findAllCircuito();
    }
}
