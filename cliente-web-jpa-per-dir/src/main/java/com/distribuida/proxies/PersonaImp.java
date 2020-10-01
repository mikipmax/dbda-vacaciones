package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.clases.Persona;

public class PersonaImp {
	private static final String URL = "http://localhost:8080/server-persona-jpa/personas";
	ResteasyClient client = new ResteasyClientBuilder().build();

	public List<Persona> obtenerTodos() {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL));
		PersonaI proxy = target.proxy(PersonaI.class);
		return proxy.listar();
	}

	public Persona buscarIds(int id) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/" + id));
		PersonaI proxy = target.proxy(PersonaI.class);
		return proxy.buscarId(id);
	}

	public void editar(Persona persona) {
		int id = persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/editar/" + id));
		PersonaI proxy = target.proxy(PersonaI.class);
		proxy.editar(id, persona);
	}

	public void crear(Persona persona) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/crear"));
		PersonaI proxy = target.proxy(PersonaI.class);
		proxy.crear(persona);
	}

	public void eliminar(Persona persona) {
		int id=persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/eliminar/"+id));
		PersonaI proxy = target.proxy(PersonaI.class);
		proxy.eliminar(id);
	}
}
