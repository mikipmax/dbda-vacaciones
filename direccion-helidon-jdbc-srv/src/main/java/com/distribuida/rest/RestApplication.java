package com.distribuida.rest;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class RestApplication extends Application {
	@Override 
	public Set<Class<?>> getClasses() {
		return Set.of(DireccionRest.class);
	}
}
