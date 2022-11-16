package com.bolsatrabajo.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="aspirante")
public class Aspirante implements Serializable {

	private static final long serialVersionUID = -2597526960120597113L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="correoUniversitario")
	private String correoUniversitario;
	
	@Column(name="fechaEgreso")
	private Integer fechaEgreso;//anioEgreso

	@Column(name="genero")
	private String genero;
	
	@Column(name="archivoCV")
	private String archivoCV;
	
	@Column(name="rutaArchivoCV")
	private String rutaArchivoCV;
	
	@Column(name="rutaImagen")
	private String rutaImagen;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="municipio")
	private String municipio;
	
	@Column(name="activo")
	private Boolean activo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fechaNacimiento")
	private Date fechaNacimiento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaCreacion")
	private Date fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaModificacion")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="carreraId",nullable = false)
	private Carrera carrera;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="usuarioId",nullable = false)
	private Usuario usuario;
	
	
	
}
