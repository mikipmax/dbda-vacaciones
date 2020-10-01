package com.distribuida.manejadores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.distribuida.clases.Album;

import com.distribuida.proxies.AlbumImp;

@Named(value = "Mba")
@SessionScoped
public class ManagedBeanAlbum implements Serializable{  //No olvidar jamas el serializable porq si no no arranca el servidor tomcat
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AlbumImp albumImp=new AlbumImp();
	
	private List<Album> lista;
	private Album album;
	public List<Album> getLista() {
		return lista;
	}
	public void setLista(List<Album> lista) {
		this.lista = lista;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	@PostConstruct
	protected void inicializar() {

		album = new Album();
		
	}
	
	
	public String redireccionTodos() {
		album = new Album();
		lista = albumImp.obtenerTodos();
	
		return "albums/albums?faces-redirect=true";
	}

	public void redireccionId() {

		if (album != null) {
			album = albumImp.buscarIds(album.getId());
			
		} 
	}

	public String editar() {
		
		albumImp.editar(album);
		lista = albumImp.obtenerTodos();
		return "albums?faces-redirect=true";
	}

	public String crear() {
		albumImp.crear(album);
		lista = albumImp.obtenerTodos();
		return "albums?faces-redirect=true";
	}
	
	public String eliminar() {
		albumImp.eliminar(album);
		lista = albumImp.obtenerTodos();
		return "albums?faces-redirect=true";
	}
}
