package com.distribuida.clases;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer cedula;
	private String direccion;
	private String nombre;
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
