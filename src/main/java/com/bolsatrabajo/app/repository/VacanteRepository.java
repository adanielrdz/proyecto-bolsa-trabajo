package com.bolsatrabajo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsatrabajo.app.entity.Vacante;

@Repository
public interface VacanteRepository extends JpaRepository<Vacante,Long>{

}
