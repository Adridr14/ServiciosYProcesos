package com.example.ejemplo_cine.serviceImpl;

import com.example.ejemplo_cine.modelo.Departamento;

import com.example.ejemplo_cine.repository.DepartamentoRepo;
import com.example.ejemplo_cine.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepo departamentoRepository;
    @Override
    public List<Departamento> findAllDepartamento() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> findDepartamentoById(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento saveDepartamento(Departamento departamento) {
        if (departamento!=null){
           return departamentoRepository.save(departamento);
        }
        return null;
    }

    @Override
    public String deleteDepartamento(Long id) {
        Optional<Departamento> departamento=departamentoRepository.findById(id);
        if (departamento.isPresent()){
            departamentoRepository.deleteById(id);
            return "Director eliminidado satisfactoriamente";
        }
        return "El director no existe";
    }

    @Override
    public Departamento updateDepartamento(Departamento departamento) {
        if (departamentoRepository.findById(Long.valueOf(departamento.getId())).isPresent()){
            return departamentoRepository.save(departamento);
        }
        return null;
    }

    @Override
    public String getSumaPresuspuesto() {

        return "Presupuesto total: "+departamentoRepository.getSumaPresuspuesto();
    }
}
