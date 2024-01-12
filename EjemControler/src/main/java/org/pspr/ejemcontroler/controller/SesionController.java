package org.pspr.ejemcontroler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SesionController {

    @GetMapping("/login/{user}/{password}")
    public String login(@PathVariable String user,@PathVariable String password){
        String user1="admin";
        String password1="1234";

        if (user.equals(user1)&&password.equals(password1)){
            return "login correcto";
        }
        throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,"login incorrecto o expirado");
    }
}
