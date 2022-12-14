package com.example.DlloSoftGrupo4.entidades;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="email")
    private String email;

    @Column(name="imagen")
    private String imagen;

    @Column(name="nomusuario")
    private String nomusuario;

    public Usuario(String id, String email, String imagen, String nomusuario) {
        this.id = id;
        this.email = email;
        this.imagen = imagen;
        this.nomusuario = nomusuario;
    }

    public Usuario(String correo, String image, String nombre) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }
}
