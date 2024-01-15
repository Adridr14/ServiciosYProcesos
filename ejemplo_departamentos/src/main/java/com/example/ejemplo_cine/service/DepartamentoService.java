package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Departamento;

import java.util.List;
import java.util.Optional;


public interface DepartamentoService {

    public List<Departamento> findAllDepartamento();

    public Optional<Departamento> findDepartamentoById(Long id);

    public Departamento saveDepartamento(Departamento director);

    public String deleteDepartamento(Long id);

    public Departamento updateDepartamento(Departamento departamento);
}
