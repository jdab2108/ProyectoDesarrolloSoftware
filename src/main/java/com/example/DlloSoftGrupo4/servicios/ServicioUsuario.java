package com.example.DlloSoftGrupo4.servicios;

import com.example.DlloSoftGrupo4.entidades.Usuario;
import com.example.DlloSoftGrupo4.repositorio.RepositorioUsuario;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.Objects;

public class ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public Usuario guardarUsuario(Usuario usuario){
        return this.repositorioUsuario.save(usuario);
    }

    public Usuario buscarPorEmail(String email){
        return this.repositorioUsuario.findByEmail(email);
    }

    public Usuario obtenerUsuario(Map<String, Object> datousuario){
        String email=(String)datousuario.get("email");
        Usuario usuario= buscarPorEmail(email);
        if(usuario==null){
            String nombre=(String) datousuario.get("nickname");
            String image=(String) datousuario.get("picture");
            String amail=(String) datousuario.get("amail");
            Usuario user= new Usuario();
            return guardarUsuario(user);
        }
        System.out.print(usuario.getEmail());
        return usuario;
    }
}
