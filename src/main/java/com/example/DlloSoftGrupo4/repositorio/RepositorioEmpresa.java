package com.example.DlloSoftGrupo4.repositorio;

import com.example.DlloSoftGrupo4.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {
}
