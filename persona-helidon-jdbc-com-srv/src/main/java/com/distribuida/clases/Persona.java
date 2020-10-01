package com.distribuida.clases;

import java.io.Serializable;


public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cedula;
	private String direccion;
	private String nombre;
	private Integer tipoDireccion;
	private String descripcion; //se añade para establecer la comunicación


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

	public Integer getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Integer tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
