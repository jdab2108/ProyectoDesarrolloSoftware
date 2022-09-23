package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.Empresa;

import java.util.List;
import java.util.Map;

public interface ServicioEmpresa {

    public List<Empresa> ListarEmpresa();

    public Empresa guardarEmpresas(Empresa empresas);

    public Empresa actualizarEmpresas(Empresa empresas);

    public void eliminarEmpresasporId(Integer nit);

    public Empresa actualizarPorId(Integer nit, Map<Object, Object> objectMap);

    public Empresa consultarEmpresaPorId(Integer nit);

}