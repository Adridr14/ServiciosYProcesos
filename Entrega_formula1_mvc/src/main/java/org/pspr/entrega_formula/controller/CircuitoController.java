package org.pspr.entrega_formula.controller;

import lombok.Data;
import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.service.CircuitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
