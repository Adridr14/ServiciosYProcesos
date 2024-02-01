package org.pspr.ejemplo_cine.repository;

import org.pspr.ejemplo_cine.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepo extends JpaRepository<Director, Long> {

    //@Query("SELECT d FROM Director d JOIN FETCH d.peliculas")
    //List<Director> findAllDirectoresConPeliculas();

    @Query("SELECT d FROM Director d WHERE d.anyoNacimiento<1960")
    List<Director> findOldDirector();

    List<Director> findByAnyoNacimiento(int year);

    @Query("SELECT d FROM Director d WHERE d.anyoNacimiento BETWEEN ?1 AND ?2")
    List<Director> findDirectorBetweenYears(int yearFrom, int yearTo);
}
