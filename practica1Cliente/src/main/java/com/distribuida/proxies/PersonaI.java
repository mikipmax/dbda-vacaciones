package com.distribuida.proxies;

import java.util.List;

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

public interface PersonaI {
	@GET
	List<Persona> listar();

	@GET
	Persona buscarId(@PathParam("id") int id);

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	void editar(@PathParam("id") int id, Persona persona);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void crear(Persona personas);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	Response eliminar(@PathParam("id") int id);

}
