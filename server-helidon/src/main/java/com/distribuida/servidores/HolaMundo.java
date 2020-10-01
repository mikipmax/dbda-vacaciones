package com.distribuida.servidores;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hm")
@RequestScoped
public class HolaMundo {
	 @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public String message() {
	        return "Hello World";
	    }
}
