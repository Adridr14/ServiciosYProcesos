package org.pspr.ejemcontroler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/saludo")
    public String saludar(@RequestParam(required = false, defaultValue = "Ana") String nombre){
        return  "Hola "+nombre;
    }

    @GetMapping("/saludo2/{nombre}")
    public String saludar2(@PathVariable String nombre){
        return "Hola "+nombre;
    }
}
