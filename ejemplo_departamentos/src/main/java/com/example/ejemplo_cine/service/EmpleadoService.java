package com.example.ejemplo_cine.service;

import com.example.ejemplo_cine.modelo.Departamento;
import com.example.ejemplo_cine.modelo.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    public List<Empleado> getEmpleados();

    public Optional<Empleado> findById(String id);

    public Empleado agregarEmpleado(Empleado empleado);

    public String deleteEmpleadosByDni(String id);

    public Empleado updateEmpleado(Empleado empleado);

    List<Empleado> findEmpleadosByDepartamento_Id(int id);

    List<Empleado> findEmpleadosByApellidosStartsWith(String subcadena);

}
