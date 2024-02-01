package org.pspr.ejemplo_cine.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${aplicacion.nombre}")
    private String nombre;

    @GetMapping("/")
    public String iniciar(Model model){
        model.addAttribute("nombre",nombre);
        return "index";
    }
}
