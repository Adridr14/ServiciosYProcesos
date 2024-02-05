package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/")
    public String getPilotosRand(Model model){
        List<Piloto> pilotos=pilotoService.getPilotosRand();
        model.addAttribute("pilotos",pilotos);
        return "index";
    }


}
