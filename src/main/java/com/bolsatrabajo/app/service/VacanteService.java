package com.bolsatrabajo.app.service;

import java.util.List;
import java.util.Optional;

import com.bolsatrabajo.app.entity.Vacante;


public interface VacanteService {
	
	public 	Vacante save(Vacante vacante);
	
	public List<Vacante> findAll();
	
	public Optional<Vacante> findById(Long id);
	
	public void deleteById(Long id);
	
	

}
