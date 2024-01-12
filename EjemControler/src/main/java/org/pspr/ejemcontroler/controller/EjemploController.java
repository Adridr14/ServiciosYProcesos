package org.pspr.ejemcontroler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {

    @GetMapping("/")
    public String bienvenido(){
        return "Bienvenide";
    }

    @GetMapping("/ejemplo")
    public String manejador(@RequestParam(required = false, defaultValue = "000") String codigo){
        return "Tu código es: "+ codigo;
    }
    @GetMapping("/ejemplo2")
    public String manejador(@RequestParam(required = false, defaultValue = "000") String codigo,@RequestParam int edad){
        return "Tu código es: "+ codigo+ " y tu edad: "+edad;
    }

    @GetMapping("/ejemplo/{codigo}")
    public String manejador2(@PathVariable String codigo){
        return  "Tu código es: "+codigo;
    }
}
