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
}
