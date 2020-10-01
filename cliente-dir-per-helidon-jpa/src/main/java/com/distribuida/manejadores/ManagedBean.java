//No olvidar crear la carpeta META-INF y un beans.xml
package com.distribuida.manejadores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.distribuida.clases.Persona;
import com.distribuida.proxies.PersonaImp;

@Named(value = "Mb")
@SessionScoped
public class ManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	PersonaImp personaImp = new PersonaImp();

	private boolean bandera;
	private List<Persona> lista;
	private Persona persona;

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@PostConstruct
	protected void inicializar() {

		persona = new Persona();
		bandera = false;
	}

	public List<Persona> getLista() {
		return lista;
	}

	public void setLista(List<Persona> lista) {
		this.lista = lista;
	}

	public String redireccionTodos() {
		persona = new Persona();
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
