//No olvidar crear la carpeta META-INF y un beans.xml
package com.distribuida.manejadores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import com.distribuida.clases.Singer;
import com.distribuida.proxies.SingerImp;

@Named(value = "Mb")
@SessionScoped
public class ManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	SingerImp personaImp = new SingerImp();

	private boolean bandera;
	private List<Singer> lista;
	private Singer persona;

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public Singer getPersona() {
		return persona;
	}

	public void setPersona(Singer persona) {
		this.persona = persona;
	}

	@PostConstruct
	protected void inicializar() {

		persona = new Singer();
		bandera = false;
	}

	public List<Singer> getLista() {
		return lista;
	}

	public void setLista(List<Singer> lista) {
		this.lista = lista;
	}

	public String redireccionTodos() {
		persona = new Singer();
		lista = personaImp.obtenerTodos();
		bandera = false;
		return "personas/personas?faces-redirect=true";
	}

	public void redireccionId() {

		if (persona != null) {
			persona = personaImp.buscarIds(persona.getId());
			bandera = true;
		} else {
			bandera = false;
		}
	}

	public String editar() {
		System.out.println(persona.getBirthDate());
		personaImp.editar(persona);
		lista = personaImp.obtenerTodos();
		return "personas?faces-redirect=true";
	}

	public String crear() {
		personaImp.crear(persona);
		lista = personaImp.obtenerTodos();
		return "personas?faces-redirect=true";
	}
	
	public String eliminar() {
		personaImp.eliminar(persona);
		lista = personaImp.obtenerTodos();
		return "personas?faces-redirect=true";
	}

}
