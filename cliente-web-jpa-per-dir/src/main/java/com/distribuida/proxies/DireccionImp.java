package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.clases.Direccion;

public class DireccionImp {
	private static final String URL = "http://localhost:8080/server-direccion-jpa/direcciones";
	ResteasyClient client = new ResteasyClientBuilder().build();

	public List<Direccion> obtenerTodos() {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL));
		DireccionI proxy = target.proxy(DireccionI.class);
		return proxy.listar();
	}

	public Direccion buscarIds(Direccion direccion) {
		int id = direccion.getIdDireccion();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/" + id));
		DireccionI proxy = target.proxy(DireccionI.class);
		return proxy.buscarId(id);
	}

	public void editar(Direccion direccion) {
		int id = direccion.getIdDireccion();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/editar/" + id));
		DireccionI proxy = target.proxy(DireccionI.class);
		proxy.editar(id, direccion);
	}

	public void crear(Direccion direccion) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/crear"));
		DireccionI proxy = target.proxy(DireccionI.class);
		proxy.crear(direccion);
	}

	public void eliminar(Direccion direccion) {
		int id = direccion.getIdDireccion();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/eliminar/" + id));
		DireccionI proxy = target.proxy(DireccionI.class);
		proxy.eliminar(id);
	}

}
