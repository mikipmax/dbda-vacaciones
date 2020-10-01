package com.distribuida.servidores;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class HolaMundoApp extends Application {
	@Override //consultar
	public Set<Class<?>> getClasses() {
		return Set.of(HolaMundo.class);
	}
}
