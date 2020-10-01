package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;


import com.distribuida.clases.Singer;
@ApplicationScoped
public class SingerImp implements SingerI{

	
	@Inject
	private DataSource source;
	
	
	@Override
	public List<Singer> listar() {
		List<Singer> listar = new ArrayList<>();
		Connection connection = null;
		try {
			connection = source.getConnection();
			// Realizamos la consulta a la base de datos
			PreparedStatement statement = connection.prepareStatement("select * from singer");
			// Ejecutamos la consulta
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Singer cantante = new Singer();
				// Vamos obteniendo los atributos
				cantante.setId(resultSet.getInt(1));
				cantante.setFirstName(resultSet.getString(2));
				cantante.setLastName(resultSet.getString(3));
				
				cantante.setBirthDate( resultSet.getDate(4));
				
				
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
	public Singer buscarId(int id) {
		Connection connection = null;
		Singer cantante = new Singer();
		try {
//			//Iniciamos la conexión
			connection = source.getConnection();
//			//Creamos sentencia a la base de datos por el identificador de la clase Cantante
			PreparedStatement statement = connection.prepareStatement("select * from singer where id = ?");
//			//ejecutamos la sentencia
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cantante.setId(resultSet.getInt(1));
				cantante.setFirstName(resultSet.getString(2));
				cantante.setLastName(resultSet.getString(3));
				
				cantante.setBirthDate(resultSet.getDate(4));
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
	public void editar(int id, Singer singer) {
		Connection connection = null;
		try {
			
			
			
			String nombre = singer.getFirstName();
			String apellido=singer.getLastName();
			 
					
			connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"update singer set  first_name=?, last_name=?, birth_date=? where id=?");

			

			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setDate(3, new  Date(singer.getBirthDate().getYear(), singer.getBirthDate().getMonth(), singer.getBirthDate().getDate()) );
		
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
	public void crear(Singer singer) {
		Connection connection = null;
		try {
			int id = singer.getId();
			String nombre = singer.getFirstName();
			String apellido=singer.getLastName();
			connection = source.getConnection();
			PreparedStatement st = connection.prepareStatement("INSERT INTO singer(" + 
					"id, first_name, last_name, birth_date) " + 
					"VALUES (?, ?, ?, ?)");
			st.setInt(1, id);
		
			st.setString(2, nombre);
			st.setString(3, apellido);
			st.setDate(4, new Date(singer.getBirthDate().getYear(), singer.getBirthDate().getMonth(), singer.getBirthDate().getDate()));
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
		Connection connection=null;
		try {
			connection=source.getConnection();
			
			PreparedStatement st=connection.prepareStatement("DELETE FROM singer " + 
					"WHERE id=?");
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
