package com.bolsatrabajo.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="carrera")
public class Carrera implements Serializable {

	private static final long serialVersionUID = 5873911663898293108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(mappedBy="listaCarreras")
	private Set<Vacante> llistaVacantes;
	
}
