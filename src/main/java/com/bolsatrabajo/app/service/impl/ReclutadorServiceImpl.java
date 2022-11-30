package com.bolsatrabajo.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsatrabajo.app.entity.Reclutador;
import com.bolsatrabajo.app.repository.ReclutadorRepository;
import com.bolsatrabajo.app.service.ReclutadorService;

@Service
public class ReclutadorServiceImpl implements ReclutadorService{

	
	@Autowired
	private ReclutadorRepository reclutadorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Reclutador> findAll() {
		return reclutadorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Reclutador> findAll(Pageable pageable) {
		return reclutadorRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reclutador> findById(Long id) {
		return reclutadorRepository.findById(id);
	}

	@Override
	@Transactional
	public Reclutador save(Reclutador reclutador) {
		return reclutadorRepository.save(reclutador);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		reclutadorRepository.deleteById(id);
	}	

}
