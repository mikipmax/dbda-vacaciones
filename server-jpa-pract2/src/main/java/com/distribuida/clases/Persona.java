package com.distribuida.clases;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	// @Column(name="id") //Se usa si es que el nombre en el pojo es diferente en el
	// de la base de datos
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer cedula;
	private String direccion;
	private String nombre;

	@JoinColumn(name = "tipo_direccion", referencedColumnName = "id_direccion")
	@ManyToOne
	private Direccion tipoDireccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Direccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

}
