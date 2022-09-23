package com.example.DlloSoftGrupo4.entidades;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.xml.bind.SchemaOutputResolver;


@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {

    //Atributos
    @Id
    private int codigo;

    @Column(name = "monto_movimiento")
    private double montoMovimiento;

    @Column(nullable = false, length = 30)
    private String conceptoMovimiento;


    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="documento_empleado")
    Empleado empleado;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="nit_empresa")
    Empresa empresa;

    //Controladores


    public MovimientoDinero(int codigo, double montoMovimiento, String conceptoMovimiento, Empleado empleado,Empresa empresa) {
        this.codigo = codigo;
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleado = empleado;
        this.empresa = empresa;
    }

    public MovimientoDinero() {
    }


    // Getters y Setter


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
