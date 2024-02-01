package com.example.ejemplo_cine.serviceImpl;

import com.example.ejemplo_cine.modelo.Departamento;
import com.example.ejemplo_cine.modelo.Empleado;
import com.example.ejemplo_cine.repository.EmpleadoRepo;
import com.example.ejemplo_cine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepo repositoryEmplead;

    @Override
    public List<Empleado> getEmpleados() {
        return repositoryEmplead.findAll();
    }

    @Override
    public Optional<Empleado> findById(String id) {
        Optional<Empleado> empleado=repositoryEmplead.findById(id);
        if (empleado.isPresent()){
            return empleado;
        }
        return null;
    }

    @Override
    public Empleado agregarEmpleado(Empleado empleado) {
        if (empleado!=null){
            return repositoryEmplead.save(empleado);
        }
        return null;
    }

    @Override
    public String deleteEmpleadosByDni(String id) {
        Optional<Empleado> empleado=repositoryEmplead.findById(id);
        if (empleado.isPresent()){
            repositoryEmplead.deleteEmpleadosByDni(id);
            return "Empleado eliminidado satisfactoriamente";
        }
        return "El empleado no existe";
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado) {
        if (repositoryEmplead.findById(empleado.getDni()).isPresent()){
            return repositoryEmplead.save(empleado);
        }
        return null;
    }

    @Override
    public List<Empleado> findEmpleadosByDepartamento_Id(int id) {
        return repositoryEmplead.findEmpleadosByDepartamento_Id(id);
    }

    @Override
    public List<Empleado> findEmpleadosByApellidosStartsWith(String subcadena) {
        return repositoryEmplead.findEmpleadosByApellidosStartsWith(subcadena);
    }
}
