package org.pspr.ejemplo_cine.serviceImpl;

import org.pspr.ejemplo_cine.model.Pelicula;
import org.pspr.ejemplo_cine.repository.PeliculaRepo;
import org.pspr.ejemplo_cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepo peliculaRepository;

    @Override
    public List<Pelicula> findAllPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> findPeliculaById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public List<Pelicula> findPeliculadByAnyo(int year) {
        return peliculaRepository.findByAnyo(year);
    }

    @Override
    public List<Pelicula> findPeliculasByIdDirector(Long id) {
        return peliculaRepository.findByDirectorIdDirector(id);
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            return peliculaRepository.save(pelicula);
        }
        return null;
    }

    @Override
    public boolean deletePelicula(Long id) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        if (pelicula.isPresent()) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Pelicula updatePelicula(Pelicula pelicula) {
        if (peliculaRepository.existsById(pelicula.getIdPelicula())) {
            return peliculaRepository.save(pelicula);
        }
        return null;
    }
}
