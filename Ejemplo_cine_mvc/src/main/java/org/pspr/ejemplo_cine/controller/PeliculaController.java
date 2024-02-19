package org.pspr.ejemplo_cine.controller;

import org.pspr.ejemplo_cine.model.Director;
import org.pspr.ejemplo_cine.model.Pelicula;
import org.pspr.ejemplo_cine.service.DirectorService;
import org.pspr.ejemplo_cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private DirectorService directorService;

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

    @GetMapping("/pelicula/add")
    public String addPelicula(Model model){
        Pelicula pelicula=new Pelicula();
        pelicula.setDirector(new Director());
        List<Director>directors =directorService.findAllDirector();
        model.addAttribute("pelicula",pelicula);
        model.addAttribute("directores",directors);
        model.addAttribute("nuevo",true);
        return "pelicula/peliculaForm";
    }

    @PostMapping("pelicula/save")
    public String savePelicula(@ModelAttribute Pelicula pelicula,@ModelAttribute("idNuevoDirector") Long idNuevoDirector){
        if (idNuevoDirector>0){
            Optional<Director>director=directorService.findDirectorById(idNuevoDirector);
            if (director.isPresent()){
                pelicula.setDirector(director.get());
            }
        }
        peliculaService.savePelicula(pelicula);
        return "redirect:/pelicula";
    }
    @GetMapping("pelicula/update/{id}")
    public String updatePelicula(@PathVariable Long id,Model model){
        Optional<Pelicula>pelicula=peliculaService.findPeliculaById(id);
        if (pelicula.isPresent()){
            model.addAttribute("pelicula",pelicula.get());
            model.addAttribute("nuevo",false);
            return "pelicula/peliculaForm";
        }else {
            return "redirect:/pelicula";
        }
    }
    @GetMapping("pelicula/delete/{id}")
    public String deletePelicula(@PathVariable Long id){
        peliculaService.deletePelicula(id);
        return "redirect:/pelicula";
    }

    @GetMapping("/pelicula/add/director/{id}")
    public String addPeliculaToDirector(@PathVariable Long id, Model model){
        Optional<Director>director=directorService.findDirectorById(id);
        if (director.isPresent()){
            Pelicula pelicula=new Pelicula();
            pelicula.setDirector(director.get());
            model.addAttribute("pelicula",pelicula);
            return "pelicula/peliculaDirectorForm";
        }
        return "redirect:/director";
    }

}
