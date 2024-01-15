package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.repository.DirectorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DirectorService {

    public List<Director>findAllDirector();

    public Optional<Director> findDirectorById(Long id);

    public Director saveDirector(Director director);

    public String deleteDirector(Long id);

    public Director updateDirector(Director director);

    List<Director>findOldDirector();

    List<Director>findDirectorByYear(int year);
    List<Director>findDirectorBetweeenYears(int yearFrom,int yearTo);

}
