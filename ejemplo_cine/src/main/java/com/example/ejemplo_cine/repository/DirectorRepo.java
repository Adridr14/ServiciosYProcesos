package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director, Long> {

    @Query("SELECT d from Director  d where D.anyoNacimiento<1960")
    List<Director>findOldDirector();

    @Query("SELECT d from Director  d where d.anyoNacimiento=?1")
    List<Director>findDirectorByYear(int year);

    @Query("SELECT d from Director  d where d.anyoNacimiento between ?1 and ?2")
    List<Director>findDirectorBetweeenYears(int yearFrom,int yearTo);
}
