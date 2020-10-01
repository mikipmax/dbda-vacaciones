package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.distribuida.clases.Album;



public interface AlbumI {
	@GET
	List<Album> listar();

	@GET
	Album buscarId(@PathParam("id") int id);

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	void editar(@PathParam("id") int id, Album persona);

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	void crear(Album personas);

	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	Response eliminar(@PathParam("id") int id);
}
