package com.example.DlloSoftGrupo4.entidades;

import javax.persistence.*;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    private int nit;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String direccion;

    @Column(nullable = false, length =30, unique = true)
    private int numero;


    public Empresa(int nit, String nombre, String direccion, int numero) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;

    }

    public Empresa() {
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


}