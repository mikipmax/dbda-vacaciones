package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


import com.distribuida.clases.Singer;

public class SingerImp {
	private static final String URL = "http://localhost:8080/singer-srv/singers";
	ResteasyClient client = new ResteasyClientBuilder().build();

	public List<Singer> obtenerTodos() {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL));
		SingerI proxy = target.proxy(SingerI.class);
		return proxy.listar();
	}

	public Singer buscarIds(int id) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/" + id));
		SingerI proxy = target.proxy(SingerI.class);
		return proxy.buscarId(id);
	}

	public void editar(Singer persona) {
		int id = persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/editar/" + id));
		SingerI proxy = target.proxy(SingerI.class);
		proxy.editar(id, persona);
	}

	public void crear(Singer persona) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/crear"));
		SingerI proxy = target.proxy(SingerI.class);
		proxy.crear(persona);
	}

	public void eliminar(Singer persona) {
		int id=persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/eliminar/"+id));
		SingerI proxy = target.proxy(SingerI.class);
		proxy.eliminar(id);
	}
}
