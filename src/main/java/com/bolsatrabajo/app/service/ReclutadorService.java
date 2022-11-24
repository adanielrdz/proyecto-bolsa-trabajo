package com.bolsatrabajo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsatrabajo.app.entity.Reclutador;

public interface ReclutadorService {
	
	public List<Reclutador> findAll();
	
	public Page<Reclutador> findAll (Pageable pageable);
	
	public Optional <Reclutador> findById(Long id);
	
	public Reclutador save (Reclutador reclutador);
	
	public void deleteById(Long id);
 
}