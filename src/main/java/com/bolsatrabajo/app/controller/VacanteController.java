package com.bolsatrabajo.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsatrabajo.app.entity.Vacante;
import com.bolsatrabajo.app.service.VacanteService;

@RestController
@RequestMapping("/api/vacante")
public class VacanteController {
	
	@Autowired 
	private VacanteService vacanteService;
	
	@GetMapping("/vacantes")
	public ResponseEntity<List<Vacante>> findAll(){
		return ResponseEntity.ok(vacanteService.findAll());
	}
	
	@GetMapping("/vacante/{id}")
	public ResponseEntity<Optional<Vacante>> findById(@PathVariable("id") Long id){
		Optional <Vacante> vacante = vacanteService.findById(id);
		if(!vacante.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vacante);
	}
	
	@PostMapping("/vacante")
	public ResponseEntity<Vacante> save(@RequestBody Vacante vacante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vacanteService.save(vacante));
	}
	
	@PutMapping("/vacante/{id}")
	public ResponseEntity<Vacante> update(@RequestBody Vacante vacanteDetails, @PathVariable("id") Long id) {
		Optional <Vacante> vacante = vacanteService.findById(id);
		if(!vacante.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		vacante.get().setNombre(vacanteDetails.getNombre());
		vacante.get().setDescripcion(vacanteDetails.getDescripcion());
		vacante.get().setSalario(vacanteDetails.getSalario());
		vacante.get().setModalidad(vacanteDetails.getModalidad());
		vacante.get().setActivo(vacanteDetails.getActivo());
		vacante.get().setListaCarreras(vacanteDetails.getListaCarreras());
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(vacanteService.save(vacante.get()));
	}
	
}
