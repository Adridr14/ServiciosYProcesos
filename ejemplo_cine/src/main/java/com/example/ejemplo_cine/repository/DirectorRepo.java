package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<Director, Long> {
}
