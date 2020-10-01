package com.distribuida.servicios;

import java.util.List;


import com.distribuida.clases.Singer;

public interface SingerI {

	List<Singer> listar();
	Singer buscarId(int id);
    void editar(int id,Singer singer);
    void crear(Singer singer);
    void eliminar(int id);
}
