package com.rh.controler;

import com.rh.model.Empleado;
import com.rh.service.EmpleadoServicio;
import com.rh.service.IEmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
  @RequestMapping("rh-app")
//el crossorigin hace que podamos hacer peticiones desde otros puertos
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControler {

    @Autowired
     IEmpleadoServicio empleadoServicio;

    //Obtiene una lista de empleados
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return empleadoServicio.listarEmpleados();
    }

    //Enviar informacion para guardar un empleado
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        return empleadoServicio.GuardarEmpleado(empleado);
    }

    //Buscar la un empleado por el id y muestra la informacion de este
    @GetMapping("empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable int id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorID(id);
        if (empleado != null){
            return ResponseEntity.ok(empleado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //

}
