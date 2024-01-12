package org.pspr.ejemcontroler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @GetMapping("/suma/{num1}/{num2}")
    public String sumar(@PathVariable int num1,@PathVariable int num2){
        return "Resultado: "+(num1+num2);
    }
    @GetMapping("/resta/{num1}/{num2}")
    public String restar(@PathVariable int num1,@PathVariable int num2){
        return "Resultado: "+(num1-num2);
    }
    @GetMapping("/multiplicacion/{num1}/{num2}")
    public String multiplicar(@PathVariable int num1,@PathVariable int num2){
        return "Resultado: "+(num1*num2);
    }
    @GetMapping("/division/{num1}/{num2}")
    public String dividir(@PathVariable int num1,@PathVariable int num2){
        return "Resultado: "+((double)num1/(double) num2);

    }
}
