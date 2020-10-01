package com.distribuida.servicios;

import java.util.List;

import com.distribuida.clases.Album;

public interface AlbumI {
	List<Album> listar();
	Album buscarId(int id);
    void editar(int id,Album album);
    void crear(Album album);
    void eliminar(int id);
}
