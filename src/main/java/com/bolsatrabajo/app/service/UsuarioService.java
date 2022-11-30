package com.bolsatrabajo.app.service;

import java.util.List;
import java.util.Optional;

import com.bolsatrabajo.app.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Optional <Usuario> findById(Long id);
	public Usuario save (Usuario usuario);
}
