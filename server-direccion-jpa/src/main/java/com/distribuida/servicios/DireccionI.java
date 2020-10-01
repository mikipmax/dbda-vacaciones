package com.distribuida.servicios;

import java.util.List;

import com.distribuida.clases.Direccion;

public interface DireccionI {
List<Direccion> listar();
Direccion buscarId(int id);
void editar(int id, Direccion direccion);
void crear(Direccion direccion);
void eliminar(int id);
}
