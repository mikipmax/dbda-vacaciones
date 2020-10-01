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
	@Produces(value = MediaType.APPLICATION_JSON) // Es de resteasy no es el produces de injección
	//@Produces(value = MediaType.APPLICATION_XML)
	public List<Persona> listar() {
		return personaI.listar();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Persona buscarId(@PathParam("id") int id) {
		return personaI.buscarId(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/editar/{id}")
	public void editar(@PathParam("id") int id, Persona persona) {
		personaI.editar(id, persona);
	}
	/*
	 * Ejemplo en json { "cedula": 33333, "direccion": "asdf", "nombre": "Winka1",
	 * "tipoDireccion": 1 }
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/crear")
	public void crear(Persona persona) {
		personaI.crear(persona);
	}

	/**
	 * Json para Crear { "id": 3, "cedula": 4444, "direccion": "asdf", "nombre":
	 * "Fred", "tipoDireccion": 1 }
	 */

	// Este ejemplo es enviando una respuesta al postman mediante el uso de Response
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/eliminar/{id}")
	public Response eliminar(@PathParam("id") int id) {
		personaI.eliminar(id);
		return Response.ok().entity("Registro eliminado").build();
	}

}
