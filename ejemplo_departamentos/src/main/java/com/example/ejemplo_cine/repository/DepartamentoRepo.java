package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartamentoRepo extends JpaRepository<Departamento, Long> {

    @Query("select SUM(d.presupuesto )from Departamento d ")
    public String getSumaPresuspuesto();
}
