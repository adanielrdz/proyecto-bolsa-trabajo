package com.bolsatrabajo.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsatrabajo.app.entity.Vacante;
import com.bolsatrabajo.app.repository.VacanteRepository;
import com.bolsatrabajo.app.service.VacanteService;


@Service
public class VacanteServiceImpl implements VacanteService{

	
	@Autowired
	private VacanteRepository vacanteRepository;

	@Override
	public Vacante save(Vacante vacante) {
		return vacanteRepository.save(vacante);
	}

	@Override
	public List<Vacante> findAll() {
		List<Vacante> vacantes=new ArrayList<Vacante>();
		vacanteRepository.findAll().forEach(vacante -> vacantes.add(vacante));
		return vacantes;
	}

	@Override
	public Optional<Vacante> findById(Long id) {
		return vacanteRepository.findById(id);
	}

	
	@Override
	public void deleteById(Long id) {
		vacanteRepository.deleteById(id);	
	}
	
	
	
	

}
