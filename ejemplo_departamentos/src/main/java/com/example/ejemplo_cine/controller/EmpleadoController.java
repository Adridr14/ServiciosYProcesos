package com.example.ejemplo_cine.controller;

import com.example.ejemplo_cine.modelo.Empleado;
import com.example.ejemplo_cine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> getEmpleados(){
        return empleadoService.getEmpleados();
    }
    @GetMapping("/emleado/{id}")
    public Optional<Empleado> getEmpleadoById(@PathVariable String id){
        return empleadoService.findById(id);
    }
    @PostMapping("/departamento/{idDepartamento}/empleado")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
      return   empleadoService.agregarEmpleado(empleado);
    }
    @PutMapping("/empleado")
    public Empleado modificarEmpleado(@RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(empleado);
    }
    @DeleteMapping("/empleado/{id}")
    public String borrarEmpleado(@PathVariable String id){
        return empleadoService.deleteEmpleadosByDni(id);
    }

    @GetMapping("/empleado/departamento/{idDepartamento}")
    public List<Empleado> getEmpleadosByDepartamento(@PathVariable int idDepartamento){
        return empleadoService.findEmpleadosByDepartamento_Id(idDepartamento);
    }

    @GetMapping("/empleado/apellidoEmpiezaPor/{subcadena}")
    public List<Empleado> getEmpleadosByApellido(@PathVariable String subcadena){
        return empleadoService.findEmpleadosByApellidosStartsWith(subcadena);
    }
}
