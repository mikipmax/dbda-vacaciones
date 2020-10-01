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

import com.distribuida.clases.Direccion;

@ApplicationScoped
public class DireccionImp implements DireccionI {

	@Inject
	private DataSource source;

	@Override
	public List<Direccion> listar() {
		List<Direccion> listar = new ArrayList<>();
		Connection connection = null;
		try {
			connection = source.getConnection();
			// Realizamos la consulta a la base de datos
			PreparedStatement statement = connection.prepareStatement("select * from direccion");
			// Ejecutamos la consulta
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Direccion direccion = new Direccion();
				direccion.setIdDireccion(resultSet.getInt(1));
				direccion.setDescripcion(resultSet.getString(2));
				// Vamos obteniendo los atributos

				listar.add(direccion);
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
	public Direccion buscarId(int id) {

		Connection connection = null;
		Direccion direccion = new Direccion();
		try {
//			//Iniciamos la conexión
			connection = source.getConnection();
//			//Creamos sentencia a la base de datos por el identificador de la clase Cantante
			PreparedStatement statement = connection.prepareStatement("select * from direccion where id_direccion = ?");
//			//ejecutamos la sentencia
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				direccion.setIdDireccion(resultSet.getInt(1));
				direccion.setDescripcion(resultSet.getString(2));

			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Problemas en la búsqueda");
		}
		return direccion;
	}

	@Override
	public void editar(int id, Direccion direccion) {
		Connection connection = null;
		try {

			String desc = direccion.getDescripcion();

			connection = source.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update direccion set descripcion=? where id_direccion=?");

			statement.setString(1, desc);
			statement.setInt(2, id);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la edición");
		}
	}

	@Override
	public void crear(Direccion direccion) {
		Connection connection = null;
		try {
			int id = direccion.getIdDireccion();
			String desc = direccion.getDescripcion();

			connection = source.getConnection();
			PreparedStatement st = connection
					.prepareStatement("INSERT INTO direccion(" + "id_direccion, descripcion) " + "VALUES (?, ?)");
			st.setInt(1, id);

			st.setString(2, desc);

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

			PreparedStatement st = connection.prepareStatement("DELETE FROM direccion " + "WHERE id_direccion=?");
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
