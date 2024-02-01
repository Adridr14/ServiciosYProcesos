package org.pspr.ejemplo_cine.controller;


import jakarta.websocket.server.PathParam;
import org.pspr.ejemplo_cine.model.Director;
import org.pspr.ejemplo_cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/director")
    public  String getDirectores(Model model){
        List<Director> directores=directorService.findAllDirector();
        model.addAttribute("directores",directores);
        return "director/directores";
    }

    @GetMapping("/director/{id}")
    public String getDirectorById(@PathVariable Long id,Model model){
        Optional<Director> director=directorService.findDirectorById(id);
        if (director.isPresent()){
            model.addAttribute("director",director.get());
        }else {
            model.addAttribute("msg","Sin directores para el id: "+id);
        }
        return "director/director";
    }
}
