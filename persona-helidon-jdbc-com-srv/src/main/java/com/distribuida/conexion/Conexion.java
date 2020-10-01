package com.distribuida.conexion;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
@ApplicationScoped
public class Conexion {
	private static final String CADENA = "jdbc:postgresql://localhost:5432/ejemplo";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String USAURIO = "postgres";
	private static final String PASSWORD = "admin";

	//devuelve un objeto que vamos a utilizar
	@ApplicationScoped
	@Produces
	public DataSource dataSource() {
		BasicDataSource db = new BasicDataSource();
		db.setDriverClassName(DRIVER);
		db.setUrl(CADENA);
		db.setUsername(USAURIO);
		db.setPassword(PASSWORD);
		
		return db;
		
	}
}
