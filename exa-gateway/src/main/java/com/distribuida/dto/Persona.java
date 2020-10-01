package com.distribuida.dto;

import java.io.Serializable;

public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String nombre;

	private String cedula;

	private String direccion;

	private Integer tipoDireccion;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Integer tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	
	
	

}
