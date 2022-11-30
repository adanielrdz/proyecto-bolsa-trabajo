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

import com.bolsatrabajo.app.entity.Usuario;
import com.bolsatrabajo.app.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAll (){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Optional<Usuario>> read (@PathVariable (value="id") Long usuarioId){
		Optional <Usuario> usuario= usuarioService.findById(usuarioId);
	 
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> update (@RequestBody Usuario usuarioDetails , @PathVariable (value = "id") Long usuarioId){
		Optional <Usuario> usuario = usuarioService.findById(usuarioId);
		
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.get().setActivo(usuarioDetails.getActivo());
		usuario.get().setClave(usuarioDetails.getClave());
		usuario.get().setCorreo(usuarioDetails.getCorreo());
		usuario.get().setNombre(usuarioDetails.getNombre());
		usuario.get().setTipoUsuario(usuarioDetails.getTipoUsuario());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
		
	}
	
}
