package com.distribuida.manejadores;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.distribuida.clases.Direccion;
import com.distribuida.proxies.DireccionImp;

@Named(value = "Mbd")
@SessionScoped
public class ManagedDireccion implements Serializable {

	private static final long serialVersionUID = 1L;

	private DireccionImp direccionImp = new DireccionImp();
	private Direccion direccion;
	private List<Direccion> lista;

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Direccion> getLista() {
		return lista;
	}

	public void setLista(List<Direccion> lista) {
		this.lista = lista;
	}

	@PostConstruct
	protected void init() {
		direccion = new Direccion();
		color = "paper";

	}

	public String listar() {
		lista = direccionImp.obtenerTodos();
		return "direccion/direccion_listar?faces-redirect=true";
	}

	public void buscar() {
		if (direccion != null) {
			direccion = direccionImp.buscarIds(direccion);
		}
	}

	public String editar() {
		direccionImp.editar(direccion);
		lista = direccionImp.obtenerTodos();
		direccion = new Direccion();
		return "direccion_listar?faces-redirect=true";
	}

	public String crear() {
		direccionImp.crear(direccion);
		lista = direccionImp.obtenerTodos();
		direccion = new Direccion();
		return "direccion_listar?faces-redirect=true";
	}

	public String eliminar() {

		direccionImp.eliminar(direccion);
		lista = direccionImp.obtenerTodos();
		direccion = new Direccion();
		return "direccion_listar?faces-redirect=true";

	}

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void cambiarColor() {
//con esto hago que el navegador se redirija a la url q se le asigne.
		try {
			
			ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
			context2.redirect(context2.getApplicationContextPath() + context2.getRequestServletPath());
		
		} catch (IOException e) {
			
		}
	}

}
