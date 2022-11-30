	package com.bolsatrabajo.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsatrabajo.app.entity.Usuario;
import com.bolsatrabajo.app.repository.UsuarioRepository;
import com.bolsatrabajo.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}