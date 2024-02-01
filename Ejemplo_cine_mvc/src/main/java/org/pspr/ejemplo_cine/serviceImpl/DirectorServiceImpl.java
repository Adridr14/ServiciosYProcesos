package org.pspr.ejemplo_cine.serviceImpl;

import org.pspr.ejemplo_cine.model.Director;
import org.pspr.ejemplo_cine.repository.DirectorRepo;
import org.pspr.ejemplo_cine.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepo directorRepository;

    @Override
    public List<Director> findAllDirector() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<Director> findDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public Director saveDirector(Director director) {
        if (director != null) {
            return directorRepository.save(director);
        }
        return null;
    }

    @Override
    public boolean deleteDirector(Long id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isPresent()) {
            directorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Director updateDirector(Director director) {
        if (directorRepository.findById(director.getIdDirector()).isPresent()) {
            return directorRepository.save(director);
        }
        return null;
    }

    @Override
    public List<Director> findOldDirector() {
        return directorRepository.findOldDirector();
    }

    @Override
    public List<Director> findDirectorByYear(int year) {
        return directorRepository.findByAnyoNacimiento(year);
    }

    @Override
    public List<Director> findDirectorBetweenYears(int yearFrom, int yearTo) {
        return directorRepository.findDirectorBetweenYears(yearFrom, yearTo);
    }


}
