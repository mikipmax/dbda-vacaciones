package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


import com.distribuida.clases.Persona;


//Componente de negocio que el contenedor
//va a gestionar
@ApplicationScoped
public class PersonaImpl implements PersonaI {

	@Inject
	private DataSource source;

	

	@Override
	public List<Persona> listar() {
		List<Persona> listar = new ArrayList<>();
		List<Persona> aux = new ArrayList<>();
		Connection connection = null;
		try {
			connection = source.getConnection();
			// Realizamos la consulta a la base de datos
			PreparedStatement statement = connection.prepareStatement("select * from persona");
			// Ejecutamos la consulta
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Persona cantante = new Persona();
				// Vamos obteniendo los atributos
				cantante.setId(resultSet.getInt(1));
				cantante.setCedula(resultSet.getInt(2));
				cantante.setDireccion(resultSet.getString(3));
				cantante.setNombre(resultSet.getString(4));
				cantante.setTipoDireccion(resultSet.getInt(5));
				listar.add(cantante);
			}

			

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Problemas en la conexión");
		}
//		 return result;
		return listar;

	}

	@Override
	public Persona buscarId(int id) {
		Connection connection = null;
		Persona cantante = new Persona();
		try {
//			//Iniciamos la conexión
			connection = source.getConnection();
//			//Creamos sentencia a la base de datos por el identificador de la clase Cantante
			PreparedStatement statement = connection.prepareStatement("select * from persona where id = ?");
//			//ejecutamos la sentencia
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cantante.setId(resultSet.getInt(1));
				cantante.setCedula(resultSet.getInt(2));
				cantante.setDireccion(resultSet.getString(3));
				cantante.setNombre(resultSet.getString(4));
				cantante.setTipoDireccion(resultSet.getInt(5));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Problemas en la búsqueda");
		}
		return cantante;
	}

	@Override
	public void editar(int id, Persona persona) {
		Connection connection = null;
		try {

			int cedula = persona.getCedula();
			String direccion = persona.getDireccion();
			String nombre = persona.getNombre();
			int tipoDireccion = persona.getTipoDireccion();
			connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update persona set cedula=?, direccion=?, nombre=?, tipo_direccion=? where id=?");

			statement.setInt(1, cedula);

			statement.setString(2, direccion);
			statement.setString(3, nombre);
			statement.setInt(4, tipoDireccion);
			statement.setInt(5, id);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la edición");
		}

	}

	@Override
	public void crear(Persona persona) {
		Connection connection = null;
		try {
			int id = persona.getId();
			int cedula = persona.getCedula();
			String direccion = persona.getDireccion();
			String nombre = persona.getNombre();
			int tipoDireccion = persona.getTipoDireccion();
			connection = source.getConnection();
			PreparedStatement st = connection.prepareStatement("INSERT INTO persona("
					+ "id, cedula, direccion, nombre, tipo_direccion) " + "VALUES (?, ?, ?, ?, ?)");
			st.setInt(1, id);
			st.setInt(2, cedula);
			st.setString(3, direccion);
			st.setString(4, nombre);
			st.setInt(5, tipoDireccion);
			st.executeUpdate();

			st.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la inserción");
		}

	}

	@Override
	public void eliminar(int id) {
		Connection connection = null;
		try {
			connection = source.getConnection();

			PreparedStatement st = connection.prepareStatement("DELETE FROM persona " + "WHERE id=?");
			st.setInt(1, id);
			st.execute();
			st.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la eliminación");
		}

	}

}
