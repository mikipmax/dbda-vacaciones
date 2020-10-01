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

import com.distribuida.clases.Direccion;
import com.distribuida.servicios.DireccionI;

@ApplicationScoped
@Path("/direcciones")
public class DireccionRest {
	@Inject
	DireccionI direccionI;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Direccion> listar() {
		return direccionI.listar();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{id}")
	public Direccion buscarId(@PathParam("id") int id) {
		return direccionI.buscarId(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/editar/{id}")
	public void editar(@PathParam("id") int id, Direccion direccion) {
		direccionI.editar(id, direccion);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/crear")
	public void crear(Direccion direccion) {
		direccionI.crear(direccion);
	}

	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") int id) {
		direccionI.eliminar(id);
	}

}
