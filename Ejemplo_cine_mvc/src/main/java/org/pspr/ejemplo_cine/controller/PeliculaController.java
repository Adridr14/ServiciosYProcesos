package org.pspr.ejemplo_cine.controller;

import org.pspr.ejemplo_cine.model.Pelicula;
import org.pspr.ejemplo_cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/pelicula")
    public String getPeliculas(Model model){
        List<Pelicula>peliculas=peliculaService.findAllPelicula();
        model.addAttribute("peliculas",peliculas);
        model.addAttribute("todas",true);
        return "pelicula/peliculas";
    }

    @GetMapping("/pelicula/{id}")
    public String getPeliculaById(@PathVariable Long id, Model model){
        Optional<Pelicula> pelicula=peliculaService.findPeliculaById(id);
        if (pelicula.isPresent()){
            model.addAttribute("pelicula",pelicula.get());

        }else {
            model.addAttribute("msg","Sin películas para ese id: "+id);

        }
        return "pelicula/pelicula";
    }


    @GetMapping("/pelicula/director/{id}")
    public  String getPeliculaByIdDirector(@PathVariable Long id, Model model){
        List<Pelicula>peliculas=peliculaService.findPeliculasByIdDirector(id);
        model.addAttribute("peliculas",peliculas);
        model.addAttribute("todas",false);
        model.addAttribute("idDirector",id);
        return "pelicula/peliculas";
    }
}
