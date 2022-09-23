package com.example.DlloSoftGrupo4.entidades;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="Empleado")

public class Empleado {

    //Atributos

    @Id
    private int documentoEmpleado;

    @Column(nullable = false,length = 30)
    private String nombreEmpleado;

    @Column(nullable = false,length = 30)
    private String correoEmpleado;

    @Column(nullable = false,length = 30)
    private String rolEmpleado;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action=OnDeleteAction.CASCADE)
   @JoinColumn(name="nit_empresa")
    Empresa empresa;




    // constructores


    public Empleado(int documentoEmpleado, String nombreEmpleado, String correoEmpleado, String rolEmpleado, Empresa empresa ) {
        this.documentoEmpleado = documentoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresa = empresa;

    }

    public Empleado() {
    }

    // Getter y Setter


    public int getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(int documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }


    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getNit() {
        return empresa;
    }

    public void setNit(Empresa empresa) {
        this.empresa = empresa;
    }
}