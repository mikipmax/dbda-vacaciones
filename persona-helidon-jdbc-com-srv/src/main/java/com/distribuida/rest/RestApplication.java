package com.distribuida.rest;


import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;




@ApplicationPath("/")
public class RestApplication extends Application {
	@Override //consultar
	public Set<Class<?>> getClasses() {
		return Set.of(PersonaRest.class);
	}
}
