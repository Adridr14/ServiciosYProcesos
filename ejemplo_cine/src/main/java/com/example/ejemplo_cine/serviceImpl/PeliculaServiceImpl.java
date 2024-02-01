package com.example.ejemplo_cine.serviceImpl;

import com.example.ejemplo_cine.modelo.Pelicula;
import com.example.ejemplo_cine.repository.PeliculaRepo;
import com.example.ejemplo_cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepo peliculaRepository;

    @Override
    public List<Pelicula> findAllPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> findByIdPelicula(long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            return peliculaRepository.save(pelicula);

        }return null;
    }

    @Override
    public boolean deletePelicula(long id) {
      Optional<Pelicula>pelicula=peliculaRepository.findById(id);
      if (pelicula.isPresent()){
          peliculaRepository.deleteById(id);
          return true;
      }
        return false;
    }

    @Override
    public Pelicula updatePelicula(Pelicula pelicula) {
        if (peliculaRepository.existsById(pelicula.getIdPelicula())){
            return peliculaRepository.save(pelicula);
        }
        return null;
    }

    @Override
    public List<Pelicula> findByAnyo(int year) {
        return peliculaRepository.findByAnyo(year);
    }

    @Override
    public List<Pelicula> findByDirectorIdDirector(Long id) {
        return peliculaRepository.findByDirectorIdDirector(id);
    }
}
