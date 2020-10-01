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


import com.distribuida.clases.Singer;

public interface SingerI {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	List<Singer> listar();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	Singer buscarId(@PathParam("id") int id);

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	void editar(@PathParam("id") int id, Singer persona);

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	void crear(Singer personas);

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	Response eliminar(@PathParam("id") int id);

}
