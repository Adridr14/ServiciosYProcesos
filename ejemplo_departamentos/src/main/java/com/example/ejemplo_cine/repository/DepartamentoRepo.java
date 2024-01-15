package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepo extends JpaRepository<Departamento, Long> {
}
