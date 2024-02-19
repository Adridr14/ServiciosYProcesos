package org.pspr.entrega_formula.controller;

import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/piloto")
public class PilotoController {
    @Autowired PilotoService pilotoService;

    @GetMapping("")
    public String getPilotos(Model model){
        List<Piloto>pilotos=pilotoService.findAllPiloto();
        model.addAttribute("pilotos",pilotos);
        System.out.println(pilotos.toString());
        return "piloto/pilotos";
    }

    @GetMapping("/{id}")
    public  String getPilotoById(@PathVariable Long id, Model model){
        Optional<Piloto> piloto=pilotoService.findPilotoById(id);
        if (piloto.isPresent()){
            model.addAttribute("piloto",piloto.get());
        }else {
            model.addAttribute("msg","No se encuentra piloto para ese id: "+id);
        }
        return "piloto/piloto";
    }

    @GetMapping("/update/{id}")
    public String editarPiloto(@PathVariable Long id, Model model){
        Optional<Piloto>piloto=pilotoService.findPilotoById(id);
        if (piloto.isPresent()){
            model.addAttribute("piloto",piloto.get());
            model.addAttribute("nuevo",false);
            return "piloto/pilotoForm";
        }else {
            return "redirect:/piloto";
        }
    }
    @PostMapping("/save")
    public String savePiloto(@ModelAttribute Piloto piloto){
        if (piloto!=null ){
            Optional<Piloto> pilotoT=pilotoService.findPilotoById(piloto.getId());
        }
        pilotoService.updatePiloto(piloto);
        return "redirect:/piloto";
    }

    @GetMapping("/add")
    public String addPiloto(Model model){
        Piloto piloto= new Piloto();
        model.addAttribute("piloto",piloto);
        model.addAttribute("nuevo",true);

        return "piloto/pilotoForm";
    }




}
