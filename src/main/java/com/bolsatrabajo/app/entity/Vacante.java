package com.bolsatrabajo.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="vacante")
public class Vacante implements Serializable{
	
	private static final long serialVersionUID = 3410523599561209245L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="horario")
	private String horario;
	
	@Column(name="salario")
	private Integer salario;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="modalidad")
	private String modalidad;
	
	@Column(name="contradado")
	private Integer contratado;
	
	@Column(name="postulado")
	private Integer postulado;
	
	@Column(name="activo")
	private Boolean activo;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaCreacion")
	private Date fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaModificacion")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="recluatadorId",nullable = false)
	private Reclutador reclutador;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name= "vacante_aspirante",
		joinColumns= @JoinColumn(name="vacanteId"),
		inverseJoinColumns =@JoinColumn(name="aspiranteId")
	)
	private Set<Aspirante> listaAspirantes;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name= "vacante_carrera",
		joinColumns= @JoinColumn(name="vacanteId"),
		inverseJoinColumns =@JoinColumn(name="carreraId")
	)
	private Set<Carrera> listaCarreras;
	
	

}
