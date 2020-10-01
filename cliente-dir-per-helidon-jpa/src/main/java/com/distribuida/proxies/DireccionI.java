package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.distribuida.clases.Direccion;

public interface DireccionI {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	List<Direccion> listar();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	Direccion buscarId(@PathParam("id") int id);

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	void editar(@PathParam("id") int id, Direccion direccion);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	void crear(Direccion direccion);

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	void eliminar(@PathParam("id") int id);
}
