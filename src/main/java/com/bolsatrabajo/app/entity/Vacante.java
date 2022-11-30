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

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
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

	
	
	public Vacante() {
		
	}
	
	public Vacante(Long id, String nombre, String descripcion, String horario, Integer salario, String localidad,
			String modalidad, Integer contratado, Integer postulado, Boolean activo, Date fechaCreacion,
			Date fechaModificacion, Reclutador reclutador, Set<Aspirante> listaAspirantes, Set<Carrera> listaCarreras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horario = horario;
		this.salario = salario;
		this.localidad = localidad;
		this.modalidad = modalidad;
		this.contratado = contratado;
		this.postulado = postulado;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.reclutador = reclutador;
		this.listaAspirantes = listaAspirantes;
		this.listaCarreras = listaCarreras;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Integer getContratado() {
		return contratado;
	}

	public void setContratado(Integer contratado) {
		this.contratado = contratado;
	}

	public Integer getPostulado() {
		return postulado;
	}

	public void setPostulado(Integer postulado) {
		this.postulado = postulado;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Reclutador getReclutador() {
		return reclutador;
	}

	public void setReclutador(Reclutador reclutador) {
		this.reclutador = reclutador;
	}

	public Set<Aspirante> getListaAspirantes() {
		return listaAspirantes;
	}

	public void setListaAspirantes(Set<Aspirante> listaAspirantes) {
		this.listaAspirantes = listaAspirantes;
	}

	public Set<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(Set<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	

}
