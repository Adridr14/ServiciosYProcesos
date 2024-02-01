package com.example.ejemplo_cine.repository;

import com.example.ejemplo_cine.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepo extends JpaRepository<Empleado,Long> {
Optional<Empleado>findById(String id);

String deleteEmpleadosByDni(String id);

List<Empleado> findEmpleadosByDepartamento_Id(int id);

List<Empleado> findEmpleadosByApellidosStartsWith(String subcadena);

}
