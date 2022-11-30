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

import com.bolsatrabajo.app.entity.Reclutador;
import com.bolsatrabajo.app.service.ReclutadorService;

@RestController
@RequestMapping("/api/reclutador")
public class ReclutadorController {
	
	@Autowired
	private ReclutadorService reclutadorService;
	
	//Aqui puede crear un nuevo reclutador
	@PostMapping("/reclutador")
	public ResponseEntity<Reclutador> create(@RequestBody Reclutador reclutador){
		return ResponseEntity.status(HttpStatus.CREATED).body(reclutadorService.save(reclutador));
	}
	
	
	//Aqui podremos buscar la informacion de cada reclutador a traves de su ID
	@GetMapping("/reclutador/{id}")
	public ResponseEntity<Optional<Reclutador>> read (@PathVariable (value = "id") Long reclutadorId){
		Optional <Reclutador> reclutador = reclutadorService.findById(reclutadorId);
	 
		if(!reclutador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reclutador);
	}
	
	//Aqui podemos ver todos los reclutadores
	@GetMapping("/reclutadores")
	public ResponseEntity<List<Reclutador>> findAll (){
		return ResponseEntity.ok(reclutadorService.findAll());
	}
	
	//Aqui actualizamos la informacion del reclutador
	@PutMapping("/reclutador/{id}")
	public ResponseEntity<?> update (@RequestBody Reclutador reclutadorDetails , @PathVariable (value = "id") Long reclutadorId){
		Optional <Reclutador> reclutador = reclutadorService.findById(reclutadorId);
		
		if(!reclutador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		reclutador.get().setPuesto(reclutadorDetails.getPuesto());
		reclutador.get().setCelular(reclutadorDetails.getCelular());
		reclutador.get().setCorreoEmpresa(reclutadorDetails.getCorreoEmpresa());
		reclutador.get().setNombreEmpresa(reclutadorDetails.getNombreEmpresa());
		reclutador.get().setGiroEmpresa(reclutadorDetails.getGiroEmpresa());
		reclutador.get().setDireccionEmpresa(reclutadorDetails.getDireccionEmpresa());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reclutadorService.save(reclutador.get()));
		
	}
	

}
