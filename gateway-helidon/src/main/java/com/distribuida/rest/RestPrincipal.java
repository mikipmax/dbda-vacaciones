package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.clases.Direccion;
import com.distribuida.clases.Persona;
import com.distribuida.servicios.ServicioDireccion;
import com.distribuida.servicios.ServicioPersona;

@Path("gateway")
@ApplicationScoped
public class RestPrincipal {
	
	//Instancio el servicio de persona y dirección
	private ServicioPersona servicioPersona = new ServicioPersona();
	
	private ServicioDireccion servicioDireccion = new ServicioDireccion();
	
	//Para enviarle información al cliente
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
	
	@POST
	@Path("/personas/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void crear(Persona personas) {
		 servicioPersona.crear(personas);
	}
	
	@GET
	@Path("/direcciones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Direccion> obtenerDirecciones(){		
		return servicioDireccion.listarTodo();
	}
	
	@GET
	@Path("/direcciones/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Direccion obtenerDireccionPorId(@PathParam("id")Integer id) {

		return servicioDireccion.obtenerPorId(id);
		
	}

}
