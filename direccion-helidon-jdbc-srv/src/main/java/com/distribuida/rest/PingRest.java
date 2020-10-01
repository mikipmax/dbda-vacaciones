package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
public class PingRest {
	
	@GET
	@Path("/pingDireccion")
	@Produces(MediaType.APPLICATION_JSON)
	public String ping() {
		return "ok";
	}
	
}
