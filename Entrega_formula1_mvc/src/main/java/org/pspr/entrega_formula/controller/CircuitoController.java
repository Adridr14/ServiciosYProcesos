package org.pspr.entrega_formula.controller;

import lombok.Data;
import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/circuito")
public class CircuitoController {

    @Autowired
    private CircuitoService circuitoService;
    @GetMapping("")
    public String getCircuitos(Model model){
        List<Circuito>circuitos=circuitoService.findAllCircuito();
        model.addAttribute("circuitos",circuitos);
        return "circuito/circuitos";
    }

    @GetMapping("/{id}")
    public  String getPilotoById(@PathVariable Long id, Model model){
        Optional<Circuito> circuito=circuitoService.findCircuitoById(id);
        if (circuito.isPresent()){
            model.addAttribute("circuito",circuito.get());
        }else {
            model.addAttribute("msg","No se encuentra circuito para ese id: "+id);
        }
        return "circuito/circuito";
    }


}
