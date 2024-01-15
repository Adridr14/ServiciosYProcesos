package com.example.ejemplo_cine.serviceImpl;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.repository.DirectorRepo;
import com.example.ejemplo_cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepo directoRepository;
    @Override
    public List<Director> findAllDirector() {
        return directoRepository.findAll();
    }

    @Override
    public Optional<Director> findDirectorById(Long id) {
        return directoRepository.findById(id);
    }

    @Override
    public Director saveDirector(Director director) {
        if (director!=null){
           return directoRepository.save(director);
        }
        return null;
    }

    @Override
    public String deleteDirector(Long id) {
        Optional<Director> director=directoRepository.findById(id);
        if (director.isPresent()){
            directoRepository.deleteById(id);
            return "Director eliminidado satisfactoriamente";
        }
        return "El director no existe";
    }

    @Override
    public Director updateDirector(Director director) {
        if (directoRepository.findById(director.getIdDirector()).isPresent()){
            return directoRepository.save(director);
        }
        return null;
    }

    @Override
    public List<Director> findOldDirector() {
        return directoRepository.findOldDirector();
    }

    @Override
    public List<Director> findDirectorByYear(int year) {
        return directoRepository.findDirectorByYear(year);
    }

    @Override
    public List<Director> findDirectorBetweeenYears(int yearFrom, int yearTo) {
        return directoRepository.findDirectorBetweeenYears(yearFrom,yearTo);
    }
}
