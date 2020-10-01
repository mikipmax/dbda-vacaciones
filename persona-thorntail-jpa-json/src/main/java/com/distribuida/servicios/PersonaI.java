package com.distribuida.servicios;

import java.util.List;

import com.distribuida.clases.Persona;

public interface PersonaI {
	List<Persona> listar();
	Persona buscarId(int id);
	void editar(int id, Persona persona);
 
    void crear(Persona persona);
    void eliminar(int id);
    
    
}
