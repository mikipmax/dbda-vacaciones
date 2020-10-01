package com.distribuida.rest;
/* Proxy esta formado por una interfaz y una implementación*/

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.clases.Persona;
import com.distribuida.servicios.PersonaI;

@ApplicationScoped
@Path("/personas")
public class PersonaRest {
	@Inject
	private PersonaI personaI;

	@GET
	@Produces(value = MediaType.APPLICATION_XML) // Es de resteasy no es el produces de injección
	public List<Persona> listar() {
		return personaI.listar();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Persona buscarId(@PathParam("id") int id) {
		return personaI.buscarId(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/editar/{id}")
	public void editar(@PathParam("id") int id, Persona persona) {
		personaI.editar(id, persona);
	}
	/*
	 * Ejemplo en json { "cedula": 33333, "direccion": "asdf", "nombre": "Mikipmax",
	 * "tipoDireccion": { "idDireccion": 1, "descripcion": "Norte" } }
	 */

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/crear")
	public void crear(Persona persona) {
		personaI.crear(persona);
	}

	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") int id) {
		personaI.eliminar(id);
	}

}
