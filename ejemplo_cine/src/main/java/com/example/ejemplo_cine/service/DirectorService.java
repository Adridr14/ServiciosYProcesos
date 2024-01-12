package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Director;
import com.example.ejemplo_cine.repository.DirectorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DirectorService {

    public List<Director>findAllDirector();

    public Optional<Director> findDirectorById(Long id);
}
