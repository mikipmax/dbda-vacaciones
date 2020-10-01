package com.distribuida.rest;

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

import com.distribuida.clases.Singer;
import com.distribuida.servicios.SingerI;

@ApplicationScoped
@Path("/singers")
public class SingerRest {
	@Inject
	private SingerI singerI;

	@GET
	@Produces(value = MediaType.APPLICATION_XML) // Es de resteasy no es el produces de injección
	// @Produces(value = MediaType.APPLICATION_XML)
	public List<Singer> listar() {
		return singerI.listar();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Singer buscarId(@PathParam("id") int id) {
		return singerI.buscarId(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/editar/{id}")
	public void editar(@PathParam("id") int id, Singer singer) {
		singerI.editar(id, singer);
	}
	/*
	 * Ejemplo en json { "cedula": 33333, "direccion": "asdf", "nombre": "Winka1",
	 * "tipoDireccion": 1 }
	 */

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/crear")
	public void crear(Singer singer) {
		singerI.crear(singer);
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
		singerI.eliminar(id);
		return Response.ok().entity("Registro eliminado").build();
	}
}