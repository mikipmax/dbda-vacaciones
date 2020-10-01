package com.distribuida.rest;

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

import com.distribuida.clases.Direccion;

public interface DireccionI {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	List<Direccion> listar();

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)  
	Direccion buscarId(@PathParam("id") int id);
	
	
	
	
}
