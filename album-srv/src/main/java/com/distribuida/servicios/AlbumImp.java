package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.clases.Album;

public class AlbumImp implements AlbumI {
	@Inject
	private DataSource source;

	@Override
	public List<Album> listar() {
		List<Album> listar = new ArrayList<>();
		Connection connection = null;
		try {
			connection = source.getConnection();
			// Realizamos la consulta a la base de datos
			PreparedStatement statement = connection.prepareStatement("select * from album");
			// Ejecutamos la consulta
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Album cantante = new Album();
				// Vamos obteniendo los atributos
				cantante.setId(resultSet.getInt(1));
				cantante.setSingerId(resultSet.getInt(2));
				cantante.setTitle(resultSet.getString(3));

				cantante.setReleaseDate(new java.util.Date(resultSet.getDate(4).getYear(),
						resultSet.getDate(4).getMonth(), resultSet.getDate(4).getDate()));

				listar.add(cantante);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Problemas en la conexión");
		}

		return listar;
	}

	@Override
	public Album buscarId(int id) {
		Connection connection = null;
		Album cantante = new Album();
		try {
//			//Iniciamos la conexión
			connection = source.getConnection();
//			//Creamos sentencia a la base de datos por el identificador de la clase Cantante
			PreparedStatement statement = connection.prepareStatement("select * from album where id = ?");
//			//ejecutamos la sentencia
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cantante.setId(resultSet.getInt(1));
				cantante.setSingerId(resultSet.getInt(2));
				cantante.setTitle(resultSet.getString(3));

				cantante.setReleaseDate(new java.util.Date(resultSet.getDate(4).getYear(),
						resultSet.getDate(4).getMonth(), resultSet.getDate(4).getDate()));
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
	public void editar(int id, Album album) {
		Connection connection = null;
		try {

			int singerId = album.getSingerId();
			String title = album.getTitle();

			connection = source.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("update album set singer_id=?, title=?, release_date=? where id=?");

			statement.setInt(1, singerId);
			statement.setString(2, title);
			statement.setDate(3, new Date(album.getReleaseDate().getYear(), album.getReleaseDate().getMonth(),
					album.getReleaseDate().getDate()));
			statement.setInt(4, id);
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la edición");
		}

	}

	@Override
	public void crear(Album album) {
		Connection connection = null;
		try {

			int id = album.getId();
			int singerId = album.getSingerId();
			String title = album.getTitle();
			connection = source.getConnection();
			PreparedStatement st = connection.prepareStatement(
					"INSERT INTO album(" + "id, singer_id, title, release_date) " + "VALUES (?, ?, ?, ?)");
			st.setInt(1, id);

			st.setInt(2, singerId);
			st.setString(3, title);
			st.setDate(4, new Date(album.getReleaseDate().getYear(), album.getReleaseDate().getMonth(),
					album.getReleaseDate().getDate()));
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

			PreparedStatement st = connection.prepareStatement("DELETE FROM album " + "WHERE id=?");
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
