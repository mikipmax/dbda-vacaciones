package com.distribuida.rest;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//Entrada principal de la aplicación
@ApplicationPath("/") 
@ApplicationScoped
public class ApplicationServer extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		return Set.of(RestPrincipal.class);
	}
	
}
