package com.distribuida.clases;

import java.io.Serializable;


//@XmlRootElement
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idDireccion;
	private String descripcion;

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
