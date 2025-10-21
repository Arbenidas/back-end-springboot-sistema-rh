package com.rh.service;

import com.rh.model.Empleado;
import com.rh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorID(Integer id) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        return empleado;
    }

    @Override
    public Empleado GuardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void EliminarEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);

    }
}
