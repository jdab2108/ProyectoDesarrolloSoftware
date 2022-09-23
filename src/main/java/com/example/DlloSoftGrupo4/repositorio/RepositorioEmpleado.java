package com.example.DlloSoftGrupo4.repositorio;

import com.example.DlloSoftGrupo4.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado,Integer> {
}
