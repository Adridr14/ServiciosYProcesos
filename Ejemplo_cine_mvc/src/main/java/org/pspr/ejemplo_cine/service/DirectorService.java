package org.pspr.ejemplo_cine.service;

import org.pspr.ejemplo_cine.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> findAllDirector();

    Optional<Director> findDirectorById(Long id);

    Director saveDirector(Director director);

    boolean deleteDirector(Long id);

    Director updateDirector(Director director);

    List<Director> findOldDirector();

    List<Director> findDirectorByYear(int year);

    List<Director> findDirectorBetweenYears(int yearFrom, int yearTo);

}
