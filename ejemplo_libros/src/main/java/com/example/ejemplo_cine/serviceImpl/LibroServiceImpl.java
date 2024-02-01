package com.example.ejemplo_cine.serviceImpl;

import com.example.ejemplo_cine.modelo.Libro;
import com.example.ejemplo_cine.repository.LibroRepository;
import com.example.ejemplo_cine.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

   @Autowired
   private LibroRepository repositoryLibro;
    @Override
    public List<Libro> findAllLibro() {
        return repositoryLibro.findAll();
    }

    @Override
    public Optional<Libro> findLibroById(Long id) {
        return repositoryLibro.findById(id);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return repositoryLibro.save(libro);
    }

    @Override
    public boolean deleteLibro(int id) {
        Optional<Libro> libro=repositoryLibro.findById(Long.valueOf(id));
        if (libro.isPresent()){
            repositoryLibro.deleteById(Long.valueOf(id));
            return  true;
        }
        return false;
    }

    @Override
    public Libro updateLibro(Libro libro) {
        if (repositoryLibro.findById(libro.getId()).isPresent()){
            return  repositoryLibro.save(libro);
        }
        return  null;
    }
}
