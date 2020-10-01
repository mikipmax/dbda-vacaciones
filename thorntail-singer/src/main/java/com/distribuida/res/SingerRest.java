package com.distribuida.res;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.clases.Singer;
import com.distribuida.servicios.SingerServicioI;

@Path(value = "/singers")
@ApplicationScoped
public class SingerRest {

	@Inject
	private SingerServicioI servicio;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Singer> listar(){
		return servicio.listar();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Singer buscar(int id) {
		return servicio.buscar(id);
	}
}
