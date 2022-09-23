package com.example.DlloSoftGrupo4.repositorio;

import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioMovimientoDinero extends JpaRepository<MovimientoDinero, Integer> {

    @Query(value = "select * from MovimientoDinero where nit = ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer nit);
}
