package com.bolsatrabajo.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable  {

	private static final long serialVersionUID = -6686390212126065595L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="activo")
	private Boolean activo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaCreacion")
	private Date fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaModificacion")
	private Date fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name="tipoUsuarioId",nullable = false)
	private TipoUsuario tipoUsuario;
	
	@OneToOne(mappedBy="usuario")
	private Aspirante aspirante;

	@OneToOne(mappedBy="usuario")
	private Reclutador reclutador;

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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Aspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}

	public Reclutador getReclutador() {
		return reclutador;
	}

	public void setReclutador(Reclutador reclutador) {
		this.reclutador = reclutador;
	}
	
	
}

