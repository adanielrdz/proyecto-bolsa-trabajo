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
@Table(name="reclutador")
public class Reclutador implements Serializable{


	private static final long serialVersionUID = -7983959872873241580L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="puesto")
	private String puesto;
	
	@Column(name="celular")
	private Integer celular;
	
	@Column(name="correoEmpresa")
	private String correoEmpresa;

	@Column(name="nombreEmpresa")
	private String nombreEmpresa;
	
	@Column(name="giroEmpresa")
	private String giroEmpresa;
	
	@Column(name="direccionEmpresa")
	private String direccionEmpresa;
	
	@Column(name="activo")
	private Boolean activo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaCreacion")
	private Date fechaCreacion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="fechaModificacion")
	private Date fechaModificacion;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="usuarioId",nullable = false)
	private Usuario usuario;

}
