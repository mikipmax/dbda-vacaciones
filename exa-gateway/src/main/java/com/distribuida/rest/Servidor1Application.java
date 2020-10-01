package com.distribuida.rest;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/") 
@ApplicationScoped
public class Servidor1Application extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(RestPrincipal.class);
	}
	
}
