package com.example.DlloSoftGrupo4.repositorio;

import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
