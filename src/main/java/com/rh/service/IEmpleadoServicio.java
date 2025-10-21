package com.rh.service;

import com.rh.model.Empleado;

import java.util.List;

public interface IEmpleadoServicio {

    public List<Empleado> listarEmpleados();

    public Empleado buscarEmpleadoPorID(Integer id);

    public Empleado GuardarEmpleado(Empleado empleado);

    public void EliminarEmpleado(Empleado empleado);
}
