package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.repositorio.RepositorioMovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServicioMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ServiciosImpMovimientoDinero implements ServicioMovimientoDinero {
    @Autowired
    private RepositorioMovimientoDinero repositorioMovimientoDinero;

    @Override
    public List<MovimientoDinero> listarMovimientoDinero() {
        return repositorioMovimientoDinero.findAll();
    }

    @Override
    public MovimientoDinero guardarMovimientos(MovimientoDinero movDinero) {
        return repositorioMovimientoDinero.save(movDinero);
    }

    @Override
    public MovimientoDinero consultarMovimientosPorID(Integer codigo) {
        return repositorioMovimientoDinero.findById(codigo).get();
    }

    @Override
    public MovimientoDinero actualizarMovimientos(MovimientoDinero movDinero) {
        return repositorioMovimientoDinero.save(movDinero);
    }

    public void eliminarMovimientos(Integer codigo) {
        repositorioMovimientoDinero.deleteById(codigo);

    }

    @Override
    public MovimientoDinero actualizarporID(Integer codigo, Map<Object, Object> objectMap){
        MovimientoDinero movDinero= repositorioMovimientoDinero.findById(codigo).get();
        objectMap.forEach((key,value)->{
            Field field = ReflectionUtils.findField(MovimientoDinero.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,movDinero, value);
        });
        return repositorioMovimientoDinero.save(movDinero);
    }

    @Override
    public List<MovimientoDinero> encontrarmovimientosporNit(String movDinero) {

            List<MovimientoDinero> movimientoDinero= new ArrayList<>();
           List<MovimientoDinero>  movimientoDineroList= repositorioMovimientoDinero.findAll();
            return movimientoDinero;

    }

    @Override
    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer nit) {
        return repositorioMovimientoDinero.findByEmpresa(nit);
    }
}
