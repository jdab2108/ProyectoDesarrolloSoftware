package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ServiciosImpEmpleado implements ServicioEmpleado {


    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    @Override
    public List<Empleado> listarEmpleados() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public Empleado guardarEmpleados(Empleado empleado) {
        return repositorioEmpleado.save(empleado);
    }

    @Override
    public Empleado consultarEmpleadosid(Integer cedula) {
        return repositorioEmpleado.findById(cedula).get();
    }

    @Override
    public Empleado actualizarEmpleados(Empleado empleado) {
        return repositorioEmpleado.save(empleado);
    }

    @Override
    public boolean eliminarEmpleados(Integer cedula) {
        repositorioEmpleado.deleteById(cedula);

        return false;
    }

    @Override
    public Empleado actualizarPorId(Integer documentoEmpleado, Map<Object, Object> objectMap) {
        Empleado empleado= repositorioEmpleado.findById(documentoEmpleado).get();
        objectMap.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Empleado.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, empleado, value);

        });
        return repositorioEmpleado.save(empleado);
    }
}
