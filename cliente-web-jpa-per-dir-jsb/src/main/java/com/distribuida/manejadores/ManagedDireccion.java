package com.distribuida.manejadores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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

}
