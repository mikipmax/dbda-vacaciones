package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Persona;
import com.distribuida.dto.TipoDireccion;
import com.distribuida.servicios.ServicioDireccion;
import com.distribuida.servicios.ServicioPersona;

@Path("gateway")
@ApplicationScoped
public class RestPrincipal {
	
	private ServicioPersona servicioPersona = new ServicioPersona();
	
	private ServicioDireccion servicioDireccion = new ServicioDireccion();
	
	@GET
	@Path("/personas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> obtenerPersonas(){		
		return servicioPersona.listarTodo();
	}
	
	@GET
	@Path("/personas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona obtenerPersonaPorId(@PathParam("id")Integer id) {
		
		return servicioPersona.obtenerPorId(id);
		
	}
	
	@GET
	@Path("/tipos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDireccion> obtenerDirecciones(){		
		return servicioDireccion.listarTodo();
	}
	
	@GET
	@Path("/tipos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDireccion obtenerDireccionPorId(@PathParam("id")Integer id) {

		return servicioDireccion.obtenerPorId(id);
		
	}

}
