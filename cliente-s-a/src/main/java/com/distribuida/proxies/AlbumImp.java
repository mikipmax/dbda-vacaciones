package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.clases.Album;



public class AlbumImp {
	private static final String URL = "http://localhost:8080/album-srv/albums";
	ResteasyClient client = new ResteasyClientBuilder().build();

	public List<Album> obtenerTodos() {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL));
		AlbumI proxy = target.proxy(AlbumI.class);
		return proxy.listar();
	}

	public Album buscarIds(int id) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/" + id));
		AlbumI proxy = target.proxy(AlbumI.class);
		return proxy.buscarId(id);
	}

	public void editar(Album persona) {
		int id = persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/editar/" + id));
		AlbumI proxy = target.proxy(AlbumI.class);
		proxy.editar(id, persona);
	}

	public void crear(Album persona) {
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/crear"));
		AlbumI proxy = target.proxy(AlbumI.class);
		proxy.crear(persona);
	}

	public void eliminar(Album persona) {
		int id=persona.getId();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL + "/eliminar/"+id));
		AlbumI proxy = target.proxy(AlbumI.class);
		proxy.eliminar(id);
	}
}
