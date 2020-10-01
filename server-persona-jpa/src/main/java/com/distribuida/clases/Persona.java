package com.distribuida.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
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

	@Column(name = "tipo_direccion")
	private int tipoDireccion;

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

	public int getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(int tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

}
